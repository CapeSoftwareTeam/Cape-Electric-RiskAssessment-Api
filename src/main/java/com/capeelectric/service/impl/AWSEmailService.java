package com.capeelectric.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.capeelectric.repository.CustomerDetailsRepository;
import com.capeelectric.util.AWSEmailConfig;
import com.capeelectric.util.Constants;
import com.itextpdf.text.DocumentException;

/**
 * 
 * @author capeelectricsoftware
 *
 */
@Service
public class AWSEmailService {

	private String FROM = Constants.FROM_EMAIL;

	@Value("${app.email.multiple.person.first}")
	private String firstPersonEmail;

	@Value("${app.email.multiple.person.second}")
	private String secondPersonEmail;

	@Value("${app.email.multiple.person.third}")
	private String thirdPersonEmail;

	@Value("${app.email.disable}")
	private String emailDisable;

	@Value("${s3.bucket.name}")
	private String s3BucketName;

	@Value("${access.key.id}")
	private String accessKeyId;

	@Value("${access.key.secret}")
	private String accessKeySecret;

	private static final Logger logger = LoggerFactory.getLogger(AWSEmailService.class);

	@Autowired
	private AWSEmailConfig emailConfig;
	
	/**
	 * Send Email 
	 * @param email
	 * @return
	 * @throws IOException 
	 */
	public  void sendEmail(String email, String content) throws MessagingException {
		
		if(!emailDisable.equalsIgnoreCase("Y")) {
			logger.debug("Inside AWS Email");
			final String TO = email; // {YOUR_RECIPIENT_EMAIL_ADDRESS}

			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", emailConfig.getSMTP_HOST_NAME());
			props.put("mail.smtp.auth", "false");
			props.put("mail.smtp.starttls.enable", "true");

			Session mailSession = Session.getDefaultInstance(props);

			Transport transport = mailSession.getTransport("smtp");

			MimeMessage message = new MimeMessage(mailSession);

			message.setSubject("Welcome to Rush Safety Application");
			message.setContent(content, "text/plain");
			message.setSentDate(new Date());
			message.setFrom(new InternetAddress(FROM));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
			transport.connect(emailConfig.getSMTP_HOST_NAME(), Integer.valueOf(Constants.AWS_EMAIL_PORT), emailConfig.getSMTP_AUTH_USER(), emailConfig.getSMTP_AUTH_PWD());
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		}
		


	}
	
	public  void sendEmailToAdmin(String content) throws MessagingException {

		if(!emailDisable.equalsIgnoreCase("Y")) {
			logger.debug("Inside AWS Email");
			final String TO = firstPersonEmail+","+secondPersonEmail+","+thirdPersonEmail; // {YOUR_RECIPIENT_EMAIL_ADDRESS}

			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", emailConfig.getSMTP_HOST_NAME());
			props.put("mail.smtp.auth", "false");
			props.put("mail.smtp.starttls.enable", "true");

			Session mailSession = Session.getDefaultInstance(props);

			Transport transport = mailSession.getTransport("smtp");

			MimeMessage message = new MimeMessage(mailSession);

			message.setSubject("Approval For Inspector");
			message.setContent(content, "text/plain");
			message.setSentDate(new Date());
			message.setFrom(new InternetAddress(FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO) );
			transport.connect(emailConfig.getSMTP_HOST_NAME(), Integer.valueOf(Constants.AWS_EMAIL_PORT), emailConfig.getSMTP_AUTH_USER(), emailConfig.getSMTP_AUTH_PWD());
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		}
		


	}
	
	/**
	 * Send Email 
	 * @param email
	 * @return
	 * @throws IOException 
	 */
	public  void sendEmail(String toEmail,String ccEmail, String content) throws MessagingException {
		
		if(!emailDisable.equalsIgnoreCase("Y")) {
		logger.debug("Inside AWS Email");
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", emailConfig.getSMTP_HOST_NAME());
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.starttls.enable", "true");

		Session mailSession = Session.getDefaultInstance(props);

		Transport transport = mailSession.getTransport("smtp");

		MimeMessage message = new MimeMessage(mailSession);

		message.setSubject("Welcome to Rush Safety Application");
		message.setContent(content, "text/plain");
		message.setSentDate(new Date());
		message.setFrom(new InternetAddress(FROM));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccEmail));
		transport.connect(emailConfig.getSMTP_HOST_NAME(), Integer.valueOf(Constants.AWS_EMAIL_PORT), emailConfig.getSMTP_AUTH_USER(), emailConfig.getSMTP_AUTH_PWD());
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	    transport.sendMessage(message, message.getRecipients(Message.RecipientType.CC));
		transport.close();

		}
	}
	public void sendEmailPDF(String userName, Integer riskId, int count, String keyname)
			throws MessagingException, DocumentException, IOException, InterruptedException {

//		if(!emailDisable.equalsIgnoreCase("Y")) {

		String to = "hasan@capeindia.net";
		String from = FROM;
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", emailConfig.getSMTP_HOST_NAME());
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getDefaultInstance(props);
		

		try {

			Message message = new MimeMessage(session);
			Transport transport = session.getTransport("smtp");
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(Constants.EMAIL_SUBJECT);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Please find the attached final pdf submitted");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();

			BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, accessKeySecret);
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

			String filename = keyname+".pdf";
			
			S3Object fullObject;
			fullObject = s3Client.getObject(
					new GetObjectRequest(s3BucketName, "RiskAssessment_Project Name_".concat(keyname) + "/" + keyname+".pdf"));

			InputStream in = fullObject.getObjectContent();
			byte[] buf = new byte[1024];
			OutputStream out = new FileOutputStream(filename);
			while ((count = in.read(buf)) != -1) {
				if (Thread.interrupted()) {
					throw new InterruptedException();
				}
				out.write(buf, 0, count);
			}
			out.close();
			in.close();

			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			transport.connect(emailConfig.getSMTP_HOST_NAME(), Integer.valueOf(Constants.AWS_EMAIL_PORT), emailConfig.getSMTP_AUTH_USER(), emailConfig.getSMTP_AUTH_PWD());
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
//	}

}
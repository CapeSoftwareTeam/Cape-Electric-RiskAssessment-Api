package com.capeelectric.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "protection_table")
public class Protection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROTECTION_ID")
	private Integer protectionId;

// Loss of Human Life
	@Column(name = "PRO_PEB")
	private Integer protectionPEB;
	
	@Column(name = "PRO_PMS")
	private Integer protectionPMS;
	
	@Column(name = "PRO_PM")
	private Integer protectionPM;
	
	@Column(name = "PRO_PA")
	private Integer protectionPA;
	
	@Column(name = "PRO_PC")
	private Integer protectionPC;
	
	@Column(name = "PRO_PU")
	private Integer protectionPU;
	
	@Column(name = "PRO_PV")
	private Integer protectionPV;
	
	@Column(name = "PRO_PW")
	private Integer protectionPW;
	
	@Column(name = "PRO_PZ")
	private Integer protectionPZ;
	
	
// RISK OF LOSS OF HUMAN BEINGS (R1)	
	@Column(name = "R_PRO_RA1")
	private Integer riskProtectionRA1;
	
	@Column(name = "R_PRO_RB1")
	private Integer riskProtectionRB1;
	
	@Column(name = "R_PRO_RC1")
	private Integer riskProtectionRC1;
	
	@Column(name = "R_PRO_RM1")
	private Integer riskProtectionRM1;
	
	@Column(name = "R_PRO_RU1")
	private Integer riskProtectionRU1;
	
	@Column(name = "R_PRO_RV1")
	private Integer riskProtectionRV1;
	
	@Column(name = "R_PRO_RW1")
	private Integer riskProtectionRW1;
	
	@Column(name = "R_PRO_RZ1")
	private Integer riskProtectionRZ1;
	
	@Column(name = "R_PRO_RD1")
	private Integer riskProtectionRD1;
	
	@Column(name = "R_PRO_RI1")
	private Integer riskProtectionRI1;
	
	@Column(name = "R_PRO_R1")
	private Integer riskProtectionR1;
	
	@Column(name = "R_PRO_RB2")
	private Integer riskProtectionRB2;
	
	
	
	@Column(name = "CULTURAL_RB")
	private Integer culturalRB;
	
	@Column(name = "CULTURAL_RV")
	private Integer culturalRV;
	
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "STRUCTURE_CHARACTERISTIC_ID")
	private StructureCharacteristics structureCharacteristics;

	public Integer getProtectionId() {
		return protectionId;
	}

	public void setProtectionId(Integer protectionId) {
		this.protectionId = protectionId;
	}

	public Integer getProtectionPEB() {
		return protectionPEB;
	}

	public void setProtectionPEB(Integer protectionPEB) {
		this.protectionPEB = protectionPEB;
	}

	public Integer getProtectionPMS() {
		return protectionPMS;
	}

	public void setProtectionPMS(Integer protectionPMS) {
		this.protectionPMS = protectionPMS;
	}

	public Integer getProtectionPM() {
		return protectionPM;
	}

	public void setProtectionPM(Integer protectionPM) {
		this.protectionPM = protectionPM;
	}

	public Integer getProtectionPA() {
		return protectionPA;
	}

	public void setProtectionPA(Integer protectionPA) {
		this.protectionPA = protectionPA;
	}

	public Integer getProtectionPC() {
		return protectionPC;
	}

	public void setProtectionPC(Integer protectionPC) {
		this.protectionPC = protectionPC;
	}

	public Integer getProtectionPU() {
		return protectionPU;
	}

	public void setProtectionPU(Integer protectionPU) {
		this.protectionPU = protectionPU;
	}

	public Integer getProtectionPV() {
		return protectionPV;
	}

	public void setProtectionPV(Integer protectionPV) {
		this.protectionPV = protectionPV;
	}

	public Integer getProtectionPW() {
		return protectionPW;
	}

	public void setProtectionPW(Integer protectionPW) {
		this.protectionPW = protectionPW;
	}

	public Integer getProtectionPZ() {
		return protectionPZ;
	}

	public void setProtectionPZ(Integer protectionPZ) {
		this.protectionPZ = protectionPZ;
	}

	public Integer getRiskProtectionRA1() {
		return riskProtectionRA1;
	}

	public void setRiskProtectionRA1(Integer riskProtectionRA1) {
		this.riskProtectionRA1 = riskProtectionRA1;
	}

	public Integer getRiskProtectionRB1() {
		return riskProtectionRB1;
	}

	public void setRiskProtectionRB1(Integer riskProtectionRB1) {
		this.riskProtectionRB1 = riskProtectionRB1;
	}

	public Integer getRiskProtectionRC1() {
		return riskProtectionRC1;
	}

	public void setRiskProtectionRC1(Integer riskProtectionRC1) {
		this.riskProtectionRC1 = riskProtectionRC1;
	}

	public Integer getRiskProtectionRM1() {
		return riskProtectionRM1;
	}

	public void setRiskProtectionRM1(Integer riskProtectionRM1) {
		this.riskProtectionRM1 = riskProtectionRM1;
	}

	public Integer getRiskProtectionRU1() {
		return riskProtectionRU1;
	}

	public void setRiskProtectionRU1(Integer riskProtectionRU1) {
		this.riskProtectionRU1 = riskProtectionRU1;
	}

	public Integer getRiskProtectionRV1() {
		return riskProtectionRV1;
	}

	public void setRiskProtectionRV1(Integer riskProtectionRV1) {
		this.riskProtectionRV1 = riskProtectionRV1;
	}

	public Integer getRiskProtectionRW1() {
		return riskProtectionRW1;
	}

	public void setRiskProtectionRW1(Integer riskProtectionRW1) {
		this.riskProtectionRW1 = riskProtectionRW1;
	}

	public Integer getRiskProtectionRZ1() {
		return riskProtectionRZ1;
	}

	public void setRiskProtectionRZ1(Integer riskProtectionRZ1) {
		this.riskProtectionRZ1 = riskProtectionRZ1;
	}

	public Integer getRiskProtectionRD1() {
		return riskProtectionRD1;
	}

	public void setRiskProtectionRD1(Integer riskProtectionRD1) {
		this.riskProtectionRD1 = riskProtectionRD1;
	}

	public Integer getRiskProtectionRI1() {
		return riskProtectionRI1;
	}

	public void setRiskProtectionRI1(Integer riskProtectionRI1) {
		this.riskProtectionRI1 = riskProtectionRI1;
	}

	public Integer getRiskProtectionR1() {
		return riskProtectionR1;
	}

	public void setRiskProtectionR1(Integer riskProtectionR1) {
		this.riskProtectionR1 = riskProtectionR1;
	}

	public Integer getRiskProtectionRB2() {
		return riskProtectionRB2;
	}

	public void setRiskProtectionRB2(Integer riskProtectionRB2) {
		this.riskProtectionRB2 = riskProtectionRB2;
	}

	public StructureCharacteristics getStructureCharacteristics() {
		return structureCharacteristics;
	}

	public void setStructureCharacteristics(StructureCharacteristics structureCharacteristics) {
		this.structureCharacteristics = structureCharacteristics;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCulturalRB() {
		return culturalRB;
	}

	public void setCulturalRB(Integer culturalRB) {
		this.culturalRB = culturalRB;
	}

	public Integer getCulturalRV() {
		return culturalRV;
	}

	public void setCulturalRV(Integer culturalRV) {
		this.culturalRV = culturalRV;
	}
}

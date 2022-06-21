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
@Table(name = "riskprotection_table")
public class RiskProtection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RISK_PROTECTION_ID")
	private Integer riskProtectionId;

	@Column(name = "R_PRO_RC2")
	private String riskProtectionRC2;

	@Column(name = "R_PRO_RM2")
	private String riskProtectionRM2;

	@Column(name = "R_PRO_RV2")
	private String riskProtectionRV2;

	@Column(name = "R_PRO_RW2")
	private String riskProtectionRW2;

	@Column(name = "R_PRO_RZ2")
	private String riskProtectionRZ2;

	@Column(name = "R_PRO_RB3")
	private String riskProtectionRB3;

	@Column(name = "R_PRO_RV3")
	private String riskProtectionRV3;

	@Column(name = "R_PRO_RA4")
	private String riskProtectionRA4;

	@Column(name = "R_PRO_RB4")
	private String riskProtectionRB4;

	@Column(name = "R_PRO_RC4")
	private String riskProtectionRC4;

	@Column(name = "R_PRO_RM4")
	private String riskProtectionRM4;

	@Column(name = "R_PRO_RU4")
	private String riskProtectionRU4;

	@Column(name = "R_PRO_RV4")
	private String riskProtectionRV4;

	@Column(name = "R_PRO_RW4")
	private String riskProtectionRW4;

	@Column(name = "R_PRO_RZ4")
	private String riskProtectionRZ4;

	@Column(name = "ECO_VALUE_RA")
	private String econamicValueRA;

	@Column(name = "ECO_VALUE_RB")
	private String econamicValueRB;

	@Column(name = "ECO_VALUE_RC")
	private String econamicValueRC;

	@Column(name = "ECO_VALUE_RM")
	private String econamicValueRM;

	@Column(name = "ECO_VALUE_RU")
	private String econamicValueRU;

	@Column(name = "ECO_VALUE_RV")
	private String econamicValueRV;

	@Column(name = "ECO_VALUE_RW")
	private String econamicValueRW;

	@Column(name = "ECO_VALUE_RZ")
	private String econamicValueRZ;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "STRUCTURE_CHARACTERISTIC_ID")
	private StructureCharacteristics structureCharacteristics;

	public Integer getRiskProtectionId() {
		return riskProtectionId;
	}

	public void setRiskProtectionId(Integer riskProtectionId) {
		this.riskProtectionId = riskProtectionId;
	}

	public String getRiskProtectionRC2() {
		return riskProtectionRC2;
	}

	public void setRiskProtectionRC2(String riskProtectionRC2) {
		this.riskProtectionRC2 = riskProtectionRC2;
	}

	public String getRiskProtectionRM2() {
		return riskProtectionRM2;
	}

	public void setRiskProtectionRM2(String riskProtectionRM2) {
		this.riskProtectionRM2 = riskProtectionRM2;
	}

	public String getRiskProtectionRV2() {
		return riskProtectionRV2;
	}

	public void setRiskProtectionRV2(String riskProtectionRV2) {
		this.riskProtectionRV2 = riskProtectionRV2;
	}

	public String getRiskProtectionRW2() {
		return riskProtectionRW2;
	}

	public void setRiskProtectionRW2(String riskProtectionRW2) {
		this.riskProtectionRW2 = riskProtectionRW2;
	}

	public String getRiskProtectionRZ2() {
		return riskProtectionRZ2;
	}

	public void setRiskProtectionRZ2(String riskProtectionRZ2) {
		this.riskProtectionRZ2 = riskProtectionRZ2;
	}

	public String getRiskProtectionRB3() {
		return riskProtectionRB3;
	}

	public void setRiskProtectionRB3(String riskProtectionRB3) {
		this.riskProtectionRB3 = riskProtectionRB3;
	}

	public String getRiskProtectionRV3() {
		return riskProtectionRV3;
	}

	public void setRiskProtectionRV3(String riskProtectionRV3) {
		this.riskProtectionRV3 = riskProtectionRV3;
	}

	public String getRiskProtectionRA4() {
		return riskProtectionRA4;
	}

	public void setRiskProtectionRA4(String riskProtectionRA4) {
		this.riskProtectionRA4 = riskProtectionRA4;
	}

	public String getRiskProtectionRB4() {
		return riskProtectionRB4;
	}

	public void setRiskProtectionRB4(String riskProtectionRB4) {
		this.riskProtectionRB4 = riskProtectionRB4;
	}

	public String getRiskProtectionRC4() {
		return riskProtectionRC4;
	}

	public void setRiskProtectionRC4(String riskProtectionRC4) {
		this.riskProtectionRC4 = riskProtectionRC4;
	}

	public String getRiskProtectionRM4() {
		return riskProtectionRM4;
	}

	public void setRiskProtectionRM4(String riskProtectionRM4) {
		this.riskProtectionRM4 = riskProtectionRM4;
	}

	public String getRiskProtectionRU4() {
		return riskProtectionRU4;
	}

	public void setRiskProtectionRU4(String riskProtectionRU4) {
		this.riskProtectionRU4 = riskProtectionRU4;
	}

	public String getRiskProtectionRV4() {
		return riskProtectionRV4;
	}

	public void setRiskProtectionRV4(String riskProtectionRV4) {
		this.riskProtectionRV4 = riskProtectionRV4;
	}

	public String getRiskProtectionRW4() {
		return riskProtectionRW4;
	}

	public void setRiskProtectionRW4(String riskProtectionRW4) {
		this.riskProtectionRW4 = riskProtectionRW4;
	}

	public String getRiskProtectionRZ4() {
		return riskProtectionRZ4;
	}

	public void setRiskProtectionRZ4(String riskProtectionRZ4) {
		this.riskProtectionRZ4 = riskProtectionRZ4;
	}

	
	public String getEconamicValueRA() {
		return econamicValueRA;
	}

	public void setEconamicValueRA(String econamicValueRA) {
		this.econamicValueRA = econamicValueRA;
	}

	public String getEconamicValueRB() {
		return econamicValueRB;
	}

	public void setEconamicValueRB(String econamicValueRB) {
		this.econamicValueRB = econamicValueRB;
	}

	public String getEconamicValueRC() {
		return econamicValueRC;
	}

	public void setEconamicValueRC(String econamicValueRC) {
		this.econamicValueRC = econamicValueRC;
	}

	public String getEconamicValueRM() {
		return econamicValueRM;
	}

	public void setEconamicValueRM(String econamicValueRM) {
		this.econamicValueRM = econamicValueRM;
	}

	public String getEconamicValueRU() {
		return econamicValueRU;
	}

	public void setEconamicValueRU(String econamicValueRU) {
		this.econamicValueRU = econamicValueRU;
	}

	public String getEconamicValueRV() {
		return econamicValueRV;
	}

	public void setEconamicValueRV(String econamicValueRV) {
		this.econamicValueRV = econamicValueRV;
	}

	public String getEconamicValueRW() {
		return econamicValueRW;
	}

	public void setEconamicValueRW(String econamicValueRW) {
		this.econamicValueRW = econamicValueRW;
	}

	public String getEconamicValueRZ() {
		return econamicValueRZ;
	}

	public void setEconamicValueRZ(String econamicValueRZ) {
		this.econamicValueRZ = econamicValueRZ;
	}

	public StructureCharacteristics getStructureCharacteristics() {
		return structureCharacteristics;
	}

	public void setStructureCharacteristics(StructureCharacteristics structureCharacteristics) {
		this.structureCharacteristics = structureCharacteristics;
	}

	
}

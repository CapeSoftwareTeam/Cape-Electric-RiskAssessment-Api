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
	private Integer riskProtectionRC2;

	@Column(name = "R_PRO_RM2")
	private Integer riskProtectionRM2;

	@Column(name = "R_PRO_RV2")
	private Integer riskProtectionRV2;

	@Column(name = "R_PRO_RW2")
	private Integer riskProtectionRW2;

	@Column(name = "R_PRO_RZ2")
	private Integer riskProtectionRZ2;

	@Column(name = "R_PRO_RB3")
	private Integer riskProtectionRB3;

	@Column(name = "R_PRO_RV3")
	private Integer riskProtectionRV3;

	@Column(name = "R_PRO_RA4")
	private Integer riskProtectionRA4;

	@Column(name = "R_PRO_RB4")
	private Integer riskProtectionRB4;

	@Column(name = "R_PRO_RC4")
	private Integer riskProtectionRC4;

	@Column(name = "R_PRO_RM4")
	private Integer riskProtectionRM4;

	@Column(name = "R_PRO_RU4")
	private Integer riskProtectionRU4;

	@Column(name = "R_PRO_RV4")
	private Integer riskProtectionRV4;

	@Column(name = "R_PRO_RW4")
	private Integer riskProtectionRW4;

	@Column(name = "R_PRO_RZ4")
	private Integer riskProtectionRZ4;

	@Column(name = "ECO_VALUE_RA")
	private Integer econamicValueRA;

	@Column(name = "ECO_VALUE_RB")
	private Integer econamicValueRB;

	@Column(name = "ECO_VALUE_RC")
	private Integer econamicValueRC;

	@Column(name = "ECO_VALUE_RM")
	private Integer econamicValueRM;

	@Column(name = "ECO_VALUE_RU")
	private Integer econamicValueRU;

	@Column(name = "ECO_VALUE_RV")
	private Integer econamicValueRV;

	@Column(name = "ECO_VALUE_RW")
	private Integer econamicValueRW;

	@Column(name = "ECO_VALUE_RZ")
	private Integer econamicValueRZ;

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

	public Integer getRiskProtectionRC2() {
		return riskProtectionRC2;
	}

	public void setRiskProtectionRC2(Integer riskProtectionRC2) {
		this.riskProtectionRC2 = riskProtectionRC2;
	}

	public Integer getRiskProtectionRM2() {
		return riskProtectionRM2;
	}

	public void setRiskProtectionRM2(Integer riskProtectionRM2) {
		this.riskProtectionRM2 = riskProtectionRM2;
	}

	public Integer getRiskProtectionRV2() {
		return riskProtectionRV2;
	}

	public void setRiskProtectionRV2(Integer riskProtectionRV2) {
		this.riskProtectionRV2 = riskProtectionRV2;
	}

	public Integer getRiskProtectionRW2() {
		return riskProtectionRW2;
	}

	public void setRiskProtectionRW2(Integer riskProtectionRW2) {
		this.riskProtectionRW2 = riskProtectionRW2;
	}

	public Integer getRiskProtectionRZ2() {
		return riskProtectionRZ2;
	}

	public void setRiskProtectionRZ2(Integer riskProtectionRZ2) {
		this.riskProtectionRZ2 = riskProtectionRZ2;
	}

	public Integer getRiskProtectionRB3() {
		return riskProtectionRB3;
	}

	public void setRiskProtectionRB3(Integer riskProtectionRB3) {
		this.riskProtectionRB3 = riskProtectionRB3;
	}

	public Integer getRiskProtectionRV3() {
		return riskProtectionRV3;
	}

	public void setRiskProtectionRV3(Integer riskProtectionRV3) {
		this.riskProtectionRV3 = riskProtectionRV3;
	}

	public Integer getRiskProtectionRA4() {
		return riskProtectionRA4;
	}

	public void setRiskProtectionRA4(Integer riskProtectionRA4) {
		this.riskProtectionRA4 = riskProtectionRA4;
	}

	public Integer getRiskProtectionRB4() {
		return riskProtectionRB4;
	}

	public void setRiskProtectionRB4(Integer riskProtectionRB4) {
		this.riskProtectionRB4 = riskProtectionRB4;
	}

	public Integer getRiskProtectionRC4() {
		return riskProtectionRC4;
	}

	public void setRiskProtectionRC4(Integer riskProtectionRC4) {
		this.riskProtectionRC4 = riskProtectionRC4;
	}

	public Integer getRiskProtectionRM4() {
		return riskProtectionRM4;
	}

	public void setRiskProtectionRM4(Integer riskProtectionRM4) {
		this.riskProtectionRM4 = riskProtectionRM4;
	}

	public Integer getRiskProtectionRU4() {
		return riskProtectionRU4;
	}

	public void setRiskProtectionRU4(Integer riskProtectionRU4) {
		this.riskProtectionRU4 = riskProtectionRU4;
	}

	public Integer getRiskProtectionRV4() {
		return riskProtectionRV4;
	}

	public void setRiskProtectionRV4(Integer riskProtectionRV4) {
		this.riskProtectionRV4 = riskProtectionRV4;
	}

	public Integer getRiskProtectionRW4() {
		return riskProtectionRW4;
	}

	public void setRiskProtectionRW4(Integer riskProtectionRW4) {
		this.riskProtectionRW4 = riskProtectionRW4;
	}

	public Integer getRiskProtectionRZ4() {
		return riskProtectionRZ4;
	}

	public void setRiskProtectionRZ4(Integer riskProtectionRZ4) {
		this.riskProtectionRZ4 = riskProtectionRZ4;
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

	public Integer getEconamicValueRA() {
		return econamicValueRA;
	}

	public void setEconamicValueRA(Integer econamicValueRA) {
		this.econamicValueRA = econamicValueRA;
	}

	public Integer getEconamicValueRB() {
		return econamicValueRB;
	}

	public void setEconamicValueRB(Integer econamicValueRB) {
		this.econamicValueRB = econamicValueRB;
	}

	public Integer getEconamicValueRC() {
		return econamicValueRC;
	}

	public void setEconamicValueRC(Integer econamicValueRC) {
		this.econamicValueRC = econamicValueRC;
	}

	public Integer getEconamicValueRM() {
		return econamicValueRM;
	}

	public void setEconamicValueRM(Integer econamicValueRM) {
		this.econamicValueRM = econamicValueRM;
	}

	public Integer getEconamicValueRU() {
		return econamicValueRU;
	}

	public void setEconamicValueRU(Integer econamicValueRU) {
		this.econamicValueRU = econamicValueRU;
	}

	public Integer getEconamicValueRV() {
		return econamicValueRV;
	}

	public void setEconamicValueRV(Integer econamicValueRV) {
		this.econamicValueRV = econamicValueRV;
	}

	public Integer getEconamicValueRW() {
		return econamicValueRW;
	}

	public void setEconamicValueRW(Integer econamicValueRW) {
		this.econamicValueRW = econamicValueRW;
	}

	public Integer getEconamicValueRZ() {
		return econamicValueRZ;
	}

	public void setEconamicValueRZ(Integer econamicValueRZ) {
		this.econamicValueRZ = econamicValueRZ;
	}
}

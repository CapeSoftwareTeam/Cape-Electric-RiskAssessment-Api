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

	@Column(name = "R_PRO_RD2")
	private Integer riskProtectionRD2;

	@Column(name = "R_PRO_RI2")
	private Integer riskProtectionRI2;

	@Column(name = "R_PRO_R2")
	private Integer riskProtectionR2;

	@Column(name = "R_PRO_RB3")
	private Integer riskProtectionRB3;

	@Column(name = "R_PRO_RV3")
	private Integer riskProtectionRV3;

	@Column(name = "R_PRO_RD3")
	private Integer riskProtectionRD3;

	@Column(name = "R_PRO_R3")
	private Integer riskProtectionR3;

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

	@Column(name = "R_PRO_RD4")
	private Integer riskProtectionRD4;

	@Column(name = "R_PRO_RI4")
	private Integer riskProtectionRI4;

	@Column(name = "R_PRO_R4")
	private Integer riskProtectionR4;

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

	public Integer getRiskProtectionRD2() {
		return riskProtectionRD2;
	}

	public void setRiskProtectionRD2(Integer riskProtectionRD2) {
		this.riskProtectionRD2 = riskProtectionRD2;
	}

	public Integer getRiskProtectionRI2() {
		return riskProtectionRI2;
	}

	public void setRiskProtectionRI2(Integer riskProtectionRI2) {
		this.riskProtectionRI2 = riskProtectionRI2;
	}

	public Integer getRiskProtectionR2() {
		return riskProtectionR2;
	}

	public void setRiskProtectionR2(Integer riskProtectionR2) {
		this.riskProtectionR2 = riskProtectionR2;
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

	public Integer getRiskProtectionRD3() {
		return riskProtectionRD3;
	}

	public void setRiskProtectionRD3(Integer riskProtectionRD3) {
		this.riskProtectionRD3 = riskProtectionRD3;
	}

	public Integer getRiskProtectionR3() {
		return riskProtectionR3;
	}

	public void setRiskProtectionR3(Integer riskProtectionR3) {
		this.riskProtectionR3 = riskProtectionR3;
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

	public Integer getRiskProtectionRD4() {
		return riskProtectionRD4;
	}

	public void setRiskProtectionRD4(Integer riskProtectionRD4) {
		this.riskProtectionRD4 = riskProtectionRD4;
	}

	public Integer getRiskProtectionRI4() {
		return riskProtectionRI4;
	}

	public void setRiskProtectionRI4(Integer riskProtectionRI4) {
		this.riskProtectionRI4 = riskProtectionRI4;
	}

	public Integer getRiskProtectionR4() {
		return riskProtectionR4;
	}

	public void setRiskProtectionR4(Integer riskProtectionR4) {
		this.riskProtectionR4 = riskProtectionR4;
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

}

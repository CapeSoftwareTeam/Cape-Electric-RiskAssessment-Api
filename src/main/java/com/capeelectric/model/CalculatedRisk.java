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
@Table(name = "calculated_risk_table")
public class CalculatedRisk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CALCULATED_RISK_ID")
	private Integer calculatedRiskId;

	@Column(name = "LOSS_HUMAN_LIFE")
	private String lossOfHumanLifeRT1;

	@Column(name = "LOSS_PUBLIC_SERVICE")
	private String lossOfPublicSerivceRT2;

	@Column(name = "LOSS_CULTURAL_HERITAGE")
	private String lossOfCulturalHeritageRT3;

	@Column(name = "ECONOMIC_LOSS")
	private String economicLossRT4;

	@Column(name = "R_PRO_R1")
	private Integer riskProtectionR1;

	@Column(name = "R_PRO_R2")
	private Integer riskProtectionR2;

	@Column(name = "R_PRO_R3")
	private Integer riskProtectionR3;

	@Column(name = "R_PRO_R4")
	private Integer riskProtectionR4;

	@Column(name = "R_PRO_RD1")
	private Integer riskProtectionRD1;

	@Column(name = "R_PRO_RD2")
	private Integer riskProtectionRD2;

	@Column(name = "R_PRO_RD3")
	private Integer riskProtectionRD3;

	@Column(name = "R_PRO_RD4")
	private Integer riskProtectionRD4;

	@Column(name = "R_PRO_RI1")
	private Integer riskProtectionRI1;

	@Column(name = "R_PRO_RI2")
	private Integer riskProtectionRI2;

	@Column(name = "R_PRO_RI3")
	private Integer riskProtectionRI3;

	@Column(name = "R_PRO_RI4")
	private Integer riskProtectionRI4;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "STRUCTURE_CHARACTERISTIC_ID")
	private StructureCharacteristics structureCharacteristics;

	public Integer getCalculatedRiskId() {
		return calculatedRiskId;
	}

	public void setCalculatedRiskId(Integer calculatedRiskId) {
		this.calculatedRiskId = calculatedRiskId;
	}

	public String getLossOfHumanLifeRT1() {
		return lossOfHumanLifeRT1;
	}

	public void setLossOfHumanLifeRT1(String lossOfHumanLifeRT1) {
		this.lossOfHumanLifeRT1 = lossOfHumanLifeRT1;
	}

	public String getLossOfPublicSerivceRT2() {
		return lossOfPublicSerivceRT2;
	}

	public void setLossOfPublicSerivceRT2(String lossOfPublicSerivceRT2) {
		this.lossOfPublicSerivceRT2 = lossOfPublicSerivceRT2;
	}

	public String getLossOfCulturalHeritageRT3() {
		return lossOfCulturalHeritageRT3;
	}

	public void setLossOfCulturalHeritageRT3(String lossOfCulturalHeritageRT3) {
		this.lossOfCulturalHeritageRT3 = lossOfCulturalHeritageRT3;
	}

	public String getEconomicLossRT4() {
		return economicLossRT4;
	}

	public void setEconomicLossRT4(String economicLossRT4) {
		this.economicLossRT4 = economicLossRT4;
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

	public Integer getRiskProtectionR1() {
		return riskProtectionR1;
	}

	public void setRiskProtectionR1(Integer riskProtectionR1) {
		this.riskProtectionR1 = riskProtectionR1;
	}

	public Integer getRiskProtectionR2() {
		return riskProtectionR2;
	}

	public void setRiskProtectionR2(Integer riskProtectionR2) {
		this.riskProtectionR2 = riskProtectionR2;
	}

	public Integer getRiskProtectionR3() {
		return riskProtectionR3;
	}

	public void setRiskProtectionR3(Integer riskProtectionR3) {
		this.riskProtectionR3 = riskProtectionR3;
	}

	public Integer getRiskProtectionR4() {
		return riskProtectionR4;
	}

	public void setRiskProtectionR4(Integer riskProtectionR4) {
		this.riskProtectionR4 = riskProtectionR4;
	}

	public Integer getRiskProtectionRD1() {
		return riskProtectionRD1;
	}

	public void setRiskProtectionRD1(Integer riskProtectionRD1) {
		this.riskProtectionRD1 = riskProtectionRD1;
	}

	public Integer getRiskProtectionRD2() {
		return riskProtectionRD2;
	}

	public void setRiskProtectionRD2(Integer riskProtectionRD2) {
		this.riskProtectionRD2 = riskProtectionRD2;
	}

	public Integer getRiskProtectionRD3() {
		return riskProtectionRD3;
	}

	public void setRiskProtectionRD3(Integer riskProtectionRD3) {
		this.riskProtectionRD3 = riskProtectionRD3;
	}

	public Integer getRiskProtectionRD4() {
		return riskProtectionRD4;
	}

	public void setRiskProtectionRD4(Integer riskProtectionRD4) {
		this.riskProtectionRD4 = riskProtectionRD4;
	}

	public Integer getRiskProtectionRI1() {
		return riskProtectionRI1;
	}

	public void setRiskProtectionRI1(Integer riskProtectionRI1) {
		this.riskProtectionRI1 = riskProtectionRI1;
	}

	public Integer getRiskProtectionRI2() {
		return riskProtectionRI2;
	}

	public void setRiskProtectionRI2(Integer riskProtectionRI2) {
		this.riskProtectionRI2 = riskProtectionRI2;
	}

	public Integer getRiskProtectionRI3() {
		return riskProtectionRI3;
	}

	public void setRiskProtectionRI3(Integer riskProtectionRI3) {
		this.riskProtectionRI3 = riskProtectionRI3;
	}

	public Integer getRiskProtectionRI4() {
		return riskProtectionRI4;
	}

	public void setRiskProtectionRI4(Integer riskProtectionRI4) {
		this.riskProtectionRI4 = riskProtectionRI4;
	}
}

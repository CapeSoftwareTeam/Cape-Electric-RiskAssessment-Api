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
	private String lossOfHumanLife;

	@Column(name = "LOSS_PUBLIC_SERVICE")
	private String lossOfPublicSerivce;

	@Column(name = "LOSS_CULTURAL_HERITAGE")
	private String lossOfCulturalHeritage;

	@Column(name = "ECONOMIC_LOSS")
	private String economicLoss;

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

	public String getLossOfHumanLife() {
		return lossOfHumanLife;
	}

	public void setLossOfHumanLife(String lossOfHumanLife) {
		this.lossOfHumanLife = lossOfHumanLife;
	}

	public String getLossOfPublicSerivce() {
		return lossOfPublicSerivce;
	}

	public void setLossOfPublicSerivce(String lossOfPublicSerivce) {
		this.lossOfPublicSerivce = lossOfPublicSerivce;
	}

	public String getLossOfCulturalHeritage() {
		return lossOfCulturalHeritage;
	}

	public void setLossOfCulturalHeritage(String lossOfCulturalHeritage) {
		this.lossOfCulturalHeritage = lossOfCulturalHeritage;
	}

	public String getEconomicLoss() {
		return economicLoss;
	}

	public void setEconomicLoss(String economicLoss) {
		this.economicLoss = economicLoss;
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

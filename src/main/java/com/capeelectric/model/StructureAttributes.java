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
@Table(name = "structure_attributes_table")
public class StructureAttributes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STRUCTURE_ATTRIBUTES_ID")
	private Integer structureAttributesId;

	
	// Loss of Human Life
	@Column(name = "HL_HAZARD_CLASSIFICATION")
	private String hazardClassification;

	@Column(name = "HL_PHYSICAL_DAMAGE")
	private String humanLossOfphysicalDamage;

	@Column(name = "HL_FAILURE_INTERNAL_SYSTEM")
	private String humanLossOffailureOfInternalSystem;

	@Column(name = "HL_INJURY_ELECTRIC_SHOCK")
	private String humanLossOfInjuryOfElectricShock;

	@Column(name = "HL_PHYSICAL_DAMAGE_L1")
	private String humanLossOfPhysicalDamageL1;

	
	// Loss Of Service To Public
	@Column(name = "SP_PHYSICAL_DAMAGE")
	private String SerToPubPhysicalDamage;

	@Column(name = "SP_FAILURE_INTERNAL_SYSTEM")
	private String serToPubfailureOfInternalSystem;

	
	// Loss Of Cultural Heritage
	@Column(name = "CH_PHYSICAL_DAMAGE")
	private String culHerOfPhysicalDamage;

	
	// Loss Of Economic Loss
	@Column(name = "EL_PHYSICAL_DAMAGE")
	private String ecoLossOfPhysicalDamage;

	@Column(name = "EL_FAILURE_INTERNAL_SYSTEM")
	private String ecoLossOfFailureOfInternalSystem;

	@Column(name = "EL_INJURY_ELECTRIC_SHOCK")
	private String ecoLossOfInjuryOfElectricShock;

	
	// Loss Of Protection
	@Column(name = "PROTEC_CLASS_LPS")
	private String classOfLPS;

	@Column(name = "PROTEC_CLASS_SPD")
	private String classOfSPD;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "STRUCTURE_CHARACTERISTIC_ID")
	private StructureCharacteristics structureCharacteristics;

	public Integer getStructureAttributesId() {
		return structureAttributesId;
	}

	public void setStructureAttributesId(Integer structureAttributesId) {
		this.structureAttributesId = structureAttributesId;
	}

	public String getHazardClassification() {
		return hazardClassification;
	}

	public void setHazardClassification(String hazardClassification) {
		this.hazardClassification = hazardClassification;
	}

	public String getHumanLossOfphysicalDamage() {
		return humanLossOfphysicalDamage;
	}

	public void setHumanLossOfphysicalDamage(String humanLossOfphysicalDamage) {
		this.humanLossOfphysicalDamage = humanLossOfphysicalDamage;
	}

	public String getHumanLossOffailureOfInternalSystem() {
		return humanLossOffailureOfInternalSystem;
	}

	public void setHumanLossOffailureOfInternalSystem(String humanLossOffailureOfInternalSystem) {
		this.humanLossOffailureOfInternalSystem = humanLossOffailureOfInternalSystem;
	}

	public String getHumanLossOfInjuryOfElectricShock() {
		return humanLossOfInjuryOfElectricShock;
	}

	public void setHumanLossOfInjuryOfElectricShock(String humanLossOfInjuryOfElectricShock) {
		this.humanLossOfInjuryOfElectricShock = humanLossOfInjuryOfElectricShock;
	}

	public String getHumanLossOfPhysicalDamageL1() {
		return humanLossOfPhysicalDamageL1;
	}

	public void setHumanLossOfPhysicalDamageL1(String humanLossOfPhysicalDamageL1) {
		this.humanLossOfPhysicalDamageL1 = humanLossOfPhysicalDamageL1;
	}

	public String getSerToPubPhysicalDamage() {
		return SerToPubPhysicalDamage;
	}

	public void setSerToPubPhysicalDamage(String serToPubPhysicalDamage) {
		SerToPubPhysicalDamage = serToPubPhysicalDamage;
	}

	public String getSerToPubfailureOfInternalSystem() {
		return serToPubfailureOfInternalSystem;
	}

	public void setSerToPubfailureOfInternalSystem(String serToPubfailureOfInternalSystem) {
		this.serToPubfailureOfInternalSystem = serToPubfailureOfInternalSystem;
	}

	public String getCulHerOfPhysicalDamage() {
		return culHerOfPhysicalDamage;
	}

	public void setCulHerOfPhysicalDamage(String culHerOfPhysicalDamage) {
		this.culHerOfPhysicalDamage = culHerOfPhysicalDamage;
	}

	public String getEcoLossOfPhysicalDamage() {
		return ecoLossOfPhysicalDamage;
	}

	public void setEcoLossOfPhysicalDamage(String ecoLossOfPhysicalDamage) {
		this.ecoLossOfPhysicalDamage = ecoLossOfPhysicalDamage;
	}

	public String getEcoLossOfFailureOfInternalSystem() {
		return ecoLossOfFailureOfInternalSystem;
	}

	public void setEcoLossOfFailureOfInternalSystem(String ecoLossOfFailureOfInternalSystem) {
		this.ecoLossOfFailureOfInternalSystem = ecoLossOfFailureOfInternalSystem;
	}

	public String getEcoLossOfInjuryOfElectricShock() {
		return ecoLossOfInjuryOfElectricShock;
	}

	public void setEcoLossOfInjuryOfElectricShock(String ecoLossOfInjuryOfElectricShock) {
		this.ecoLossOfInjuryOfElectricShock = ecoLossOfInjuryOfElectricShock;
	}

	public String getClassOfLPS() {
		return classOfLPS;
	}

	public void setClassOfLPS(String classOfLPS) {
		this.classOfLPS = classOfLPS;
	}

	public String getClassOfSPD() {
		return classOfSPD;
	}

	public void setClassOfSPD(String classOfSPD) {
		this.classOfSPD = classOfSPD;
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

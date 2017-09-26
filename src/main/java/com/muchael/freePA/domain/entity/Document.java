package com.muchael.freePA.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Document extends AbstractEntity {

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	private Integer number;
	private String subject;
	private String version;
	private Float totalFP;
	private String analystInCharge;
	private String reviwer;
	
	private DocumentStatus documentStatus;
	
	private CountingType countingType;
	
	private DocumentType documentType;
	
	@ManyToOne
	private Project project;

	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 * @param id
	 */
	public Document(Long id) {
		super(id);
	}
	
	
}

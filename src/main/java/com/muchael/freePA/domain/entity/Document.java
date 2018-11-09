package com.muchael.freePA.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Document extends AbstractEntity {

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	@NotNull
	private Integer number;
	private String subject;
	private String version;
	private Float totalFP;
	private String analystInCharge;
	private String reviwer;
	
	@NotNull
	private DocumentStatus documentStatus;
	
	@NotNull
	private CountingType countingType;
	
	@NotNull
	private DocumentType documentType;
	
	@NotNull
	@ManyToOne
	private Project project;
	
	@OneToMany(mappedBy = "document")
	private List<Function> functions = new ArrayList<>();

	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	public Document() {

	}
	/**
	 * 
	 * @param id
	 */
	public Document(Long id) {
		super(id);
	}
	
	
}

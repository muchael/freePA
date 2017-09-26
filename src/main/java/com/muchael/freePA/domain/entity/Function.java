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
public class Function extends AbstractEntity {
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	
	/**
	 * Name of the function
	 */
	@NotNull
	private String name;
	
	/**
	 * Quantity of data
	 */
	private Integer tdQuantity;

	/**
	 * Quantity of referenced tables 
	 */
	private Integer trQuantity;
	
	@NotNull
	private FunctionType functionType;
	
	@NotNull
	private FunctionCategoryType functionCategoryType;
	
	/**
	 * Parent file of the function
	 */
	@ManyToOne
	private Function parentFile;
	
	/**
	 * Document that the function belongs
	 */
	@ManyToOne
	private Document document;
	
	/**
	 * Data types
	 */
	@OneToMany
	private List<DataType> dataTypes = new ArrayList<>();
	
	/**
	 * Referenced tables
	 */
	@OneToMany
	private List<Function> referencedTables = new ArrayList<>();
		
	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 * @param id
	 */
	public Function(Long id) {
		super(id);
	}	
	
}

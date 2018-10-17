package com.muchael.freePA.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class DataType extends AbstractEntity {
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	
	/**
	 * Name of the data
	 */
	@NotNull
	private String name;
	
	/**
	 * Function that the data belongs
	 */
	@NotNull
	@ManyToOne
	private Function function;
			
	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	public DataType() {
	}	
	/**
	 * 
	 * @param id
	 */
	public DataType(Long id) {
		super(id);
	}	
	
	public DataType(String name, Function function) {
		super();
		this.name = name;
		this.function = function;
	}
	
}
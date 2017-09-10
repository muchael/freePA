package com.muchael.freePA.domain.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Project extends AbstractEntity {
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	
	/**
	 * Name of the project
	 */
	private String name;
	
	/**
	 * Initial date of the project
	 */
	private LocalDate startDate;


	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 * @param id
	 */
	public Project(Long id) {
		super(id);
	}	
	
}

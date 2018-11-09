package com.muchael.freePA.domain.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

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
	@NotNull
	private String name;
	
	/**
	 * Initial date of the project
	 */
	private LocalDate startDate;
	
	@OneToMany(mappedBy = "project")
	private List<Document> documents = new ArrayList<>();


	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	public Project() {
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public Project(Long id) {
		super(id);
	}	
	
}

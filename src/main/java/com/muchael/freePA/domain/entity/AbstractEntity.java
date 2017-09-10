package com.muchael.freePA.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * 
 */
@Data
@MappedSuperclass
public abstract class AbstractEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875941859616104733L;

	/*-------------------------------------------------------------------
	 * 		 					ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * Atributo id para todas as classes filhas
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	/**
	 * 
	 */
	@Column(nullable = false, updatable = false)
	protected LocalDateTime created;
	
	/**
	 * 
	 */
	protected LocalDateTime updated;

	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	public AbstractEntity()
	{
	}

	/**
	 * 
	 * @param id
	 */
	public AbstractEntity( Long id )
	{
		this.setId( id );
	}

	/*-------------------------------------------------------------------
	 * 		 					BEHAVIORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	@PrePersist
	protected void refreshCreated()
	{
		if ( this.getCreated() == null )
		{
			this.setCreated( LocalDateTime.now() );
		}
	}

	/**
	 * 
	 */
	@PreUpdate
	protected void refreshUpdated()
	{
		this.refreshCreated();
		this.setUpdated( LocalDateTime.now() );
	}

	/*-------------------------------------------------------------------
	 *				 	    GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * 
	 */
	public void setId( Long id )
	{
		this.id = id;
	}
}
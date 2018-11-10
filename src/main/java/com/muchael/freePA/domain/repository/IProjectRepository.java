package com.muchael.freePA.domain.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.muchael.freePA.domain.entity.Project;

public interface IProjectRepository extends CrudRepository<Project, Long>{

	@Query("FROM Project project WHERE (project.name LIKE '%'||:name||'%' OR cast(:name as text) is NULL)"
			+ "AND ( ( project.startDate BETWEEN cast(:initialDate as date) AND cast(:finalDate as date)) )")
	Page<Project> listByFilters(@Param("name") String name, @Param("initialDate") LocalDate initialDate, @Param("finalDate") LocalDate finalDate, Pageable pageable);

	
//	OR cast(:initialDate as date) IS NULL ---  OR cast(:finalDate as date) IS NULL
}

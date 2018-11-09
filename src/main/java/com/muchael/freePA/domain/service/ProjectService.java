package com.muchael.freePA.domain.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.muchael.freePA.domain.entity.Project;
import com.muchael.freePA.domain.repository.IDocumentRepository;
import com.muchael.freePA.domain.repository.IProjectRepository;

@Service
@Transactional
public class ProjectService {

	@Autowired
	private IProjectRepository projectRepository;
	
	@Autowired
	private IDocumentRepository documentRepository;

	/**
	 * Inserts a project
	 * 
	 * @param project
	 * @return
	 */
	Project insertProject(Project project) {

		return projectRepository.save(project);
	}

	/**
	 * Updates a project
	 * 
	 * @param project
	 * @return
	 */
	Project updateProject(Project project) {

		return projectRepository.save(project);
	}

	/**
	 * Removes a project
	 * @param id
	 */
	void deleteProject(Long id) {
		this.documentRepository.deleteByProject_id( id );
		this.projectRepository.deleteById(id);
	}
	
	public Project findProjectById(long id) {
		Project project = this.projectRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException("Project not found"));
		project.setDocuments( this.documentRepository.findByProject_id(id, null).getContent());
		
		return project;
	}

	/**
	 * List projects by filters
	 * @param name
	 * @param initialDate
	 * @param finalDate
	 * @param pageRequest
	 * @return
	 */
	public Page<Project> listProjectByFilters(String name, LocalDate initialDate, LocalDate finalDate, PageRequest pageRequest) {
		
		return this.projectRepository.listByFilters( name, initialDate, finalDate, pageRequest);
	}
}

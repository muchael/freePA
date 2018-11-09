package com.muchael.freePA.domain.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;

import com.muchael.freePA.FreePaApplicationTests;
import com.muchael.freePA.domain.entity.Project;

public class ProjectServiceIntegrationTests extends FreePaApplicationTests {

	@Autowired
	private ProjectService projectService;

	/**
	 * Test of insertion of project
	 */
	@Test
	@Sql({"/dataset/project.sql"})
	public void insertProjectnMustPass() {
		Project project = new Project();

		project.setName("Test");
		project.setStartDate(LocalDate.of(2018, 1, 1));

		Project projectSaved = this.projectService.insertProject(project);
		assertNotNull(projectSaved);
		assertNotNull(projectSaved.getId());
		assertEquals("Test", projectSaved.getName());
		assertEquals(LocalDate.of(2018, 1, 1), projectSaved.getStartDate());
	}
	
	/**
	 * Test of insertion of project
	 */
	@Test(expected = ConstraintViolationException.class)
	@Sql({"/dataset/project.sql"})
	public void insertProjectnMustFailWithoutName() {
		Project project = new Project();

		project.setStartDate(LocalDate.of(2018, 1, 1));

		this.projectService.insertProject(project);
	}
	
	
	@Test
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql"})
	public void findProjectByIdMustPass() {
		Project project = this.projectService.findProjectById( 1000L );

		assertNotNull(project);
		assertNotNull(project.getId());
		assertNotNull(project.getName());
		assertNotNull(project.getStartDate());
		assertTrue(project.getDocuments().size() > 0);
		assertTrue( project.getDocuments().stream().allMatch( document -> document.getNumber() != null ) );
	}
	
	@Test
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql"})
	public void updateProjectMustPass() {
		Project project = this.projectService.findProjectById( 1000L );

		project.setName("Test");
		project.setStartDate(LocalDate.of(2018, 1, 1));
		
		Project projectSaved = this.projectService.updateProject(project);
		assertNotNull(projectSaved);
		assertNotNull(projectSaved.getId());
		assertEquals("Test", projectSaved.getName());
		assertEquals(LocalDate.of(2018, 1, 1), projectSaved.getStartDate());
	}
	
	@Test
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql"})
	public void listProjectMustPass() {
		Page<Project> projects = this.projectService.listProjectByFilters( null, null, null, null );
		
		assertFalse( projects.getContent().isEmpty() );
		assertTrue( projects.getContent().stream().allMatch( function -> function.getName() != null ));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql"})
	public void deleteProjectMustPass() {
		this.projectService.deleteProject( 1000L );
		
		this.projectService.findProjectById( 1000L );
	}

}

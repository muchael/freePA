package com.muchael.freePA.domain.service;

import static org.junit.Assert.assertNotNull;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.muchael.freePA.FreePaApplicationTests;
import com.muchael.freePA.domain.entity.Document;
import com.muchael.freePA.domain.entity.Function;
import com.muchael.freePA.domain.entity.FunctionCategoryType;
import com.muchael.freePA.domain.entity.FunctionType;

public class FunctionServiceIntegrationTests extends FreePaApplicationTests {

	@Autowired
	private FunctionService functionService;

	@Test
	@Sql({"/dataset/project.sql",
		"/dataset/document.sql",
		"/dataset/function.sql"})
	public void insertFunctionMustPass() {
		Function function = new Function();

		function.setName("Test");
		function.setFunctionType(FunctionType.INSERT);
		function.setFunctionCategoryType(FunctionCategoryType.EE);
		function.setDocument(new Document(1L));

		Function functionSaved = this.functionService.insertFunction(function);
		assertNotNull(functionSaved);
		assertNotNull(functionSaved.getId());
	}
	
	@Test(expected=ConstraintViolationException.class)
	@Sql({"/dataset/project.sql",
		"/dataset/document.sql",
		"/dataset/function.sql"})
	public void insertFunctionMustFailWithoutMandatoryFields() {
		Function function = new Function();

		function.setName("Test");

		this.functionService.insertFunction(function);
	}

}

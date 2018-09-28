package com.muchael.freePA.domain.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.muchael.freePA.FreePaApplicationTests;
import com.muchael.freePA.domain.entity.Function;
import com.muchael.freePA.domain.entity.FunctionCategoryType;
import com.muchael.freePA.domain.entity.FunctionType;

public class FunctionServiceIntegrationTests extends FreePaApplicationTests {

	@Autowired
	private FunctionService functionService;

	@Test
	public void insertFunctionMustPass() {
		Function function = new Function();

		function.setName("Test");
		function.setFunctionType(FunctionType.INSERT);
		function.setFunctionCategoryType(FunctionCategoryType.EE);

		Function functionSaved = this.functionService.insertFunction(function);
		assertNotNull(functionSaved);
		assertNotNull(functionSaved.getId());
	}

}

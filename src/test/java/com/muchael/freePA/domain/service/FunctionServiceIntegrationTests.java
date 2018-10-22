package com.muchael.freePA.domain.service;

import static org.junit.Assert.*;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;

import com.muchael.freePA.FreePaApplicationTests;
import com.muchael.freePA.domain.entity.DataType;
import com.muchael.freePA.domain.entity.Document;
import com.muchael.freePA.domain.entity.Function;
import com.muchael.freePA.domain.entity.FunctionCategoryType;
import com.muchael.freePA.domain.entity.FunctionType;

public class FunctionServiceIntegrationTests extends FreePaApplicationTests {

	@Autowired
	private FunctionService functionService;

	/**
	 * Test of insertion of function specifying the number of TD and TR
	 * TODO test referencedTables 
	 */
	@Test
	@Sql({"/dataset/project.sql",
		"/dataset/document.sql",
		"/dataset/function.sql"})
	public void insertFunctionMustPassWithTrTdNumber() {
		Function function = new Function();

		function.setName("Test");
		function.setTdQuantity(5);
		function.setTrQuantity(1);
		function.setFunctionType(FunctionType.INSERT);
		function.setFunctionCategoryType(FunctionCategoryType.EE);
		function.setDocument(new Document(1000L));
		function.getReferencedTables().add( new Function(1000L) );

		Function functionSaved = this.functionService.insertFunction(function);
		assertNotNull(functionSaved);
		assertNotNull(functionSaved.getId());
		assertEquals("Test", functionSaved.getName());
		assertEquals(5, functionSaved.getTdQuantity().intValue());
		assertEquals(1, functionSaved.getTrQuantity().intValue());
		assertEquals(FunctionType.INSERT, functionSaved.getFunctionType());
		assertEquals(FunctionCategoryType.EE, functionSaved.getFunctionCategoryType());
		assertEquals(1000L, functionSaved.getDocument().getId().longValue());
		assertFalse(functionSaved.getReferencedTables().isEmpty());
	}
	
	@Test
	@Sql({"/dataset/project.sql",
		"/dataset/document.sql"})
	public void insertFunctionMustPassWithDataTypes() {
		Function function = new Function();

		function.setName("Test");
		function.setFunctionType(FunctionType.INSERT);
		function.setFunctionCategoryType(FunctionCategoryType.EE);
		function.setDocument(new Document(1000L));
		function.getDataTypes().add(new DataType("Name", function));
		function.getDataTypes().add(new DataType("Number", function));

		Function functionSaved = this.functionService.insertFunction(function);
		assertNotNull(functionSaved);
		assertNotNull(functionSaved.getId());
		assertEquals("Test", functionSaved.getName());
		assertEquals(2, functionSaved.getDataTypes().size());
		assertTrue( functionSaved.getDataTypes().stream().allMatch(dataType -> dataType.getId() != null ) );
		assertEquals(FunctionType.INSERT, functionSaved.getFunctionType());
		assertEquals(FunctionCategoryType.EE, functionSaved.getFunctionCategoryType());
		assertEquals(1000L, functionSaved.getDocument().getId().longValue());
	}
	
	@Test(expected=ConstraintViolationException.class)
	@Sql({"/dataset/project.sql",
		"/dataset/document.sql"})
	public void insertFunctionMustFailWithoutMandatoryFields() {
		Function function = new Function();

		function.setName("Test");

		this.functionService.insertFunction(function);
	}
	
	@Test
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql",
			"/dataset/function.sql",
			"/dataset/data_type.sql",
			"/dataset/function_referenced_tables.sql",})
	public void findFunctionByIdMustPass() {
		Function function = this.functionService.findFunctionById( 1001L );

		assertNotNull(function);
		assertNotNull(function.getId());
		assertNotNull(function.getName());
		assertNotNull(function.getTdQuantity());
		assertNotNull(function.getTrQuantity());
		assertNotNull(function.getFunctionType());
		assertNotNull(function.getFunctionCategoryType());
		assertNotNull(function.getDocument().getId());
		assertFalse( function.getDataTypes().isEmpty() );
		assertFalse( function.getReferencedTables().isEmpty() );
	}
	
	@Test
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql",
			"/dataset/function.sql",
			"/dataset/data_type.sql",
			"/dataset/function_referenced_tables.sql",})
	public void updateFunctionMustPass() {
		Function function = this.functionService.findFunctionById( 1001L );

		function.setName("Test");
		function.setTdQuantity(5);
		function.setTrQuantity(1);
		function.setFunctionType(FunctionType.INSERT);
		function.setFunctionCategoryType(FunctionCategoryType.EE);
		function.setDocument(new Document(1000L));
		function.getReferencedTables().clear();
		function.getDataTypes().clear();

		Function functionSaved = this.functionService.updateFunction(function);
		assertNotNull(functionSaved);
		assertNotNull(functionSaved.getId());
		assertEquals("Test", functionSaved.getName());
		assertEquals(5, functionSaved.getTdQuantity().intValue());
		assertEquals(1, functionSaved.getTrQuantity().intValue());
		assertEquals(FunctionType.INSERT, functionSaved.getFunctionType());
		assertEquals(FunctionCategoryType.EE, functionSaved.getFunctionCategoryType());
		assertEquals(1000L, functionSaved.getDocument().getId().longValue());
		assertTrue(functionSaved.getReferencedTables().isEmpty());
		assertTrue(functionSaved.getDataTypes().isEmpty());
	}
	
	@Test
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql",
			"/dataset/function.sql",
			"/dataset/data_type.sql",
			"/dataset/function_referenced_tables.sql",})
	public void listFunctionMustPass() {
		Page<Function> functions = this.functionService.listFunctionByDocumentId( 1000L, null );
		
		assertFalse( functions.getContent().isEmpty() );
		assertTrue( functions.getContent().stream().allMatch( function -> function.getName() != null ));
		assertTrue( functions.getContent().stream().allMatch( function -> function.getFunctionType() != null ));
		assertTrue( functions.getContent().stream().allMatch( function -> function.getFunctionCategoryType() != null ));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Sql({	"/dataset/project.sql",
			"/dataset/document.sql",
			"/dataset/function.sql",
			"/dataset/data_type.sql",
			"/dataset/function_referenced_tables.sql",})
	public void deleteFunctionMustPass() {
		this.functionService.deleteFunction( 1001L );
		
		this.functionService.findFunctionById( 1001L );
	}

}

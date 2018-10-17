package com.muchael.freePA.domain.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FunctionTest {

	@Test
	public void getTdQuantityMustPass() {
		Function function = new Function();
		function.setTdQuantity(5);

		assertEquals(5, function.getTdQuantity().intValue());

		function.getDataTypes().add(new DataType("Name", function));
		function.getDataTypes().add(new DataType("Number", function));
		
		assertEquals(2, function.getTdQuantity().intValue());
	}
	
	@Test
	public void getTrQuantityMustPass() {
		Function function = new Function();
		function.setTrQuantity(5);

		assertEquals(5, function.getTrQuantity().intValue());

		function.getReferencedTables().add(new Function(1L));
		function.getReferencedTables().add(new Function(2L));
		
		assertEquals(2, function.getTrQuantity().intValue());
	}
}

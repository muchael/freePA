package com.muchael.freePA.infrastructure.hibernate.dialect;

import com.muchael.freePA.infrastructure.hibernate.functions.PostgreSQLFilterFunction;

/**
 * 
 * @author rodrigo@eits.com.br
 */
public class PostgreSQLDialect extends org.hibernate.dialect.PostgreSQL9Dialect 
{
	/**
	 * 
	 */
	public PostgreSQLDialect() 
	{
		super.registerFunction("FILTER", new PostgreSQLFilterFunction());
	}
}
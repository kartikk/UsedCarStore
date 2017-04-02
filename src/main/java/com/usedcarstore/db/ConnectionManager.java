package com.usedcarstore.db;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

@Service
public class ConnectionManager {
	
	private static final String USERNAME = "harish";
	private static final String PASSWORD = "Mysore98!";
	private static final String JDBC_ORACLE_CONN = "jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl";
	private DataSource dataSource;
	
	
	public ConnectionManager() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create()
				.url(JDBC_ORACLE_CONN).username(USERNAME).password(PASSWORD);
		dataSource = dataSourceBuilder.build();
	}

	public DataSource getDataSource() {
		if(dataSource== null){
			System.out.println("data source is null");
		}
		return dataSource;
	}	
}

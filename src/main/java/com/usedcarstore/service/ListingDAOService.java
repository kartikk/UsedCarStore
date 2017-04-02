package com.usedcarstore.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import com.usedcarstore.db.ConnectionManager;
import com.usedcarstore.model.Listing;

@Service
public class ListingDAOService {

	private static final String TITLE = "TITLE";
	private static final String DATE_CREATED = "DATE_CREATED";
	private static final String STATUS = "STATUS";
	private static final String EMAIL = "EMAIL_ID";
	private static final String PRICE = "PRICE";
	private static final String REGISTRATION_NUMBER = "REGISTRATION_NUMBER";
	
	@Autowired
	private ConnectionManager connectionManager;

	public ListingDAOService() {

	}
	


	public List<Listing> getListings(final String key) {
		List<Listing> listings = new ArrayList<Listing>();
		Connection connection = null;
		try {
//			connection = DriverManager.getConnection(JDBC_ORACLE_CONN, USERNAME, PASSWORD);
		
			DataSource dataSource = connectionManager.getDataSource();
			connection = dataSource.getConnection();
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from LISTING WHERE TITLE LIKE  " + "'%" + key + "%'");
			while (rs.next()) {

				Listing listing = new Listing();
				listing.setTitle(rs.getString(TITLE));
				listing.setDateCreated(rs.getString(DATE_CREATED));
				listing.setStatus(rs.getString(STATUS));
				listing.setEmail(rs.getString(EMAIL));

				String regNo = rs.getString(REGISTRATION_NUMBER);
				/*
				 * System.out.println(regNo); ResultSet priceRs = statement
				 * .executeQuery("select PRICE from USED_CAR WHERE REGISTRATION_NUMBER = '"
				 * + regNo + "'"); while (priceRs.next()) {
				 * listing.setPrice(Double.valueOf(priceRs.getString(PRICE))); }
				 */
				System.out.println(listing);
				listings.add(listing);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				} else {
					System.out.println("connection is null");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listings;
	}

	/*
	 * public static void main(String[] args) { getListings("1234567890"); }
	 */

}

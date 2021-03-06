package com.alsis.shoppingcart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alsis.shoppingcart.dao.PersonDao;
import com.alsis.shoppingcart.domain.Person;
import com.alsis.shoppingcart.utils.ConnectionUtil;

public class PersonDaoImpl implements PersonDao {
	private ConnectionUtil util = ConnectionUtil.getUtil();

	@Override
	public Person find(String username) {
		Person person = null;
		String query = "SELECT * FROM PERSON WHERE USERNAME=?";

		try (Connection conn = util.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				person = new Person(rs.getLong("ID"), rs.getString("USERNAME"),
						rs.getString("PASSWORD"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return person;
	}

	@Override
	public boolean register(Person person) {
		String query = "INSERT INTO PERSON (USERNAME, PASSWORD)"
				+ "VALUES (?,?)";

		try (Connection conn = util.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, person.getUsername());
			pstmt.setString(2, person.getPassword());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Username already exist ! ");
			// printStackTrace();
			return false;
		}
		return true;

	}

}

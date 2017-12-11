package com.springboot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/hello")
	public String index() {

		DataSource ds = jdbcTemplate.getDataSource();
		Connection con = null;
		String s = null;
		try {
			con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(" select first_name from t_user_main where user_id = 1 ");
			while(rs.next()) {
				s = rs.getString(1);
				System.out.println(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Greetings "+s;
	}

}

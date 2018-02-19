package org.mishra.aop.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DAOImpl {
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	private JdbcTemplate jdbcTemplate;	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void getCountOfUser(){
		long count= this.jdbcTemplate.queryForObject("SELECT count(userId) from USER_", Long.class);
		System.out.println(count);
	}
	
	public void getAllUsersName(){
		List<User> users=  this.jdbcTemplate.queryForList("SELECT firstName from USER_",User.class);
		System.out.println(users.size());
		//System.out.println(user.getUserId());
	}
	

	
	
	private final class UserRowMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet resultset, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			User user=new User();
			user.setName(resultset.getString("firstName"));
			user.setUserId(resultset.getLong("userId"));
			return user;
		}
		
	}
	
}

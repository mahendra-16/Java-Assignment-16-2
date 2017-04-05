package com.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class SpringJDBC {
	
	public static void main(String[] args) {
		
		String sql = "select * from springjdbc";

		ApplicationContext cent = new ClassPathXmlApplicationContext("spring.xml");
		
		DataSource ds = (DataSource)cent.getBean("dataSource");
		
		Connection con = DataSourceUtils.getConnection(ds);
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString(1);
				String email = rs.getString(2);
				String country = rs.getString(3);
				int id = rs.getInt(4);
				System.out.println(name + " - " + email + " - " + country + " - " + id);				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try{
				con.close();
			}catch (SQLException e1){
				
			}
			
		}	
		
	}

}

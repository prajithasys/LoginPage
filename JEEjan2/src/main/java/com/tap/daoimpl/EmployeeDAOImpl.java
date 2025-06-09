package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tap.dao.EmployeeDAO;
import com.tap.models.Employee;
import com.tap.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	
	private String INSERT = "INSERT INTO `employee`(`name`,`email`,`password`,`phone`,`address`) VALUES(?,?,?,?,?)";
	private String SELECT = "SELECT `name`,`password` FROM `employee` WHERE `name` = ?";

	public void addEmployee(Employee e)
	{
		try(Connection connection = DBConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(INSERT);
		){
			
			statement.setString(1,e.getName());
			statement.setString(2,e.getEmail());
			statement.setString(3,e.getPassword());
			statement.setString(4,e.getPhone());
			statement.setString(5,e.getAddress());
			
			int i = statement.executeUpdate();
			
			System.out.println(i);
			
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeByName(String name) {
		
		try(Connection connection = DBConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(SELECT );
		)
		{
			statement.setString(1, name);
			
			var resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				
				Employee e = new Employee();
				e.setName(resultSet.getString("name"));
				e.setPassword(resultSet.getString("password"));
				
				return e;
			}
			else
			{
				System.out.println("No employee found with name: " + name);
						
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
}

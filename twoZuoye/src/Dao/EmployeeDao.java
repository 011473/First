package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Employee;

public interface EmployeeDao {
	public List<Employee> liee();
	
	
	
	public int delete(@Param("del")int del);
	
	
	public int deleteG(@Param("delg")int delg);
	
	public int insert(Employee ee);
}

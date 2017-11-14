package Dao;

import pojo.company;

public interface companyDao {
	public int insert (company com);
	
	public int update(company com);
	
	public int select();
}

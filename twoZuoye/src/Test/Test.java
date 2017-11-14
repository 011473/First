package Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Dao.EmployeeDao;
import Dao.companyDao;

import pojo.Employee;
import pojo.company;

public class Test {
	
	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory ssf = ssfb.build(is);
		SqlSession session = ssf.openSession();
		
		List<Employee> list = session.getMapper(EmployeeDao.class).liee();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		fnag();

	}
	public static void fnag() throws IOException{
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory ssf = ssfb.build(is);
		SqlSession session = ssf.openSession();
		System.out.println("1.删除指定员工  , 2.删除指定公司的所有员工 3.新增一个员工  4.新增一个公司 5.修改指定公司的名字  6.查询指定公司的所有员工");
		Scanner input = new Scanner(System.in);
		switch (input.nextInt()) {
		case 1:
			System.out.println("员工ID：");
			int id = input.nextInt();
			int num= session.getMapper(EmployeeDao.class).delete(id);
			session.commit();
			if(num>0){
				System.err.println("删除成功！");
				fnag();
			}else{
				System.err.println("删除sb！");
			}
			break;
		case 2:
			System.out.println("输入公司Id：");
			int gid = input.nextInt();
			int gnum =session.getMapper(EmployeeDao.class).deleteG(gid);
			session.commit();
			if(gnum>0){
				System.err.println("删除成功！");
				fnag();
			}else{
				System.err.println("删除sb！");
			}
			break;
		case 3:
			System.out.println("输入姓名：");
			String nameString = input.next();
			System.out.println("输入公司ID");
			int gids = input.nextInt();
			Employee e = new Employee();
			e.setEname(nameString);
			e.setCompanyId(gids);
			int nim = session.getMapper(EmployeeDao.class).insert(e);
			session.commit();
			if(nim>0){
				System.err.println("新增成功！");
				fnag();
			}else {
				System.err.println("新增sb！");
			}
			break;
		case 4:
			System.out.println("请输入一个公司名称：");
			String Gname = input.next();
			company c = new company();
			c.setCname(Gname);
			int gnums=session.getMapper(companyDao.class).insert(c);
			session.commit();
			if (gnums>0) {
				System.out.println("新增公司成功！");
				fnag();
			}else {
				System.err.println("新增sb！");
			}
			break;
		case 5:
			System.out.println("输入公司ID");
			int Gaid = input.nextInt();
			System.out.println("修改的值：");
			String hh = input.next();
			company c1 = new company();
			c1.setCid(Gaid);
			c1.setCname(hh);
			int nis= session.getMapper(companyDao.class).update(c1);
			session.commit();
			if (nis>0) {
				System.out.println("修改成功！");
				fnag();
			}else{
				System.out.println("修改失败！");
			}
			break;
		case 6:
			break;
		default:
			System.out.println("退出");
			break;
		}
		System.out.println();
		
	}
}

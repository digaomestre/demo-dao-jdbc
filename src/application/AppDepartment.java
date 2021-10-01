package application;

import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class AppDepartment {

	public static void main(String[] args) {
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Department dep = depDao.findById(4);
		System.out.println(dep);
		
		System.out.println("=====================");
		List<Department>list = new ArrayList<>();
		list = depDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		//depDao.deleteById(3);
		//System.out.println("Deleted sucess");
		
		dep = depDao.findById(4);
		dep.setName("Cursos");
		depDao.update(dep);
		System.out.println("Updated sucess!!");
		System.out.println(dep);
		
		System.out.println("=========================");
		Department newDep = new Department(null, "peripherals");
		depDao.insert(newDep);
		System.out.println("Inserted sucess");
		List<Department> newList = new ArrayList<>();
		newList = depDao.findAll();
		
		for(Department d : newList) {
			System.out.println(d);
		}
		
		DB.closeConnection();

	}

}

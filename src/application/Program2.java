package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		// 1º -> findById ---------------------------------------------------
		System.out.println("Test 1: Department -> findById");

		Department dep = departmentDao.findById(3);

		System.out.println("Department of Id: " + dep);

		System.out.println();

		// 2º -> findAll ----------------------------------------------------
		System.out.println("Test 2: Department -> findAll ");

		List<Department> listDep = departmentDao.findAll();

		for (Department rowDep : listDep) {
			System.out.println("Id: " + rowDep.getId() + " -> Name: " + rowDep.getName());
		}

		System.out.println();

		// 3º -> insert ----------------------------------------------------
		System.out.println("Test 3: Department -> insert ");

		Department newDep = new Department();
		newDep.setName("Videos");

		departmentDao.insert(newDep);

		System.out.println("Inserted! New Id: " + newDep.getId());

		System.out.println();

		// 4º -> insert ----------------------------------------------------
		System.out.println("Test 4: Department -> update ");

		Department updateDep = departmentDao.findById(6);
		updateDep.setName("Update Test");

		departmentDao.update(updateDep);

		System.out.println("Updating Completed");

		// 5º -> insert ----------------------------------------------------
		System.out.println("Test 5: Department -> delete ");

		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);		

		System.out.println("Delete Completed");

	}

}

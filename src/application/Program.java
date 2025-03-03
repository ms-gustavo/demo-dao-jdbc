package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller FindById ===");
		Seller seller = sellerDao.findById(9);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> depSeller = sellerDao.findByDepartment(department);
		for(Seller obj : depSeller) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: seller FindAll ===");
		List<Seller> sellerList = sellerDao.findAll();
		for(Seller sell : sellerList) {
			System.out.println(sell);
		}
		
		System.out.println("=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(3);
		System.out.println(seller);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update Complete");
		
		System.out.println("=== TEST 5: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("==== DEPARTMENT TESTS ====");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 6: Department insert ===");
		Department newDepartment = new Department(null, "D3");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 7: Department update ===");
		Department newestDepartment = departmentDao.findById(1);
		newestDepartment.setName("Notebooks");
		departmentDao.update(newestDepartment);
		System.out.println("Update Complete");
		
		System.out.println("=== TEST 8: Department FindAll ===");
		List<Department> departmentList = departmentDao.findAll();
		for(Department dep : departmentList) {
			System.out.println(dep);
		}
		
		System.out.println("=== TEST 9: department delete ===");
		System.out.println("Enter id for delete test: ");
		int idDepartment = sc.nextInt();
		departmentDao.deleteById(idDepartment);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}

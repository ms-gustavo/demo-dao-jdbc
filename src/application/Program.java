package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
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
		seller = sellerDao.findById(1);
		System.out.println(seller);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update Complete");
		
		System.out.println("=== TEST 5: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}

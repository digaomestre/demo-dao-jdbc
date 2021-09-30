package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(4);
		
		System.out.println(seller);
		System.out.println("==================================");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller obj : list) {
			
			System.out.println(obj);
		}
		System.out.println("================================");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("================================");
		
		//Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 5000.0, dep);
		//sellerDao.insert(newSeller);
		//System.out.println("Inserted! new id = " + newSeller.getId());
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Wine");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Updated sucess!!!");
		System.out.println(seller);
	}

}

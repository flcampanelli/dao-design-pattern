package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: Seller findAll ===");
        sellers = sellerDao.findAll();
        for (Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Endrick", "endrick@gmail.com", LocalDate.now(), 6000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
    }
}

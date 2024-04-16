package application;

import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "Books");
        Seller seller = new Seller(
                21,
                "Bob",
                "bob@gmail.com",
                LocalDate.now(),
                3000.0,
                department
        );
        System.out.println(department);
        System.out.println(seller);
    }
}
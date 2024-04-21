package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Department findById ===");
        Department department = departmentDao.findById(4);
        System.out.println(department);

        System.out.println("\n=== Department findAll ===");
        List<Department> departments = departmentDao.findAll();
        for (Department dep: departments) {
            System.out.println(dep);
        }

        System.out.println("\n=== Department insert ===");
        Department newDepartment = new Department(null, "Games");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== Department update ===");
        department = departmentDao.findById(3);
        department.setName("Music");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== Department delete ===");
        System.out.print("Enter an id for deletion test: ");
        int id = scanner.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        scanner.close();
    }
}

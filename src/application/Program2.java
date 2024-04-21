package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: Department findById ===");
        Department department = departmentDao.findById(4);
        System.out.println(department);

        System.out.println("\n=== Test 2 Department findAll ===");
        List<Department> departments = departmentDao.findAll();
        for (Department dep: departments) {
            System.out.println(dep);
        }

        System.out.println("\n=== Test 3: Department insert ===");
        Department newDepartment = new Department(null, "Games");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== Test 4: Department update ===");
        department = departmentDao.findById(3);
        department.setName("Music");
        departmentDao.update(department);
        System.out.println("Update completed");
    }
}

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
    }
}

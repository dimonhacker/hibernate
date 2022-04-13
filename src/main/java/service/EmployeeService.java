package service;

import dao.DAO;
import daoImpl.EmployeeDAOImpl;
import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private DAO<Employee> dao = new EmployeeDAOImpl();

    public void addEmployee(Employee employee) {
        try {
            dao.add(employee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Employee> getAll() {
        List<Employee> employeeList = null;
        try {
            employeeList = dao.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public Employee getById(long id) {
        Employee employee = null;
        try {
            employee = dao.getById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    public void updateEmployee(Employee employee) {
        try {
            dao.update(employee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeEmployee(Employee employee) {
        try {
            dao.remove(employee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

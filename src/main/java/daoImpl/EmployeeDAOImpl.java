package daoImpl;


import bl.SessionUtil;
import dao.DAO;
import entity.Address;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements DAO<Employee> {

    SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void add(Employee employee) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.persist(employee);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        String sql = "Select * from EMPLOYEE";
        Query query = session.createNativeQuery(sql, Employee.class);
        List<Employee> employeeList = query.list();
        sessionUtil.closeTransactionSession();
        return employeeList;
    }

    @Override
    public Employee getById(long id) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        String sql = "Select * from EMPLOYEE where id = :id";
        Query query = session.createNativeQuery(sql, Employee.class);
        query.setParameter(1, id);
        Employee employee = (Employee) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.merge(employee);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void remove(Employee employee) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(employee);
        sessionUtil.closeTransactionSession();
    }
}

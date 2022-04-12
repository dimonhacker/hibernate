package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class Domain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Address address = new Address();
        address.setCountry("Russia");
        address.setCity("Vologda");
        address.setStreet("Levicheva");
        address.setPostCode("160000");

        Project project = new Project();
        project.setTitle("New Project");

        Employee employee = new Employee();
        employee.setFirstName("Vasya");
        employee.setLastName("Pupkin");
        employee.setAddress(address);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);
        employee.setBirthday(new Date(calendar.getTime().getTime()));

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        session.persist(address);
        session.persist(project);
        session.persist(employee);

        session.getTransaction().commit();
        HibernateUtil.shutDown();
    }
}
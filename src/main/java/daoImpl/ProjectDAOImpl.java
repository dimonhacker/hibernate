package daoImpl;

import bl.SessionUtil;
import dao.DAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProjectDAOImpl implements DAO<Project> {
    SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void add(Project project) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(project);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Project> getAll() throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        String sql = "Select * from PROJECT";
        Query query = session.createNativeQuery(sql, Project.class);
        List<Project> projectList = query.list();
        sessionUtil.closeTransactionSession();
        return projectList;
    }

    @Override
    public Project getById(long id) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        String sql = "Select * from PROJECT where id = :id";
        Query query = session.createNativeQuery(sql, Project.class);
        query.setParameter("id", id);
        Project project = (Project) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.merge(project);

        sessionUtil.closeTransactionSession();
    }

    @Override
    public void remove(Project project) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(project);
        sessionUtil.closeTransactionSession();
    }
}

package service;

import dao.DAO;
import daoImpl.ProjectDAOImpl;
import entity.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    private DAO<Project> dao = new ProjectDAOImpl();

    public void addProject(Project project) {
        try {
            dao.add(project);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Project> getAll() {
        List<Project> projectList = null;
        try {
            projectList = dao.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return projectList;
    }

    public Project getById(long id) {
        Project project = null;
        try {
            project = dao.getById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return project;
    }

    public void updateProject(Project project) {
        try {
            dao.update(project);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeProject(Project project) {
        try {
            dao.remove(project);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

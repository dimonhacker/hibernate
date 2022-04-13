package dao;

import entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    //create
    void add(T t) throws SQLException;

    //read
    List<T> getAll() throws SQLException;

    //get
    T getById(long id) throws SQLException;

    //update
    void update(T t) throws SQLException;

    //delete
    void remove(T t) throws SQLException;
}

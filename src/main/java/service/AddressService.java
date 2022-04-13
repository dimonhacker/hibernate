package service;

import bl.SessionUtil;
import dao.DAO;
import daoImpl.AddressDAOImpl;
import entity.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressService {

    private DAO<Address> dao = new AddressDAOImpl();

    public void addAddress(Address address) {
        try {
            dao.add(address);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Address> getAll() {
        List<Address> addressList = null;
        try {
            addressList = dao.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return addressList;
    }

    public Address getById(long id) {
        Address address = null;
        try {
            address = dao.getById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return address;
    }

    public void updateAddress(Address address) {
        try {
            dao.update(address);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeAddress(Address address) {
        try {
            dao.remove(address);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

package daoImpl;


import bl.SessionUtil;
import dao.DAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AddressDAOImpl implements DAO<Address> {

    SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void add(Address address) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(address);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        String sql = "Select * from ADDRESS";
        Query query = session.createNativeQuery(sql, Address.class);
        List<Address> addressList = query.list();
        sessionUtil.closeTransactionSession();
        return addressList;
    }

    @Override
    public Address getById(long id) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        String sql = "Select * from ADDRESS where id = :id";
        Query query = session.createNativeQuery(sql, Address.class);
        query.setParameter("id", id);
        Address address = (Address) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.merge(address);

        sessionUtil.closeTransactionSession();
    }

    @Override
    public void remove(Address address) throws SQLException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(address);
        sessionUtil.closeTransactionSession();
    }
}

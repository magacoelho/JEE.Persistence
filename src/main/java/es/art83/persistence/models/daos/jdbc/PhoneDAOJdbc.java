package es.art83.persistence.models.daos.jdbc;

import java.util.List;

import es.art83.persistence.models.daos.PhoneDAO;
import es.art83.persistence.models.entities.Phone;

public class PhoneDAOJdbc extends GenericDAOJdbc<Phone, Integer> implements PhoneDAO {

    @Override
    public void create(Phone entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Phone read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Phone entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Phone> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}

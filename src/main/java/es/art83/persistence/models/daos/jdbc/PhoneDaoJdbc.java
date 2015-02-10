package es.art83.persistence.models.daos.jdbc;

import java.util.List;

import es.art83.persistence.models.daos.PhoneDao;
import es.art83.persistence.models.entities.Phone;

public class PhoneDaoJdbc extends GenericDaoJdbc<Phone, Integer> implements PhoneDao {

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

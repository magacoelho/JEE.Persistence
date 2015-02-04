package es.art83.persistence.models.daos.jdbc;

import java.util.List;

import es.art83.persistence.models.daos.BoatDAO;
import es.art83.persistence.models.entities.Boat;

public class BoatDAOJdbc extends GenericDAOJdbc<Boat,Integer>implements BoatDAO {

    @Override
    public void create(Boat entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Boat read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Boat entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Boat> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}

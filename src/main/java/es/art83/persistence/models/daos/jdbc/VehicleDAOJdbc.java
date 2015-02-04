package es.art83.persistence.models.daos.jdbc;

import java.util.List;

import es.art83.persistence.models.daos.VehicleDAO;
import es.art83.persistence.models.entities.Vehicle;

public class VehicleDAOJdbc extends GenericDAOJdbc<Vehicle, Integer> implements VehicleDAO {

    @Override
    public void create(Vehicle entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Vehicle read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Vehicle entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Vehicle> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}

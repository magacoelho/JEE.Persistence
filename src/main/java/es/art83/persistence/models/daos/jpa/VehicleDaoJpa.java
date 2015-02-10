package es.art83.persistence.models.daos.jpa;

import es.art83.persistence.models.daos.VehicleDao;
import es.art83.persistence.models.entities.Vehicle;

public class VehicleDaoJpa extends GenericDaoJpa<Vehicle, Integer> implements VehicleDao {

    public VehicleDaoJpa() {
        super(Vehicle.class);
    }

}

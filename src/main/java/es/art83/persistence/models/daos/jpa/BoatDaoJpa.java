package es.art83.persistence.models.daos.jpa;

import es.art83.persistence.models.daos.BoatDao;
import es.art83.persistence.models.entities.Boat;

public class BoatDaoJpa extends GenericDaoJpa<Boat, Integer> implements BoatDao {

    public BoatDaoJpa() {
        super(Boat.class);
    }

}

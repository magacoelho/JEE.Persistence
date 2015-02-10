package es.art83.persistence.models.daos.jpa;

import es.art83.persistence.models.daos.PhoneDao;
import es.art83.persistence.models.entities.Phone;

public class PhoneDaoJpa extends GenericDaoJpa<Phone, Integer> implements PhoneDao {

    public PhoneDaoJpa() {
        super(Phone.class);
    }

}

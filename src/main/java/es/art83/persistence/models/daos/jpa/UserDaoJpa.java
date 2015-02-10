package es.art83.persistence.models.daos.jpa;

import es.art83.persistence.models.daos.UserDao;
import es.art83.persistence.models.entities.User;

public class UserDaoJpa extends GenericDaoJpa<User,Integer>implements UserDao {

    public UserDaoJpa() {
        super(User.class);
    }

 }

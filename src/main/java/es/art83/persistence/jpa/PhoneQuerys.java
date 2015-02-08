package es.art83.persistence.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.art83.persistence.models.utils.PhoneType;

public class PhoneQuerys {
    private EntityManager entityManager;

    public PhoneQuerys() {
        entityManager = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        List<Phone> phones = new ArrayList<Phone>();
        phones.add(new Phone(PhoneType.HOME, 999));
        phones.add(new Phone(PhoneType.MOBILE, 666));
        phones.add(new Phone(PhoneType.WORK, 111));
        phones.add(new Phone(null, 000));
        phones.add(new Phone(PhoneType.MOBILE, 444));
        phones.add(new Phone(PhoneType.WORK, 222));
        // Create
        entityManager.getTransaction().begin();
        for (Phone phone : phones) {
            entityManager.persist(phone);
        }
    }

    private static final String NUMBER_OF_PHONES = "SELECT COUNT(p) FROM Phone p";

    private long numberOfPhonesJpql() {
        return (long) entityManager.createQuery(NUMBER_OF_PHONES).getSingleResult();
    }

    private long numberOfPhonescriteria() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteria.createQuery(Long.class);
        Root<Phone> rootPhone = countQuery.from(Phone.class);
        countQuery.select(criteria.count(rootPhone));
        TypedQuery<Long> longQuery = entityManager.createQuery(countQuery);
        return longQuery.getSingleResult();
    }

    private static final String FIND_ALL_PHONES = "SELECT p FROM Phone p";

    @SuppressWarnings("unchecked")
    private List<Phone> findAllPhonesJpql() {
        return (List<Phone>) entityManager.createQuery(FIND_ALL_PHONES).getResultList();
    }

    private List<Phone> findAllPhonesCriteria() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> query = criteria.createQuery(Phone.class);
        Root<Phone> rootPhone = query.from(Phone.class);
        query.select(rootPhone);
        TypedQuery<Phone> phoneQuery = entityManager.createQuery(query);
        return phoneQuery.getResultList(); // Se buscan todos
    }

    @SuppressWarnings("unchecked")
    private List<Phone> findPhonesJpql(int index, int size) {
        Query query = entityManager.createQuery(FIND_ALL_PHONES);
        query.setFirstResult(index);
        query.setMaxResults(size);
        return (List<Phone>) query.getResultList();
    }

    private List<Phone> findPhonesCriteria(int index, int size) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> query = criteria.createQuery(Phone.class);
        Root<Phone> rootPhone = query.from(Phone.class);
        query.select(rootPhone);
        TypedQuery<Phone> phoneQuery = entityManager.createQuery(query);
        phoneQuery.setFirstResult(index);
        phoneQuery.setMaxResults(size);
        return phoneQuery.getResultList(); // Se buscan todos

    }

    private static final String FIND_PHONE_TYPES_DISTINCT = "SELECT DISTINCT p.phoneType FROM Phone p"
            + " WHERE (p.number = 666 OR p.id > 2) AND p.phoneType IS NOT NULL ORDER BY p.phoneType";

    @SuppressWarnings("unchecked")
    private List<PhoneType> findPhoneTypesDistinctJpql() {
        return (List<PhoneType>) entityManager.createQuery(FIND_PHONE_TYPES_DISTINCT)
                .getResultList();
    }

    private List<PhoneType> findPhoneTypesDistinctCriteria() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PhoneType> query = criteria.createQuery(PhoneType.class);
        Root<Phone> rootPhone = query.from(Phone.class);

        query.select(rootPhone.get("phoneType")).distinct(true);

        Predicate p1 = criteria.equal(rootPhone.get("number").as(Integer.class), 666);
        Predicate p2 = criteria.gt(rootPhone.get("id"), 2);
        Predicate p3 = criteria.isNotNull(rootPhone.get("phoneType"));
        Predicate predicate = criteria.and(criteria.or(p1, p2), p3);
        query.where(predicate);
        query.orderBy(criteria.asc(rootPhone.get("phoneType")));
        TypedQuery<PhoneType> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(0); // Se buscan todos
        return typedQuery.getResultList();

    }
    
    private static final String JPQL1= "SELECT p.number FROM Phone p WHERE p.id > 3 AND p.phoneType IS NOT NULL";

    @SuppressWarnings("unchecked")
    private List<PhoneType> findJpql1() {
        return (List<PhoneType>) entityManager.createQuery(JPQL1)
                .getResultList();
    }


    public static void main(String[] args) {
        PhoneQuerys criteriaPhone = new PhoneQuerys();

        System.out.println("numberOfPhonesJpql: " + criteriaPhone.numberOfPhonesJpql());
        System.out.println("numberOfPhonesCriteria: " + criteriaPhone.numberOfPhonescriteria());

        System.out.println("findAllPhonesJpql: " + criteriaPhone.findAllPhonesJpql());
        System.out.println("findAllPhonesCriteria: " + criteriaPhone.findAllPhonesCriteria());

        System.out.println("findAllPhonesJpql: " + criteriaPhone.findPhonesJpql(0, 2));
        System.out.println("findPhonesCriteria: " + criteriaPhone.findPhonesCriteria(0, 2));

        System.out.println("findPhoneTypesDistinct: " + criteriaPhone.findPhoneTypesDistinctJpql());
        System.out.println("findPhoneTypesDistinct: "
                + criteriaPhone.findPhoneTypesDistinctCriteria());
        
        System.out.println("findJpql1: " + criteriaPhone.findJpql1());
    }
    


}

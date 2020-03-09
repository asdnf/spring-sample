package org.test.service.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.test.service.data.Dog;

import java.util.List;

public class DogService {

    private HibernateSessionFactory hibernateSessionFactory;

    public DogService(HibernateSessionFactory hibernateSessionFactory) {
        this.hibernateSessionFactory = hibernateSessionFactory;
    }

    public void saveDog(Dog dog) {
        Session session = hibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(dog);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        throw new IllegalStateException();
    }

    public List<Dog> findDogs(String name) {
        Session session = hibernateSessionFactory.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Dog dog where dog.name like :name");
            query.setString("name", name);
            List<Dog> dogs = query.list();
            return dogs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

}

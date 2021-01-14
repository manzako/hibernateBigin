package model;

import entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connect");

    public void saveCustomer(Customer customer){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if (customer.getId()==null){
            em.persist(customer);
        }else {
            em.merge(customer);
        }

        tx.begin();
        tx.commit();
    }

    public Customer showCustomer(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class,id);
    }

    public void deleteCustomer(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.find(Customer.class,id));
        tx.commit();
    }
}

package com.example.bidblitz.repository;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.Payment;
import com.example.bidblitz.util.DatabaseUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PaymentRepository {

    public boolean add(Payment payment) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(payment);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding payment: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(Payment payment) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(payment);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error updating payment: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public Payment findById(int paymentId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.find(Payment.class, paymentId);
        } finally {
            em.close();
        }
    }

    public List<Payment> findAll() {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Payment> findByStatus(String status) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT p FROM Payment p WHERE p.status = :status", Payment.class)
                    .setParameter("status", status)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Payment> findByBuyerId(int buyerId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT p FROM Payment p WHERE p.buyer.id = :buyerId", Payment.class)
                    .setParameter("buyerId", buyerId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}

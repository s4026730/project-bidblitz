package com.example.bidblitz.repository;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.ActivityLog;
import com.example.bidblitz.util.DatabaseUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ActivityLogRepository {

    public boolean add(ActivityLog log) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding log: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public List<ActivityLog> findAll() {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery("SELECT l FROM ActivityLog l ORDER BY l.timestamp DESC", ActivityLog.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<ActivityLog> findByUserId(int userId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT l FROM ActivityLog l WHERE l.actor.id = :userId ORDER BY l.timestamp DESC",
                    ActivityLog.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}

package com.example.bidblitz.repository;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.Bid;
import com.example.bidblitz.util.DatabaseUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class BidRepository {

    public boolean add(Bid bid) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(bid);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding bid: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public Bid findById(int bidId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.find(Bid.class, bidId);
        } finally {
            em.close();
        }
    }

    public List<Bid> findAll() {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery("SELECT b FROM Bid b", Bid.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Bid> findByBidderId(int bidderId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT b FROM Bid b WHERE b.bidder.id = :bidderId ORDER BY b.bidDateTime DESC", Bid.class)
                    .setParameter("bidderId", bidderId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Bid> findByItemId(int itemId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT b FROM Bid b WHERE b.item.id = :itemId ORDER BY b.amount DESC", Bid.class)
                    .setParameter("itemId", itemId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}

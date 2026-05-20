package com.example.bidblitz.repository;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.Auction;
import com.example.bidblitz.util.DatabaseUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class AuctionRepository {

    public boolean add(Auction auction) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(auction);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding auction: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(Auction auction) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(auction);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error updating auction: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(int auctionId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Auction auction = em.find(Auction.class, auctionId);
            if (auction != null) {
                em.remove(auction);
                em.getTransaction().commit();
                return true;
            }
            em.getTransaction().rollback();
            return false;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error deleting auction: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public Auction findById(int auctionId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.find(Auction.class, auctionId);
        } finally {
            em.close();
        }
    }

    public List<Auction> findAll() {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Auction a", Auction.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Auction> findByStatus(String status) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Auction a WHERE a.status = :status", Auction.class)
                    .setParameter("status", status)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Auction> findActive() {
        return findByStatus(Auction.ACTIVE);
    }

    public List<Auction> findByEndDateRange(LocalDateTime from, LocalDateTime to) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Auction a WHERE a.endDateTime >= :from AND a.endDateTime <= :to", Auction.class)
                    .setParameter("from", from)
                    .setParameter("to", to)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Auction> findDueAuctions() {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Auction a WHERE a.status = :status AND a.endDateTime < :now", Auction.class)
                    .setParameter("status", Auction.ACTIVE)
                    .setParameter("now", LocalDateTime.now())
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Auction> findByCategoryId(int categoryId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Auction a WHERE a.item.category.id = :categoryId", Auction.class)
                    .setParameter("categoryId", categoryId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Auction> findBySellerId(int sellerId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Auction a WHERE a.item.seller.id = :sellerId", Auction.class)
                    .setParameter("sellerId", sellerId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}

package com.example.bidblitz.repository;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.Item;
import com.example.bidblitz.util.DatabaseUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ItemRepository {

    public boolean add(Item item) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding item: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(Item item) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(item);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(int itemId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Item item = em.find(Item.class, itemId);
            if (item != null) {
                em.remove(item);
                em.getTransaction().commit();
                return true;
            }
            em.getTransaction().rollback();
            return false;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public Item findById(int itemId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.find(Item.class, itemId);
        } finally {
            em.close();
        }
    }

    public List<Item> findAll() {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Item> findByCategoryId(int categoryId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT i FROM Item i WHERE i.category.id = :categoryId", Item.class)
                    .setParameter("categoryId", categoryId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Item> findBySellerId(int sellerId) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT i FROM Item i WHERE i.seller.id = :sellerId", Item.class)
                    .setParameter("sellerId", sellerId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Item> searchByTitle(String keyword) {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT i FROM Item i WHERE LOWER(i.title) LIKE :keyword", Item.class)
                    .setParameter("keyword", "%" + keyword.toLowerCase() + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }
}

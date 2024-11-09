package com.example.sd19304.repository;

import com.example.sd19304.model.User;
import com.example.sd19304.utils.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // lấy ra danh sách toàn bộ user
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("select u from User u");
        list = query.getResultList();
        session.close();
        return list;
    }

    public User getById(Integer id) {
        User user = new User();
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("select  u from User u where u.id = :idUser");
        query.setParameter("idUser", id);
        user = (User) query.getSingleResult();
        return user;
    }

    public void saveOrUpdate(User user) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

}

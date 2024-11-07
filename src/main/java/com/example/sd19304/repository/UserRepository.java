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

    public void add(User user) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

}

package com.example.sd19304.repository;

import com.example.sd19304.model.DanhMuc;
import com.example.sd19304.model.SanPham;
import com.example.sd19304.model.User;
import com.example.sd19304.utils.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DanhMucRepo {

    public List<DanhMuc> getList() {
        List<DanhMuc> list = new ArrayList<>();
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("select s from DanhMuc s");
        list = query.getResultList();
        session.close();
        return list;
    }

    public DanhMuc getById(Integer id) {
        DanhMuc danhMuc = new DanhMuc();
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("select  u from DanhMuc u where u.id = :idDanhMuc");
        query.setParameter("idDanhMuc", id);
        danhMuc = (DanhMuc) query.getSingleResult();
        return danhMuc;
    }
}

package com.example.sd19304.repository;

import com.example.sd19304.model.SanPham;
import com.example.sd19304.model.SanPhamDto;
import com.example.sd19304.model.User;
import com.example.sd19304.servlet.SanPhamServlet;
import com.example.sd19304.utils.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {

    // su dung quan he trong lop thực thể
    public List<SanPham> getListSp() {
        List<SanPham> list = new ArrayList<>();
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("select s from SanPham s");
        list = query.getResultList();
        session.close();
        return list;
    }

    // su dung Dto
    public List<SanPhamDto> getList() {
        List<SanPhamDto> list = new ArrayList<>();
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery(
                "select new com.example.sd19304.model.SanPhamDto(sp.id,sp.maSanPham," +
                        "sp.tenSanPham, sp.trangThai,sp.ngayTao,dm.tenDanhMuc) \n" +
                        "from SanPham sp\n" +
                        " inner join DanhMuc dm\n" +
                        " on dm.id = sp.danhMuc.id");
        list = query.getResultList();
        session.close();
        return list;
    }

    public static void main(String[] args) {
        List<SanPhamDto> list = new SanPhamRepository().getList();
        for (SanPhamDto sanPhamDto : list) {
            System.out.println(sanPhamDto.toString());
        }
    }

}

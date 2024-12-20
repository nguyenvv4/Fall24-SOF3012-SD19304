package com.example.sd19304.servlet;

import com.example.sd19304.model.DanhMuc;
import com.example.sd19304.model.SanPham;
import com.example.sd19304.model.User;
import com.example.sd19304.repository.DanhMucRepo;
import com.example.sd19304.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {"/SanPhamServlet",
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/chi-tiet",
        "/san-pham/delete",
        "/san-pham/update",
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    DanhMucRepo danhMucRepo = new DanhMucRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // hien thi thong tin sau: id, ten san pham, ma san pham,
        // trang thai, ten danh muc cua san pham, ngay tao
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/hien-thi")) {
            List<SanPham> list = sanPhamRepository.getListSp();
            List<DanhMuc> listDm = danhMucRepo.getList();
            request.setAttribute("list", list);
            request.setAttribute("listDm", listDm);
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            System.out.println(user);
            request.getRequestDispatcher("/san_pham.jsp").forward(request, response);
        } else if (uri.contains("/chi-tiet")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getDetail(id);
            request.setAttribute("sanPham", sanPham);
            List<DanhMuc> listDm = danhMucRepo.getList();
            request.setAttribute("listDm", listDm);
            request.getRequestDispatcher("/chi-tiet.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getDetail(id);
            sanPhamRepository.delete(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/add")) {
            String maSanPham = request.getParameter("maSanPham");
            String tenSanPham = request.getParameter("tenSanPham");
            String trangThai = request.getParameter("trangThai");
            Integer idDanhMuc = Integer.parseInt(request.getParameter("danhMuc"));
            // cach de => de bug
//            DanhMuc danhMuc = new DanhMuc();
//            danhMuc.setId(idDanhMuc);
            // cach uy tin
            DanhMuc danhMuc = danhMucRepo.getById(idDanhMuc);
            // tu kiem tra loi

            SanPham sanPham = new SanPham(maSanPham, tenSanPham, trangThai, new Date(), danhMuc);
            sanPhamRepository.saveOrUpdate(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("/update")) {// truyen them id cho san pham
            Integer id = Integer.parseInt(request.getParameter("id"));
            String maSanPham = request.getParameter("maSanPham");
            String tenSanPham = request.getParameter("tenSanPham");
            String trangThai = request.getParameter("trangThai");
            Integer idDanhMuc = Integer.parseInt(request.getParameter("danhMuc"));
            DanhMuc danhMuc = danhMucRepo.getById(idDanhMuc);
            SanPham sanPham = new SanPham(id,maSanPham, tenSanPham, trangThai, new Date(), danhMuc);
            sanPhamRepository.saveOrUpdate(sanPham);
            response.sendRedirect("/san-pham/hien-thi");

        }
    }
}

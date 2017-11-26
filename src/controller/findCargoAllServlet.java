package controller;

import DAO.CargoDao;
import PO.Cargo;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hp on 2017/11/24.
 */
@WebServlet(name = "findCargoAllServlet",urlPatterns = "/findCargoAll")
public class findCargoAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = MybatisUtil.getSession();
        CargoDao dao = session.getMapper(CargoDao.class);

        List<Cargo> cargoList = dao.queryAll();
        request.getSession(true).setAttribute("cargoList",cargoList);
        response.sendRedirect("readCargoAll.jsp");
        session.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

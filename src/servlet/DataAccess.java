package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DataAccess")
public class DataAccess extends HttpServlet {

    public static final long serialVersionUID = 1L;

    public DataAccess() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //insert
    public void insert(HttpServletRequest request,HttpServletResponse response){
        try {
            String id =request.getParameter("id");
            String name =request.getParameter("name");
            String age =request.getParameter("age");
            String gender =request.getParameter("gender");
            String major =request.getParameter("major");
        }catch (Exception e){
            System.out.printf("");
        }
    }
}

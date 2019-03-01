package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpLoad")
@MultipartConfig
public class UpLoad extends HttpServlet {

    public static final long serialVersionUID = 1L;

    public UpLoad() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("file");
        String headerInfo = part.getHeader("content-disposition");
        String fileName = headerInfo.substring(headerInfo.lastIndexOf("=")+2,headerInfo.length()-1);
        String fileSavingFolder = this.getServletContext().getRealPath("/Upload");
        String fileSavingPath = fileSavingFolder + File.separator + fileName;
        System.out.println("headerinfo:"+headerInfo);
        System.out.println("filename:"+fileName);
        System.out.println("filesavingpath"+fileSavingPath);
        File file = new File(fileSavingFolder + File.separator);
        if(!file.exists()){
            file.mkdirs();
        }
        part.write(fileSavingPath);
        PrintWriter out = response.getWriter();
        out.println("doucument upload successful!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

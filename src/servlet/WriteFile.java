package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/WriteFile")
public class WriteFile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public WriteFile() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String fileName = "temp.text";
        String filePath = this.getServletContext().getRealPath(fileName);
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("J2EE course");
        bufferedWriter.newLine();
        bufferedWriter.write("servlet write file");
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
        out.println("<font size='2'>file write complete,path:"+file.getAbsolutePath()+"</font>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

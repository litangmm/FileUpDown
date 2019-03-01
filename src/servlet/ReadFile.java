package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/ReadFile")
public class ReadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadFile() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE>");
        out.println("<HTML>");
        out.println("   <Head><meta charset=\"UTF-8\"><TITLE>A Servlet</TITLE>");
        out.println("   <BODY>");
        out.println("   <XMP>");
        String fileName = "/WEB-INF/web.xml";
        String filePath = this.getServletContext().getRealPath(fileName);
        out.println("open file:" + filePath);
        out.println("context:");
        File file = new File(filePath);
        if (file.exists()) {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                out.println(line);

            }
            bufferedReader.close();

        } else {
            out.println("not found file");
        }
        out.println("   </XMP>");
        out.println("   </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

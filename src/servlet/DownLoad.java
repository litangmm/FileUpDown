package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet("/DownLoad")
public class DownLoad extends HttpServlet {

    public static final long serialVersionUID = 1L;

    public DownLoad() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String filepath = "/WEB-INF/web.xml";
            String fullFilePath = getServletContext().getRealPath(filepath);
            System.out.println(fullFilePath);
            File file = new File(fullFilePath);
            if(file.exists()){
                System.out.println("doucument exits");
                String filename = URLEncoder.encode(file.getName(),"UTF-8");
                response.reset();
                response.setContentType("text/xml");
                response.addHeader("Content-Disposition","attachment; filename=\""+filename+"\"");
                int fileLength = (int) file.length();
                System.out.println(fileLength);
                response.setContentLength(fileLength);
                if(fileLength != 0)
                {
                    InputStream inputStream = new FileInputStream(file);
                    byte[] buf = new byte[4096];
                    ServletOutputStream servletOutputStream = response.getOutputStream();
                    int readLength;
                    while (((readLength = inputStream.read(buf))!=1)){
                        servletOutputStream.write(buf,0,readLength);
                    }
                    inputStream.close();
                    servletOutputStream.flush();
                    servletOutputStream.close();
                }
            }else {
                System.out.println("doucument not exits");
                PrintWriter printWriter = response.getWriter();
                printWriter.println("document\""+fullFilePath+"\"not exits");

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

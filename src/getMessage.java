
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getMessage")
public class getMessage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        String info = " { \"name\":" + name + ",\"email\":" + email + ",\"subject\":" + subject + ",\"message\":" + message + " } ";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        String currentTime = dateFormat.format(date);

        File file = new File("message.txt");
        FileWriter fileWritter = new FileWriter(file.getName(), true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(currentTime + info + "\n");
        System.out.print(file.exists()+currentTime + info + "\n");
        bufferWritter.close();

        FileReader fr = new FileReader(file.getName());
        BufferedReader br = new BufferedReader(fr);
        System.out.print(br.readLine());
        System.out.print(file.getAbsolutePath());

        PrintWriter pw = response.getWriter();
        pw.write(info);
        pw.flush();
    }
}

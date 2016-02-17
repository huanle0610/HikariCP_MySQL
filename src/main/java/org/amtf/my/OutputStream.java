package org.amtf.my;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/output_stream.action")
public class OutputStream extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");

        ServletOutputStream out = resp.getOutputStream();
        out.write((message + "<br>").getBytes());
        out.flush(); // flush the header
        out.write((getNow() + "<br>").getBytes());
        out.flush(); // flush the navigation bar

        // write dynamic data here
        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        out.write((getNow() + "<br>").getBytes());
        out.write("End<br>".getBytes());
        out.flush(); // finally flush the footer
    }

    private String getNow() {
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

        return time_formatter.format(System.currentTimeMillis());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
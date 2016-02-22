package org.amtf.my;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/db_example.action")
public class DBExample extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");

        Connection connection = DBConnPool.getConnection();

        try  {
            Statement statement = connection.createStatement();

            // Setup table
            statement.addBatch("CREATE SCHEMA IF NOT EXISTS TEST;");
            statement.addBatch(
                    "CREATE TABLE IF NOT EXISTS TEST.TEST_TABLE " +
                            "(P_ID INT NOT NULL AUTO_INCREMENT, F1 INT, F2 INT, F3 INT, UNIQUE(P_ID), PRIMARY KEY(P_ID));"
            );
            statement.addBatch("INSERT INTO `test`.`test_table` ( `F1`, `F2`, `F3`) VALUES ( '2', '3', '4'); ");
            statement.addBatch("INSERT INTO `test`.`test_table` ( `F1`, `F2`, `F3`) VALUES ( '2', '3', '6'); ");

            statement.executeBatch();

//            statement.executeQuery("SELECT  sleep(30); ");


        } catch (SQLException e) {
            e.printStackTrace();
        }


        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
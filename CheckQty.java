import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckQty extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String sku = request.getParameter("sku");
    String s = "SELECT quantity from product where sku =  '"+ sku +"'  ";
    String result = DBHelper.doQuery(s);
    out.print(result);
    }
}

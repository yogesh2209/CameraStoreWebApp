import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OrderConfirmation extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {



      Cookie[] cookiesArray = request.getCookies();




      // cookie.setMaxAge(0);
      // cookie.setValue(null);
      // cookie.setPath("/");


    response.setContentType("text/html");
    PrintWriter out = response.getWriter(); //	 <link rel="stylesheet" type="text/css" href="cart.css" />
    String cssTag="<link rel='stylesheet' type='text/css' href='http://jadran.sdsu.edu/jadrn018/cart.css'>";
    String firstName = request.getParameter("fname_s");
    String lastName = request.getParameter("lname_s");
    String address = request.getParameter("address1_s");
    String state = request.getParameter("state_s");
    String city = request.getParameter("city_s");
    String zip = request.getParameter("zip_s");

    out.println("<html>");
    out.println("<head><title>Order Confirmation</title>"+cssTag+"</head>");
    out.println("<body>");
    if( cookiesArray != null ) {
             for (int i = 0; i < cookiesArray.length; i++) {
                Cookie cookie = cookiesArray[i];
                cookie.setMaxAge(0);
                cookie.setValue(null);
                cookie.setPath("/");
                response.addCookie(cookie);
             }
          }

    out.println("<div class = 'confirmation_div'>");
    out.println("<h1>Your order has been confirmed!</h1>");
    out.println("<h3>Its on the way!</h3>");
    out.println("</div>");
    out.println("<table id = 'confirmation_div_table'>");

    out.println("<tr>");
    out.println("<td>First Name</td>");
    out.println("<td>");
    out.println(firstName);
    out.println("</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Last Name</td>");
    out.println("<td>");
    out.println(lastName);
    out.println("</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Address</td>");
    out.println("<td>");
    out.println(address);
    out.println("</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>City</td>");
    out.println("<td>");
    out.println(city);
    out.println("</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>State</td>");
    out.println("<td>");
    out.println(state);
    out.println("</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Zip</td>");
    out.println("<td>");
    out.println(zip);
    out.println("</td>");
    out.println("</tr>");

    out.println("</table>");
    out.println("<br />");
    out.println("<br />");
    out.println("<a class = 'back_btn' href = " + "http://jadran.sdsu.edu/jadrn018/proj2.html"  + ">Back to main page</a>");
    out.println("<br />");
    out.println("</body>");
    out.println("</html>");

    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	doGet(request, response);
    }
}

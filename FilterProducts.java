import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FilterProducts extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String brand = request.getParameter("brand");
    String category = request.getParameter("category");

    String s = "";
    //ALL BRAND & NO CATEGORY
    if (brand.equals("All") && category.equals("none")) {
      s = "SELECT p.sku, v.vendor_name, c.category_name, p.vendorModel, p.description, p.features, p.cost, p.retail, p.quantity, p.image, p.catID, p.venID from vendor v, category c, product p where c.id = p.catID && v.id = p.venID";
    }
    else if (brand.equals("All") && !category.equals("none")) {
      s = "SELECT p.sku, v.vendor_name, c.category_name, p.vendorModel, p.description, p.features, p.cost, p.retail, p.quantity, p.image, p.catID, p.venID from vendor v, category c, product p where c.id = p.catID && v.id = p.venID  && p.catID = '"+ category +"' ";

    }
    else if (!brand.equals("All") && category.equals("none")) {
      s = "SELECT p.sku, v.vendor_name, c.category_name, p.vendorModel, p.description, p.features, p.cost, p.retail, p.quantity, p.image, p.catID, p.venID from vendor v, category c, product p where c.id = p.catID && v.id = p.venID && p.venID= '"+ brand +"' ";
    }
    else{
      s = "SELECT p.sku, v.vendor_name, c.category_name, p.vendorModel, p.description, p.features, p.cost, p.retail, p.quantity, p.image, p.catID, p.venID from vendor v, category c, product p where c.id = p.catID && v.id = p.venID && p.venID= '"+ brand +"' && p.catID = '"+ category +"' ";

    }

    String result = DBHelper.doQuery(s);
    out.print(result);
    }
}

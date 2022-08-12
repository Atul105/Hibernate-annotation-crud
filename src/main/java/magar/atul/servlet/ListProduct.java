package magar.atul.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import magar.atul.model.Product;
import magar.atul.util.HibernateSessionUtil;

@WebServlet("/list-products")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		try {
			//build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			//create session object
			Session session = factory.openSession();
			
			
			//read products
			List<Product> products = session.createQuery("from Product").list();
			
			//show data as table
			out.print("<h1>Products list</h1>");
			
			out.print("<style> table,td,th {"
					+"border:2px solid red;"
					+"padding:10px;"
					+"}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Product Id </th>");
			out.print("<th> Product Name </th>");
			out.print("<th> Product Price </th>");
			out.print("<th> Product Description </th>");
			out.print("<th> Product Created At </th>");
			out.print("<th> Product Modified At </th>");
			out.print("</tr>");
			
			for(Product p : products) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getPrice()+"</td>");
				out.print("<td>"+p.getDesc()+"</td>");
				out.print("<td>"+p.getCreatedAt()+"</td>");
				out.print("<td>"+p.getModifiedAt()+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			
			//close session
			session.close();
		} catch (Exception e) {
			out.println("<h3 style='color:red'>Hibernate Session Failed to Create</h3>");
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		
		
	}

}

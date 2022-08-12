package magar.atul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("add-product.html").include(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		//addtop nav
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		//fetch data from HTML form
		String productName = request.getParameter("name1");
		double productPrice = Double.parseDouble(request.getParameter("price1"));
		String productDesc = request.getParameter("desc1");
		
		try {
			//build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			//create session object
			Session session = factory.openSession();
			
			//create a product object
			Product product = new Product(productName,productPrice,productDesc); //same sequence as product.java->constructor
			
			//begin transcation
			Transaction tx = session.beginTransaction();
			
			//save product
			session.save(product);
			
			//commit transaction
			tx.commit();
			
			
			
			if(session != null) {
				out.println("<h3 style='color:green'>Product is Created Successfully</h3>");
			}
			//close session
			session.close();
		} catch (Exception e) {
			out.println("<h3 style='color:red'>Hibernate Session Failed to Create</h3>");
		}
		
	}

}

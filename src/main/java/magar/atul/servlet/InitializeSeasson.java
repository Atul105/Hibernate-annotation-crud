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

import magar.atul.util.HibernateSessionUtil;

@WebServlet("/init-session")
public class InitializeSeasson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		try {
			//build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			//create session object
			Session session = factory.openSession();
			
			if(session != null) {
				out.println("<h3 style='color:green'>Hibernate Session Created Successfully</h3>");
			}
		} catch (Exception e) {
			out.println("<h3 style='color:red'>Hibernate Session Failed to Create</h3>");
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

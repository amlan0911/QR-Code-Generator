import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
        response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String i=request.getParameter("userId");
		String n=request.getParameter("userName");
		String a=request.getParameter("userAge");
		String s=request.getParameter("userSalary");
		
		
		try {
			  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/RADIUS","root","Root");
			  
			  PreparedStatement prep = connection.prepareStatement("INSERT INTO RADIUS VALUES(?,?,?,?)");
			  prep.setObject(1, i);
			  prep.setObject(2, n);   //Dynamically setting the name.
			  prep.setObject(3, a);
			  prep.setObject(4, s);
			  
			  int j = prep.executeUpdate();
			  if(j>0)
				  out.print("Successfully Added");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
//		connection.close();
		out.close();
	}

}
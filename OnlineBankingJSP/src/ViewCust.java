


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmpBean;
import dao.MyDao;


/**
 * Servlet implementation class ViewCust
 */
@WebServlet("/ViewCust")
public class ViewCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCust() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		MyDao m=new MyDao();
	      ArrayList<EmpBean> list= m.viewCust();

	      RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
	     request.setAttribute("LIST", list);
	      rd.forward(request, response);

		
		PrintWriter out=response.getWriter();
		
		
		out.println("<center><a href=AHome><h4>Click here for go to Home Page</h2></a></center>");
		out.println("<center><a href=index.html><h4>Click here for Log Out</h2></a></center>");
 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

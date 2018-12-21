

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustCheck
 */
@WebServlet("/CustCheck")
public class CustCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustCheck() {
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
		PrintWriter out=response.getWriter();
		String acc=request.getParameter("account");
		String pass=request.getParameter("pass");
		//String c=request.getParameter("cname");
	

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productinf","root","root");
			PreparedStatement ps=con.prepareStatement("select * from customer where accountno=? and password=?");
			ps.setString(1, acc);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			int x1=0;
			if(rs.next())
				x1=1;
			if(x1==1)
			{ 
				HttpSession session = request.getSession();
			    session.setAttribute("cname", acc);
			  response.sendRedirect("CHome.jsp");
	//			out.println("<h1>Success</h1>");
			}
			else
				out.println("<h1>Wrong AccountNo. or Password</h1>");
			con.close();
			}catch(ClassNotFoundException | SQLException e)
		{
				out.println(e);
		}
	

	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Trans
 */
@WebServlet("/Trans")
public class Trans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trans() {
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
		
		String send=request.getParameter("sender");
		System.out.println(send);
		if(send!=null)
		{
		
		String rreceive=request.getParameter("receiver");
		int receive=Integer.parseInt(rreceive);
		String aamt=request.getParameter("amount");
		int amt=Integer.parseInt(aamt);
		 try
	        {
	        	Class.forName("com.mysql.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productinf","root","root");
	    		PreparedStatement ps1=con.prepareStatement("update customer set balance=balance-? where accountno=?");
	    		
	    		ps1.setInt(1,amt);
	    		ps1.setString(2, send);
	    		
	    		PreparedStatement ps2=con.prepareStatement("update customer set balance=balance+? where accountno=?");
	    		ps2.setInt(1, amt);
	    		ps2.setInt(2, receive);
	    		
	    		
	    		
	    		con.setAutoCommit(false);
	    		ps1.executeUpdate();
	    		ps2.executeUpdate();
	    		//out.println("Transcation completed");
	    		RequestDispatcher rd=request.getRequestDispatcher("Transaction.jsp");
				request.setAttribute("msg","Transaction completed...");
				rd.forward(request, response);
	    		con.commit();
	    		
	    		
	    		con.close();
	        }catch(Exception e)
	    	
	    	{
	    		System.out.println(e);
	    	}
	    
		
		}
		
	}

}

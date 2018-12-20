

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmpBean;
import dao.MyDao;

/**
 * Servlet implementation class CustInsert
 */
@WebServlet("/CustInsert")
public class CustInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustInsert() {
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
		
		String cname=request.getParameter("name");
		String caddress=request.getParameter("address");
		String mobileno=request.getParameter("mobile");
		String emailid=request.getParameter("email");
		String aaccno=request.getParameter("account");
		int accno=Integer.parseInt(aaccno);
		String password=request.getParameter("cpassword");
	     String bbalance=request.getParameter("bal");
		double balance=Double.parseDouble(bbalance);
			
		EmpBean e=new EmpBean();
		
		e.setCname(cname);
		e.setAddress(caddress);
		e.setMobile(mobileno);
		e.setEmail(emailid);
		e.setAccno(accno);
		e.setPassword(password);
		e.setBalance(balance);
		
	    MyDao m=new MyDao();
		//int x= m.insertCustomer(cname,caddress,mobileno,emailid,accno,password,balance);
		int x=m.insertCustomer(e);
		
		if(x!=0)
	    {
	    javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("Customer.jsp");
	    request.setAttribute("msg","<h1>Data Inserted Successfully...</h1>");
	    rd.forward(request, response);
	    }
	    else
	    	out.println("<h1>Data Not Inserted</h1>");

		
		
		
		out.println("<center><a href=AHome><h4>Click here for go to Home Page</h2></a></center>");
			out.println("<center><a href=index.html><h4>Click here for Log Out</h2></a></center>");

	}

	}



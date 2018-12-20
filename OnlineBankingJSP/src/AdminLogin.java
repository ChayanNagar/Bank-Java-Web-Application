

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.MyDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		String u=request.getParameter("aid");
		String p=request.getParameter("apassword");
		
		MyDao m=new MyDao();
		   int x=m.loginCheck(u, p);
		   
		   if(x==1)
			{
			   //Session code here
				HttpSession session=request.getSession();
				session.setAttribute("uid",u);
				response.sendRedirect("AHome.jsp");
				
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg","Login fail try again...");
				rd.forward(request,response);
				  //response.sendRedirect("index.jsp");
			}
		
	
		
	}

}

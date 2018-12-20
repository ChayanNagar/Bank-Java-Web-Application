package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import beans.EmpBean;

public class MyDao {
	public Connection start()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productinf","root","root");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	
	
	public int loginCheck(String uid,String pwd)
	{
		int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				x=1;
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
		
		return x;
	}
	public int insertCustomer(EmpBean e)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into customer (cname,address,mobile,emailid,accountno,password,balance)values(?,?,?,?,?,?,?)");
		    
		    ps1.setString(1,e.getCname());
		    ps1.setString(2, e.getAddress());
		    ps1.setString(3,e.getMobile());
		    ps1.setString(4,e.getEmail());
		    ps1.setInt(5,e.getAccno());
		    ps1.setString(6,e.getPassword());
		    ps1.setDouble(7,e.getBalance());
		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
		
	return x;
		
	}
	public ArrayList<EmpBean>   viewCust()
	{
		ArrayList<EmpBean> list=new ArrayList<>();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from customer");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				EmpBean e=new EmpBean();
				e.setCid(rs.getInt("cid"));
				e.setCname(rs.getString("cname"));
				e.setAddress(rs.getString("address"));
				e.setMobile(rs.getString("mobile"));
				e.setEmail(rs.getString("emailid"));
				e.setAccno(rs.getInt("accountno"));
				e.setPassword(rs.getString("password"));
				e.setBalance(rs.getDouble("balance"));

				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}

	}


package com.autocomplete.sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.DataSource.mysql.DataSource;

/**
 * Servlet implementation class AutoComplete
 */

public class AutoCompleteTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AutoCompleteTwo() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> al=new ArrayList<String>();
		try{
		DataSource ds=DataSource.getInstace();
	     Connection conn=ds.getConnection();
	     Statement stmt=conn.createStatement();
	     String sql="select prod.upc from m_product as prod WHERE prod.upc is not null";

	     ResultSet rs = stmt.executeQuery(sql);
	     System.out.println(sql);
	     while(rs.next()){
	    	 al.add(rs.getString(1));
	     }
	     rs.close();
	     stmt.close();
	     conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		 JSONArray json=new JSONArray(al);
		 response.setContentType("application/json");
	        response.getWriter().print(json);
	}   
}

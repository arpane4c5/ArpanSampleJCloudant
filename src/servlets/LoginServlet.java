package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudant.client.api.Database;

import example.nosql.CloudantClientMgr;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int readBufferSize = 8192;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//doGet(request, response);
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user");
		String key = request.getParameter("password");
	
		System.out.print("Hello "+id);

		//Database db = CloudantClientMgr.getDB();
		
		response.setHeader("Content-Disposition", "inline; filename=\"" + key + "\"");


		try {
			
			InputStream dbResponse = CloudantClientMgr.getDB().find(id + "/" + key);
			OutputStream output = response.getOutputStream();
			int readBytes = 0;
			byte[] buffer = new byte[readBufferSize];
			while ((readBytes = dbResponse.read(buffer)) >= 0) {
				output.write(buffer, 0, readBytes);
			}
			dbResponse.close();
		} 
		catch(Exception e){
			System.out.println("Exception = "+e.getMessage());
		}finally {
			
		}
		
	}

}

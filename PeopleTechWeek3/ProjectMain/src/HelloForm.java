

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
    	try {
			con = DatabaseConnection.getConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Reading All Form Parameters";
        String docType =
           "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
           "<html>\n" +
           "<head><title>" + title + "</title></head>\n" +
           "<body bgcolor = \"#f0f0f0\">\n" +
           "<h1 align = \"center\">" + title + "</h1>\n" +
           "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
           "<tr bgcolor = \"#949494\">\n" +
              "<th>Param Name</th>" +
              "<th>Param Value(s)</th>\n"+
           "</tr>\n"
        );

        Enumeration paramNames = request.getParameterNames();

        while(paramNames.hasMoreElements()) {
           String paramName = (String)paramNames.nextElement();
           out.print("<tr><td>" + paramName + "</td>\n<td>");
           String[] paramValues = request.getParameterValues(paramName);

           // Read single valued data
           if (paramValues.length == 1) {
              String paramValue = paramValues[0];
              if (paramValue.length() == 0)
                 out.println("<i>No Value</i>");
                 else
                 out.println(paramValue);
           } else {
              // Read multiple valued data
              out.println("<ul>");

              for(int i = 0; i < paramValues.length; i++) {
                 out.println("<li>" + paramValues[i]);
              }
              out.println("</ul>");
           }
        }
        out.println("</tr>\n</table>\n</body></html>");
        
        System.out.println("Drivering");
        
	
		
		try {
			rs = stmt.executeQuery("Select * From Book WHERE Code = 27 ORDER BY Code Desc ");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5) + " | " + rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

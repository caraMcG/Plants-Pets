package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import controller.plantDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cara McGinley
 * 
 */
@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String searchWord = request.getParameter("searchWord"); 
			String searchFilter = request.getParameter("selectedFilter");
			System.out.println(searchWord + " " + searchFilter);

			if(request.getParameter("submit") != null) {
			
				if(searchFilter == null || searchFilter.isEmpty()) {
					System.out.println("I'm in error");
	//				try {
	//					String allPlantInfo = plantDB.getAllPlantInfo(searchWord);
	//					request.setAttribute("tableResult", allPlantInfo);
	//				} catch (ClassNotFoundException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				} catch (SQLException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
					request.setAttribute("error", "Please select what you are searching for from the dropdown");
				}
				else {
					
					switch(searchFilter) {
					case "name":
						try {
							String allPlantInfo = plantDB.getPlantByName(searchWord);
							request.setAttribute("tableResult", allPlantInfo);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						break;
					case "symptom":
						try {
							String allPlantInfo = plantDB.getPlantBySymptom(searchWord);
							request.setAttribute("tableResult", allPlantInfo);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
			else if(request.getParameter("reset") != null){
		    	request.setAttribute("tableResult", "");
		    	request.setAttribute("error", "");
			}
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

}

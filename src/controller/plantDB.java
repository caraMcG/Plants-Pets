package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import dbConnect.DBConn;
import entity.Plant;

/**
 * @author Cara McGinley
 *
 */
public class plantDB {
	

	/**
	 * Returns table with search results based on nameSearch parameter
	 * 
	 * @param nameSearch
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String getPlantByName(String nameSearch) throws ClassNotFoundException, SQLException {
		
		Connection conn = DBConn.getConnection();
		int maxResult = 0;

		if (!nameSearch.equals("")) {

			String sql = "SELECT * FROM dbo.plantInfo_Updated_2021_08_06" + " WHERE plantName LIKE ?";

			System.out.println(sql);

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + nameSearch + "%");

			ResultSet rs = ps.executeQuery();

			String table = "<table class='table table-hover'>"
					+ "<thead fixedHeader><tr><th scope='col'>Name</th><th scope='col'>Family</th>"
					+ "<th scope='col'>Dogs?</th><th scope='col'>Cats?</th>"
					+ "<th scope='col'>Type</th><th scope='col'>Toxic?</th><th scope='col'>Symptoms</th></tr>"
					+ "</thead>" + "<tbody>";

			//TODO 
			//paginate the table  max 10 per page
			
			//TODO
			//filter table by headers
			
			while (rs.next() && maxResult < 10) {

				StringBuffer lowerPlantName = new StringBuffer(rs.getString("plantName").toLowerCase());
				StringBuffer originalPlantName = new StringBuffer(rs.getString("plantName"));
					
				maxResult++;
				table += "<tr>";
				table += "<td>" + formattedWord(lowerPlantName,originalPlantName, nameSearch) + "</td>" + "<td>" + rs.getString("familyName") + "</td>"
						+ "<td>" + rs.getString("dogs") + "</td>" + "<td>" + rs.getString("cats") + "</td>" + "<td>"
						+ rs.getString("plantType") + "</td>" + "<td>" + rs.getString("toxicityLevel") + "</td>"
						+ "<td>" + rs.getString("symptoms") + "</td>";
				table += "</tr>";

			}

			table += "</tbody></table>";

			rs.close();
			conn.close();

			System.out.println("DB Connection Closed.");

			return table;

		} else {

			conn.close();
			System.out.println("Returning no entry");
			return null;
		}

	}

	/**
	 * Returns table with search results based on symptSearch parameter
	 * 
	 * @param symptSearch
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String getPlantBySymptom(String symptSearch) throws ClassNotFoundException, SQLException {

		Connection conn = DBConn.getConnection();
		int maxResult = 0;

		if (!symptSearch.equals("")) {

			String sql = "SELECT * FROM dbo.plantInfo_Updated_2021_08_06" + " WHERE symptoms LIKE ?"; 

			System.out.println(sql);

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + symptSearch + "%");

			ResultSet rs = ps.executeQuery();

			String table = "<table class='table table-striped table-hover'>"
					+ "<thead><tr><th scope='col'>Name</th><th scope='col'>Family</th>"
					+ "<th scope='col'>Dogs?</th><th scope='col'>Cats?</th>"
					+ "<th scope='col'>Type</th><th scope='col'>Toxic?</th><th scope='col'>Symptoms</th></tr>"
					+ "</thead>" + "<tbody>";

			while (rs.next() && maxResult < 10) {

				StringBuffer lowerSymptName = new StringBuffer(rs.getString("symptoms").toLowerCase());
				StringBuffer originalSymptName = new StringBuffer(rs.getString("symptoms"));
					
				maxResult++;
				table += "<tr>";
				table += "<td>" + rs.getString("plantName") + "</td>" + "<td>" + rs.getString("familyName") + "</td>"
						+ "<td>" + rs.getString("dogs") + "</td>" + "<td>" + rs.getString("cats") + "</td>" + "<td>"
						+ rs.getString("plantType") + "</td>" + "<td>" + rs.getString("toxicityLevel") + "</td>"
						+ "<td>" + formattedWord(lowerSymptName,originalSymptName, symptSearch)  + "</td>";
				table += "</tr>";				
				
			}

			table += "</tbody></table>";

			rs.close();
			conn.close();

			System.out.println("DB Connection Closed.");

			return table;

		} else {

			conn.close();
			System.out.println("Returning no entry");
			return null;
		}

	}
	

	/**
	 * Function to check if first letter of substring is upper or lower case
	 * @param x
	 * @return true = Upper case or false = lower case
	 */
	public static boolean caseCheck(char x) {
		
		boolean a = Character.isUpperCase(x);
		
		if(a) {
			
			return true;
		}
		else {
			System.out.println(x + " is Lower Case");
			return false;
		}
		
	}

	
	/**
	 * Function to format the replaced word within the generated table 
	 * 
	 * @param lowerWord
	 * @param origWord
	 * @param searchWord
	 * @return replacedName 
	 */
	public static StringBuffer formattedWord(StringBuffer lowerWord,StringBuffer origWord, String searchWord) {
			
		int startIndex = lowerWord.indexOf(searchWord.toLowerCase());
		int endIndex = startIndex + searchWord.length();
		char startLetter = origWord.charAt(startIndex);
		
		if(caseCheck(startLetter)) {
			
			//Capitalize First letter
			String firstLet = searchWord.toLowerCase().substring(0,1).toUpperCase();
			//Get Remaining letters
			String remLet = searchWord.toLowerCase().substring(1);
			//Concatenate capitalized with rest of word
			StringBuffer replacedName = origWord.replace(startIndex, endIndex, "<span style='color:red'>" + firstLet+remLet  + "</span>");
			
			return replacedName;
			
		}
		
		else {
			//Lower First letter
			String firstLet = searchWord.toLowerCase().substring(0,1).toLowerCase();
			//Get Remaining letters
			String remLet = searchWord.toLowerCase().substring(1);
			//Concatenate capitalized with rest of word
			StringBuffer replacedName = origWord.replace(startIndex, endIndex, "<span style='color:red'>" + firstLet+remLet  + "</span>");
			
			return replacedName;
		}

	}
	
	
//
//	public static String getAllPlantInfo(String searchWord) throws ClassNotFoundException, SQLException {
//
//		Connection conn = DBConn.getConnection();
//		int maxResult = 0;
//
//		if (!searchWord.equals("")) {
//
//			String sql = "SELECT * FROM dbo.plantInfo_Updated_2021_08_06" + " WHERE plantName LIKE ?"
//					+ " OR symptoms LIKE ?";
//
//			System.out.println(sql);
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, "%" + searchWord + "%");
//			ps.setString(2, "%" + searchWord + "%");
//
//			ResultSet rs = ps.executeQuery();
//
//			String table = "<table class='table table-striped table-hover'>"
//					+ "<thead><tr><th scope='col'>Name</th><th scope='col'>Family</th>"
//					+ "<th scope='col'>Dogs?</th><th scope='col'>Cats?</th>"
//					+ "<th scope='col'>Type</th><th scope='col'>Toxic?</th><th scope='col'>Symptoms</th></tr>"
//					+ "</thead>" + "<tbody>";
//
//			while (rs.next() && maxResult < 10) {
//
//				StringBuffer lowerPlantName = new StringBuffer(rs.getString("plantName").toLowerCase());
//				StringBuffer originalPlantName = new StringBuffer(rs.getString("plantName"));
//					
//				maxResult++;
//				table += "<tr>";
//				table += "<td>" + formattedWord(lowerPlantName,originalPlantName, searchWord) + "</td>" + "<td>" + rs.getString("familyName") + "</td>"
//						+ "<td>" + rs.getString("dogs") + "</td>" + "<td>" + rs.getString("cats") + "</td>" + "<td>"
//						+ rs.getString("plantType") + "</td>" + "<td>" + rs.getString("toxicityLevel") + "</td>"
//						+ "<td>" + rs.getString("symptoms") + "</td>";
//				table += "</tr>";
//
//			}
//
//			table += "</tbody></table>";
//
//			rs.close();
//			conn.close();
//
//			System.out.println("DB Connection Closed.");
//
//			return table;
//
//		} else {
//
//			conn.close();
//			System.out.println("Returning no entry");
//			return null;
//		}
//
//	}
//	
}

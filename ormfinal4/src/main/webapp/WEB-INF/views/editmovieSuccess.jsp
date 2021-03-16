<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="movie_list_admin.css">
    <title>Movie Cruiser</title>
</head>
<body>
    <div class="maincontainer">
        <div class="navbar">
            <h3>Movie Cruiser</h3> 
            <img src="film.png">
             <div class="right">
                <a href="movielistAdmin"><h3>Movies</h3></a> 
                <a href="logout"><h3>Logout</h3></a>
            </div>
        </div>  
    <br>
    <div class="tabledata">
       <div class="edit">
           <h3>Edit Movie Status</h3>
           <%
           String id=request.getParameter("id");
           String title= request.getParameter("title");
           String boxoffice=request.getParameter("gross");
           String active = request.getParameter("Active");
           String dateoflaunch = request.getParameter("dol");
           String genre=request.getParameter("genre");
           String hasteaser=request.getParameter("Teaser");
           if (id != null) {
        		Connection con = null;
        		PreparedStatement ps = null;
        		try {
        			int i=0;
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");
        			Statement st = conn.createStatement();
        			String sql = "update movies set title=?,box_office=?,active=?,dateof_release=?,genre=?,hasteaser=? where movie_id="+ id;
        			ps = conn.prepareStatement(sql);
        			ps.setString(1, title);
        			ps.setString(2, boxoffice);
        			ps.setString(3, active);
        			ps.setString(4, dateoflaunch);
        			ps.setString(5, genre);
        			ps.setString(6, hasteaser);
        			 i = ps.executeUpdate();
        			 if (i > 0) {
        				out.println( "<h5>Movie details saved successfully..</h5>");
        			 }else {
        					out.print("<p>There is a problem in updating Record.</p>");
        				}
        			} catch (Exception e) {
        				System.out.print(e);
        				e.printStackTrace();
        			}
        		}
        		%>
        
         
       </div>
    </div><br>
       <div class="footer">
        <div class="foot">
            <p>Copyright @ 2019</p></div>
          </div>
</div>

</body>
</html>
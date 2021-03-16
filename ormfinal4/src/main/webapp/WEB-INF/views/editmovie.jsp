<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.*,java.util.*"%>

<%@ page import="java.io.*"%>
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
           <%
try{
	String id = request.getParameter("id");

	Statement statement = null;
	ResultSet resultSet = null;
Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");
		Statement st = conn.createStatement();
	String sql ="select * from movies where movie_id="+id;
	resultSet = st.executeQuery(sql);
	while(resultSet.next()){
%>
    <div class="tabledata">
       <div class ="favhead">
           <h3>Edit Movie</h3>
       </div>

       

           <form name="myForm" action="/editmovie" onsubmit="return myFunction()" method="post" class="editmenu">
            <table>
            <tr>
        	 	<td>
               <input type="hidden" id="id" name="id" value="<%=resultSet.getString("movie_id") %>"></td></tr>
                <tr>
                    <td>Title</td>
                </tr>
                <tr> 
            
            
              
                    <td class="title">
                   
                        <input id ="title" type="text" value="<%=resultSet.getString("title") %>" name="title">
                    </td>
                </tr>
                <tr>
                    <td>Gross ($)</td>
                    <td>Active</td>
                    <td>Date of Launch</td>
                    <td>Genre</td>
                </tr>
                <tr>
                    <td>
                        <input type ="text" name="gross" value="<%=resultSet.getString("box_office") %>" width="50%">
                    </td>
                    <td>
                        <input type="radio" id="Yes" name="Active" value="Yes">
                        <label for="Yes">Yes</label> 
                        <input type="radio" id="No" name="Active" value="No">
                        <label for="No">No</label>
                    </td>
                    <td>
                        <input type="date" name="dol" value="<%=resultSet.getString("dateof_release") %>">
                    </td>
                    <td>
                        <select name="genre" id="genre">
                            <option value="null" selected disabled hidden> Select</option>
                            <option value="Science Fiction">Science Fiction</option>
                            <option value="Super Hero">Super Hero</option>
                            <option value="Romance">Romance</option>
                            <option value="Comedy">Comedy</option>
                            <option value="Adventure">Adventure</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="hasteaser"> Has Teaser</label>
                       Yes <input type="checkbox" id="hasteaser" name="Teaser" value="Yes">
                       No  <input type="checkbox" id="hasteaser" name="Teaser" value="No">
                    </td>
                </tr>
                <tr>
                    <td class="save">
                        <button style="text-decoration: wavy; background-color: rgb(2, 2, 87); color: rgb(253, 253, 253);" type="submit" >Save</button>
                    </td>
                </tr>
            </table>
            </form>
       
       </div>   
<%
}
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
  

    <div class="footer">
        <div class="foot">
            <p>Copyright @ 2019</p></div>
          </div>
</div>


</body>
</html>
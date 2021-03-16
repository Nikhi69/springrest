<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.nikhil.truyum.*"%>
<%@ page import="java.sql.*"%>
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
                <a href="movielistCustomer"><h3>Movies</h3></a> 
                <a href="favorite"><h3>Favorites</h3></a> 
            </div>
        </div>  
    <br>
    <div class="tabledata">
       <div class ="favhead">
           <h3>Favorites</h3>
       </div>
       <table id="movies">
        <tr> 
            <th>Title</th>
           <th>Box Office</th>
           <th>Genre</th>
        </tr>
        <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.title}</td>
            <td>${item.boxoffice }</td>
            <td>${item.genre }</td>
            <td><a href="/removeItem?movie_id=${item.id }">Delete</a></td>
        </tr>
   
        </c:forEach>
        
       </table></div><br>
       <div class="countfav">
            <p>No.of Favorites: ${total }</p>
        </div><br>
       <div class="footer">
        <div class="foot">
            <p>Copyright @ 2019</p></div>
          </div>
</div>

</body>
</html>
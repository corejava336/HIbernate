<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>search Page</title>
</head>
<body>
	<h1>Welcome, <%= request.getAttribute("name") %>! </h1>
    <h2>To Search Page</h2>   
     <form>
        <a href="welcome.jsp">Home</a>
    </form>
        
    <form action="search" method="post">
        <label for="name">Item Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <input type="submit" value="search">
    </form>
       <!-- Display record information if found -->
    <% 
        Boolean recordFound = (Boolean)request.getAttribute("recordFound");
        if (recordFound != null && recordFound.equals(true)) { 
    %>
        <p>Record found:</p>
        <p><%= request.getAttribute("recordInfo") %></p>
    <% } %>

    <!-- Display message if no record found -->
    <% 
        if (recordFound != null && recordFound.equals(false)) { 
    %>
        <p>No record found.</p>
    <% } %>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nt.entity.items" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Page</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("name") %>! </h1>
    <h2>To Update Page</h2>
    <form>
        <a href="welcome.jsp">Home</a>
    </form>
    
    <form action="update" method="post">
        <label for="name">Item Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="count">Count:</label>
        <input type="text" id="count" name="count" required>
        <br>
        <input type="submit" value="Update">
    </form>

    <!-- Display record information if found -->
    <%
        Boolean recordFound = (Boolean) request.getAttribute("recordFound");
        if (recordFound != null && recordFound.equals(true)) {
            items recordInfo = (items) request.getAttribute("recordInfo");
    %>
        <p>Record updated:</p>
        <p>Name: <%= recordInfo.getName() %></p>
        <p>Count: <%= recordInfo.getCount() %></p>
    <% } %>

    <!-- Display message if no record found -->
    <%
        if (recordFound != null && recordFound.equals(false)) {
    %>
        <p>No record found.</p>
    <% } %>
</body>

</html>

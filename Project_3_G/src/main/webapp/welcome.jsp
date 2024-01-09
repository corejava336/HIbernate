<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Welcome Page</title>
    <style>
        /* Add some basic styling for better presentation */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .options {
            display: flex;
            gap: 20px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h2>Welcome, ${name}!</h2>
        <div>
            <p id="currentDateTime"></p>
        </div>
    </div>

    <div class="options">
        <a href="add.jsp">Add</a>
        <a href="update.jsp">Update</a>
        <a href="delete.jsp">Delete</a>
        <a href="search.jsp">Search</a>
    </div>

    <form>
        <label for="hi">Hi:</label>
        <input type="text" id="hi" name="hi">
        <br>
        <label for="bye">Bye:</label>
        <input type="text" id="bye" name="bye"><br>
    </form>

    <script>
        function updateDateTime() {
            var currentDate = new Date();
            var formattedDateTime = new Intl.DateTimeFormat('en-US', {
                year: 'numeric',
                month: '2-digit',
                day: '2-digit',
                hour: '2-digit',
                minute: '2-digit',
                second: '2-digit'
            }).format(currentDate);
            document.getElementById("currentDateTime").innerText = formattedDateTime;
        }

        // Update the time every second
        setInterval(updateDateTime, 1000);

        // Initial update
        updateDateTime();
    </script>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            background: url("https://i.pinimg.com/originals/90/7d/7b/907d7b222f4b2b803c2fa63bf307275f.png") no-repeat center top;
            background-size: cover;
            background-attachment: fixed;
        }

        h1 {
            color: #4a90e2;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #4a90e2;
            padding: 10px 15px;
            border-radius: 5px;
            margin: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #357ab8;
        }

        .links {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h1>Author Book Application</h1>
<div class="links">
    <a href="/books">View All Books</a>
    <a href="/authors">View All Authors</a>
</div>
</body>
</html>
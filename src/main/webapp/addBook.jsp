<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
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
            height: 100vh;
            background: url("https://i.pinimg.com/originals/90/7d/7b/907d7b222f4b2b803c2fa63bf307275f.png") no-repeat center top;
            background-size: cover;
            background-attachment: fixed;
        }

        h1 {
            color: #4a90e2;
        }

        a {
            text-decoration: none;
            color: #4a90e2;
            margin-right: 10px;
        }

        a:hover {
            text-decoration: underline;
        }

        form {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
        }

        form input, form select {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form input[type="submit"] {
            background-color: #4a90e2;
            color: white;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }

        form input[type="submit"]:hover {
            background-color: #357ab7;
        }

        .links {
            color: #9ca7ff;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div>
    <h1>Add Book</h1>
    <div class="links">
        <a href="/books">Books</a> |
        <a href="index.jsp">Main</a>
    </div>
    <form action="/addBook" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="500.5" min="0" required>

        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" min="0" required>

        <label for="authorId">Author ID:</label>
        <input type="number" id="authorId" name="authorId" min="1" required>

        <label for="createdAt">Created:</label>
        <input type="date" id="createdAt" name="createdAt" required>

        <input type="submit" value="ADD">
    </form>
</div>
</body>
</html>
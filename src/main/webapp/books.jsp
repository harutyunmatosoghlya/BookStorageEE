<%@ page import="am.itspace.authorbookee.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="am.itspace.authorbookee.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
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
        }

        a {
            text-decoration: none;
            color: #4a90e2;
            font-weight: bold;
            margin-bottom: 10px;
        }

        a:hover {
            text-decoration: underline;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border-radius: 8px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4a90e2;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        td {
            font-size: 14px;
        }
    </style>
</head>
<body>
<h1>Books:</h1>
<a href="/addBook">Add Book</a>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Author Name</th>
        <th>Created at</th>
    </tr>

    <% for (Book book : books) { %>
    <tr>
        <td><%= book.getId() %>
        </td>
        <td><%= book.getTitle() %>
        </td>
        <td><%= book.getPrice() %>
        </td>
        <td><%= book.getQty() %>
        </td>
        <td><%= book.getAuthor().getName() %>
        </td>
        <td><%= DateUtil.fromDateToString(book.getCreatedAt()) %>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
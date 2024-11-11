<%@ page import="am.itspace.authorbookee.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="am.itspace.authorbookee.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
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
<h1>Authors:</h1>
<a href="/addAuthor">Add Author</a>

<%
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone</th>
        <th>Date of Birth</th>
        <th>Gender</th>
    </tr>

    <% for (Author author : authors) { %>
    <tr>
        <td><%= author.getId() %></td>
        <td><%= author.getName() %></td>
        <td><%= author.getSurname() %></td>
        <td><%= author.getPhone() %></td>
        <td><%= DateUtil.fromDateToString(author.getDateOfBirthday()) %></td>
        <td><%= author.getGender().name() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
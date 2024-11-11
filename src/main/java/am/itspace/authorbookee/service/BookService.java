package am.itspace.authorbookee.service;


import am.itspace.authorbookee.db.DBConnectionProvider;
import am.itspace.authorbookee.model.Author;
import am.itspace.authorbookee.model.Book;
import am.itspace.authorbookee.util.DateUtil;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private AuthorService authorService = new AuthorService();

    public void add(Book book) {
        String sql = "INSERT INTO book(title, price, qty, author_id, created_at) VALUES (?,?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setDouble(2, book.getPrice());
            preparedStatement.setInt(3, book.getQty());
            preparedStatement.setInt(4, book.getAuthor().getId());
            preparedStatement.setDate(5, new java.sql.Date(book.getCreatedAt().getTime()));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                book.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        List<Book> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Book> searchByBookName(String keyword) {
        String sql = "SELECT * from book WHERE title LIKE '%" + keyword + "%'";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * from book WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                return book;
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBook(int bookId) {
        String sql = "DELETE FROM book WHERE id = " + bookId;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> searchByPrice(double min, double max) {
        String sql = "SELECT * from book WHERE price BETWEEN " + min + " AND " + max;
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Book> searchByAuthor(Author author) {
        String sql = "SELECT * from book WHERE author_id = " + author.getId();
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
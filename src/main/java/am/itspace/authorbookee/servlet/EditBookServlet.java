package am.itspace.authorbookee.servlet;

import am.itspace.authorbookee.model.Author;
import am.itspace.authorbookee.model.Book;
import am.itspace.authorbookee.service.AuthorService;
import am.itspace.authorbookee.service.BookService;
import am.itspace.authorbookee.util.DateUtil;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
    private final BookService bookService = new BookService();
    private final AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("book", bookService.getBookById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("editBook.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price").replace(',', '.'));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Author author = authorService.getAuthorById(Integer.parseInt(req.getParameter("authorId")));
        Date createdAt = DateUtil.fromWebStringToDate(req.getParameter("createdAt"));
        bookService.update(Book.builder()
                .id(id)
                .title(title)
                .price(price)
                .qty(quantity)
                .author(author)
                .createdAt(createdAt)
                .build());
        resp.sendRedirect("/books");
    }
}
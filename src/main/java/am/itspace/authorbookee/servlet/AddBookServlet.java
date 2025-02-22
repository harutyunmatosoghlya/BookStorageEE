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

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    private final BookService bookService = new BookService();
    private final AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", authorService.getAllAuthors());
        req.getRequestDispatcher("/addBook.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bookService.add(Book.builder()
                .title(req.getParameter("title"))
                .price(Double.parseDouble(req.getParameter("price").replace(',', '.')))
                .qty(Integer.parseInt(req.getParameter("quantity")))
                .author(authorService.getAuthorById(Integer.parseInt(req.getParameter("authorId"))))
                .createdAt(new Date())
                .build());
        resp.sendRedirect("/books");
    }
}
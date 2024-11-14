package am.itspace.authorbookee.servlet;

import am.itspace.authorbookee.model.Author;
import am.itspace.authorbookee.model.Gender;
import am.itspace.authorbookee.service.AuthorService;
import am.itspace.authorbookee.util.DateUtil;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/editAuthor")
public class EditAuthorServlet extends HttpServlet {
    private final AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("author", authorService.getAuthorById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("editAuthor.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        Date dob = DateUtil.fromWebStringToDate(req.getParameter("dob"));
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        authorService.update(Author.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .phone(phone)
                .dateOfBirthday(dob)
                .gender(gender)
                .build());
        resp.sendRedirect("/authors");
    }
}
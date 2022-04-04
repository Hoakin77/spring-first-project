package ru.geekbrains.hw.productservlet;


import ru.geekbrains.hw.Product;
import ru.geekbrains.hw.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private static final Pattern PARAM_PATTERN = Pattern.compile("\\/(\\d+)");

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.getWriter().println("<h1>Привет от сервлета!!!</h1>");
//        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
//        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
//        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
//        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
//        resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
//        resp.getWriter().println("<p>param2: " + req.getParameter("param2") + "</p>");

        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {

            PrintWriter wr = resp.getWriter();
            wr.println("<table>");
            wr.println("<tr>");
            wr.println("<th>Id</th>");
            wr.println("<th>ProductName</th>");
            wr.println("</tr>");

            for (Product product : productRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<td><a href='" + getServletContext().getContextPath() + "/product/" + product.getId() + "'>" + product.getId() + "</a></td>");
                wr.println("<td>" + product.getName() + "</td>");
                wr.println("</tr>");
            }

            wr.println("</table>");
        } else {
            Matcher matcher = PARAM_PATTERN.matcher(req.getPathInfo());
            if(matcher.matches()){
               long id = Long.parseLong(matcher.group(1));
               Product product = this.productRepository.findById(id);
               if(product == null) {
                   resp.getWriter().println("<p>Product is not found</p>");
                   resp.setStatus(404);
                   return;
               }
               resp.getWriter().println("<p>id " + product.getId() + "</p>");
               resp.getWriter().println("<p>productName " + product.getName() + "</p>");
            } else {
                resp.getWriter().println("<p>Wrong parameters</p>");
                resp.setStatus(400);
            }
        }
    }
}


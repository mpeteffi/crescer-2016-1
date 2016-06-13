package br.com.crescer.aula5web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author murillo.peteffi
 */

@WebServlet(name="pessoa", urlPatterns = ("/pessoa"))
public class PessoaServlet extends HttpServlet {
    
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        try (final PrintWriter out = resp.getWriter();) {
//            out.append("<!DOCTYPE html>");
//            out.append("<html>");
//            out.append("<head>");
//            out.append("<title>Java - aula5</title>");
//            out.append("<meta charset=\"UTF-8\">");
//            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//            out.append("</head>");
//            out.append("<body>");
//            out.append("<h1>Pessoa</h1>");
//            out.append("</body>");
//            out.append("</html>");
//        }
//    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    
    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        try (final PrintWriter out = resp.getWriter();) {
            out.append(req.getParameter("pessoa.nome"));
        }
    }
}

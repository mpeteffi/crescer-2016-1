package br.com.crescer.aula5web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<String> lista = new ArrayList<String>();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    
    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        
        try (final PrintWriter out = resp.getWriter();) {
            out.append("Nome: " + req.getParameter("nome") 
                    + " - Idade: " + req.getParameter("idade")
                    + " - Sexo: " + req.getParameter("sexo")).append("\n");
        }
    }
}

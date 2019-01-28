/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 *
 * @author Sete
 */
@WebServlet(urlPatterns = {"/edicao"})
public class Edicao extends HttpServlet {
    ArrayList<Contato> array = new ArrayList();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                
        HttpSession sessao = request.getSession();
        
        array = (ArrayList) sessao.getAttribute("contatos");
        
        String[] contato = new String[8];
        contato[0] = request.getParameter("nome");
        contato[1] = request.getParameter("tel");
        contato[2] = request.getParameter("email");
        contato[3] = request.getParameter("rua");
        contato[4] = request.getParameter("numero");
        contato[5] = request.getParameter("bairro");
        contato[6] = request.getParameter("cidade");
        contato[7] = request.getParameter("estado");
        
        
        String excl_name = (String) sessao.getAttribute("nome");
        
        int i = 0;
        
        while(!array.get(i).getNome().equals(excl_name)){
            i++;
        }
        
        array.remove(i);
        
        Contato c = new Contato(contato[0], contato[1], contato[2], contato[3], contato[4], contato[5], contato[6], contato[7]);
        
        array.add(c);
        
        sessao.setAttribute("contatos", array);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Agenda</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Contato editado com sucesso!</h3>");
        out.println("</body>");
        out.println("</html>");
        
        //Acima de todo principado, e poder, e potestade, e domínio, e de nome
        //que se nomeia, não só neste século, mas também no vindouro;
        //E sujeitou todas as coisas a seus pés, e sobre todas as coisas o
        //o constituiu como cabeça da igreja, que é o seu corpo, a plenitude
        //daquele que cumpre tudo em todos (Efésios 1:21-23)
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

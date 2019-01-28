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
@WebServlet(urlPatterns = {"/agenda"})
public class Agenda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    ArrayList<Contato> contatos = new ArrayList();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sessao = request.getSession();
        contatos = (ArrayList) sessao.getAttribute("contatos");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agenda</title>");
            out.println("<h3>Contatos</h3><br><br>");
            int i = 0;
            while(contatos.get(i) != null){
                out.println("<h3>Informações Pessoais</h3><br>");
                out.println("<p>"+contatos.get(i).getNome()+"</p><br>");
                out.println("<p>"+contatos.get(i).getTel()+"</p><br>");
                out.println("<p>"+contatos.get(i).getEmail()+"</p><br>");
                out.println("<h3>Endereço</h3><br>");
                out.println("<p>Rua "+contatos.get(i).getRua()+"</p><br>");
                out.println("<p>Número: "+contatos.get(i).getNumero()+"</p><br>");
                out.println("<p>Bairro "+contatos.get(i).getBairro()+"</p><br>");
                out.println("<p>Cidade: "+contatos.get(i).getCidade()+"</p><br>");
                out.println("<p>Estado: "+contatos.get(i).getEstado()+"</p><br>");
                out.println("<br>");
                i++;
            }
            out.println("</head>");
            out.println("<body>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /*
    * O qual nos tirou da potestade das trevas, e nos transportou para o
    * Reino do Filho do seu amor; em que temos a redenção pelo seu sangue,
    * a saber, a remissão dos pecados; o qual é imagem do Deus invisível,
    * o primogênito de toda a criação; (Colossenses 1:13-15)
    */
    

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

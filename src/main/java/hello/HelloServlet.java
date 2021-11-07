/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        String msg = "";
        
        String lang = request.getParameter("lang");
        if (lang == null)
            lang = "pt";
        switch (lang) {
            case "pt":
                msg = "Alô";
                break;
            case "en":
                msg = "Hello";
                break;
            case "de":
                msg = "Hallo";
                break;
            case "fr":
                msg = "Bonjour";
                break;
            case "it":
                msg = "Ciao, ";
                break;
            case "zh":
                msg = "你好, ";
                break;
            default: 
                msg = "";
        }
        
        String nome = request.getParameter("nome");

        if (nome == null)
            nome = "Fulano";
        
        msg = msg + nome + "!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String msg = "";        
        String lang = request.getParameter("lang");
        String pronoun = request.getParameter("pronoun");
        Salutes salute = checkSaluteByTime();
        String saluteMsg = getTranslatedSalute(lang, salute);

        if (lang==null)
            lang = "pt";
        switch (lang) {
            case "pt":
                msg = "Olá, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
            case "de":
                msg = "Hallo, ";
                break;
            case "it":
                msg = "Ciao, ";
                break;
            case "zh":
                msg = "你好, ";
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg + pronoun + nome + ". " + saluteMsg + "!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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

    private Salutes checkSaluteByTime() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 6 && timeOfDay < 12) 
        {
            return Salutes.Morning;
        } 
        else if (timeOfDay >= 12 && timeOfDay < 18) 
        {
            return Salutes.Afternoon;
        } 
        else 
        {
            return Salutes.Night;
        }
    }
    
    private enum Salutes {
        Morning, Afternoon, Night;
    }

    private String getTranslatedSalute (String lang, Salutes salute)
    {
        String msg = "";
        if (salute.equals(Salutes.Morning)) 
        {
            switch (lang) {
                case "pt":
                    msg = "Bom dia";
                    break;
                case "en":
                    msg = "Good morning";
                    break;
                case "fr":
                    msg = "Bonjour";
                    break;
                case "de":
                    msg = "Guten morgen";
                    break;
                case "it":
                    msg = "Buon giorno";
                    break;
                case "zh":
                    msg = "早上好";
                    break;
            }
        }
        else if (salute.equals(Salutes.Afternoon))
        {
            switch (lang) {
                case "pt":
                    msg = "Boa tarde";
                    break;
                case "en":
                    msg = "Good afternoon";
                    break;
                case "fr":
                    msg = "Bon après-midi";
                    break;
                case "de":
                    msg = "Guten tag";
                    break;
                case "it":
                    msg = "Buon pomeriggio";
                    break;
                case "zh":
                    msg = "下午好";
                    break;
            }
        }
        else {
            switch (lang) {
                case "pt":
                    msg = "Boa noite";
                    break;
                case "en":
                    msg = "Good evening";
                    break;
                case "fr":
                    msg = "Bonne nuit";
                    break;
                case "de":
                    msg = "Gute nacht";
                    break;
                case "it":
                    msg = "Buona notte";
                    break;
                case "zh":
                    msg = "晚安";
                    break;
            }
        }
        return msg;
    }
}

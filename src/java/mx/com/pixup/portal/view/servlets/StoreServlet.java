/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.view.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.pixup.model.entidades.Menu;
import mx.com.pixup.portal.logica.interfaces.IDiscoItemService;
import mx.com.pixup.portal.logica.interfaces.IDiscoService;
import mx.com.pixup.portal.logica.interfaces.IMenuService;
import mx.com.pixup.portal.logica.services.DiscoItemService;
import mx.com.pixup.portal.logica.services.DiscoService;
import mx.com.pixup.portal.logica.services.MenuService;
import mx.com.pixup.portal.model.Disco;
import mx.com.pixup.portal.view.beans.Carrito;

/**
 *
 * @author JAVA-08
 */
public class StoreServlet extends HttpServlet {
    
    //constantes para acciones
    private static final String ACCION = "action";
    private static final String ACCION_LISTADO_DISCOS = "view";
    
    //constantes para vistas
    private final String  VISTA_INICIO = "/vistas/index.jsp";
    private IDiscoService discoService;
    
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
        
        HttpSession session = request.getSession();
        String accion = request.getParameter(ACCION);
        Carrito carrito = null;
        
        if(accion != null && ! accion.isEmpty()){
            //despacha cada accion que llegue al store
            if(accion.equals("products")){
                //IDiscoItemService service = DiscoItemService.getInstance();
                //request.setAttribute("listaDiscos", service.getDiscos());
                discoService = DiscoService.getInstance();
                request.setAttribute("listaDiscos", discoService.cargaDiscos());
                //System.out.println("Size : " + service.cargaDiscos().size());
            }
            else if(accion.equals("addCart")){
                String idDiscoParam = request.getParameter("idDisco");
                Integer idDisco = -1;
                try{
                    discoService = DiscoService.getInstance();
                    carrito = (Carrito) session.getAttribute("carrito");
                    if(carrito == null){
                        carrito = new Carrito();
                    }
                    idDisco = Integer.parseInt(idDiscoParam);
                    Disco disco = discoService.buscaDisco(idDisco);
                    carrito.agregaDisco(disco);
                    session.setAttribute("carrito", carrito);
                    request.getRequestDispatcher("/store?action=products").forward(request, response);
                    return;
                }catch(NumberFormatException nex){
                    nex.getMessage();
                }
            }
        }
        request.getRequestDispatcher(VISTA_INICIO).forward(request, response);
        return;
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

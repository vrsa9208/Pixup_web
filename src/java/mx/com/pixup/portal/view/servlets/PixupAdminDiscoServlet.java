/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.view.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.pixup.portal.logica.interfaces.IDiscoService;
import mx.com.pixup.portal.logica.services.DiscoService;
import mx.com.pixup.portal.model.Artista;
import mx.com.pixup.portal.model.Cancion;
import mx.com.pixup.portal.model.Disco;
import mx.com.pixup.portal.view.traductores.TraductorDisco;

/**
 *
 * @author JAVA-08
 */
public class PixupAdminDiscoServlet extends HttpServlet {
    private IDiscoService discoService;
    
    private static final String LISTA_DISCOS = "lista_discos";

    private static final String RUTA_INICIO = "/admin/discosadmin.jsp";
    
    private static final String ACCION = "action";
    private static final String ACCION_ADD = "add";
    private static final String ACCION_EDIT = "edit";
    private static final String ACCION_GET = "get";
    private static final String ACCION_DELETE = "delete";
    private static final String DISCO_ATRIBUTO = "discoAtributo";
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
        discoService = DiscoService.getInstance();
        String accion = request.getParameter(ACCION);
        
        if(accion != null && !accion.isEmpty()){
            if(accion.equals(ACCION_ADD)){
                TraductorDisco traductor = new TraductorDisco();
                Disco disco = null;
                System.out.println("validacion " + traductor.validaDatos(request));
                if(traductor.validaDatos(request) == Boolean.TRUE){
                    disco = traductor.getDisco();
                    disco.setArtistas(new ArrayList<Artista>());
                    disco.setCanciones(new ArrayList<Cancion>());
                    if( !discoService.guardaDisco(disco)){
                        request.setAttribute("error", "ERROR AL INTENTAR GUARDAR EL DISCO, " +
                                "FAVOR DE INTENTAR NUEVAMENTE");
                        request.setAttribute(DISCO_ATRIBUTO, disco);
                    }
                } else {
                    request.setAttribute("error", "REVISA LOS DATOS INGRESADOS");
                    disco = traductor.getDisco();
                    System.out.println(disco);
                    request.setAttribute(DISCO_ATRIBUTO, disco);
                }
            }
            else if (accion.equals(ACCION_DELETE)){
                String idDiscoParam = request.getParameter("idDisco");
                if(idDiscoParam != null && !idDiscoParam.isEmpty()){
                    Integer idDisco = -1;
                    try{
                        idDisco = Integer.parseInt(idDiscoParam);
                        this.discoService.eliminaDisco(idDisco);
                    } catch(NumberFormatException nex){
                        nex.getMessage();
                    }
                }
            }
            
            else if (accion.equals(ACCION_GET)){
                System.out.println("Accion GET");
                String idDiscoParam = request.getParameter("idDisco");
                if(idDiscoParam != null && !idDiscoParam.isEmpty()){
                    Integer idDisco = -1;
                    try{
                        idDisco = Integer.parseInt(idDiscoParam);
                        Disco disco = discoService.buscaDisco(idDisco);
                        if(disco != null && disco.getId() != null){
                            request.setAttribute(ACCION, ACCION_EDIT);
                            request.setAttribute(DISCO_ATRIBUTO, disco);
                        }
                        else{
                            request.setAttribute("error", "NO EXISTE EL DISCO");
                        }
                    } catch(NumberFormatException nex){
                        nex.getMessage();
                    }
                }
            }
            
            else if (accion.equals(ACCION_EDIT)){
                TraductorDisco traductor = new TraductorDisco();
                Disco disco = null;
                System.out.println("validacion " + traductor.validaDatos(request));
                if(traductor.validaDatos(request) == Boolean.TRUE){
                    disco = traductor.getDisco();
                    //disco.setArtistas(new ArrayList<Artista>());
                    //disco.setCanciones(new ArrayList<Cancion>());
                    if( !discoService.actualizaDisco(disco)){
                        request.setAttribute("error", "ERROR AL INTENTAR GUARDAR EL DISCO, " +
                                "FAVOR DE INTENTAR NUEVAMENTE");
                        request.setAttribute(DISCO_ATRIBUTO, disco);
                        request.setAttribute(ACCION, ACCION_EDIT);
                    }
                } else {
                    request.setAttribute("error", "REVISA LOS DATOS INGRESADOS");
                    disco = traductor.getDisco();
                    request.setAttribute(DISCO_ATRIBUTO, disco);
                    request.setAttribute(ACCION, ACCION_EDIT);
                }
            }
        }
        List<Disco> discos = discoService.cargaDiscos();
        request.setAttribute(LISTA_DISCOS, discos);
        request.getRequestDispatcher(RUTA_INICIO).forward(request, response);
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

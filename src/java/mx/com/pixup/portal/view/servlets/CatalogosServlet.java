/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.view.servlets;

import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import mx.com.pixup.model.entidades.Menu;
import mx.com.pixup.portal.logica.interfaces.ICatalogoService;
import mx.com.pixup.portal.logica.interfaces.IMenuService;
import mx.com.pixup.portal.logica.services.CatalogoService;
import mx.com.pixup.portal.logica.services.MenuService;
import mx.com.pixup.portal.model.Disquera;
import mx.com.pixup.portal.model.GeneroMusical;
import mx.com.pixup.portal.model.Idioma;
import mx.com.pixup.portal.model.Pais;

/**
 *
 * @author JAVA-08
 */
public class CatalogosServlet extends HttpServlet {

    private static final String CATALOGO_MENU = "catalogo_menu";
    private static final String CATALOGO_PAIS = "catalogo_pais";
    private static final String CATALOGO_DISQUERA = "catalogo_disquera";
    private static final String CATALOGO_IDIOMAS = "catalogo_idiomas";
    private static final String CATALOGO_GENERO_MUSICAL = "catalogo_genero_musical";
    
    
    private List<Menu> menuPrincipal;
    private IMenuService menuService; 
    ICatalogoService catalogoService;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Se cargaran los catalogos...");
        System.out.println("Inicializando catalogos...");
        catalogoService = CatalogoService.getInstance();
        menuService = MenuService.getInstance();
        menuPrincipal = menuService.cargaMenuPrincipal();
        
        System.out.println("Catalogo menu...");
        getServletContext().setAttribute(CATALOGO_MENU, menuPrincipal);
        
        List<Pais> catalogoPaises = (List<Pais>) catalogoService.cargaCatalogo(ICatalogoService.CATALOGO_PAIS);
        getServletContext().setAttribute(CATALOGO_PAIS, catalogoPaises);
        System.out.println("Catalogos pais...");
        
        List<Disquera> catalogoDisqueras = (List<Disquera>) catalogoService.cargaCatalogo(ICatalogoService.CATALOGO_DISQUERA);
        getServletContext().setAttribute(CATALOGO_DISQUERA, catalogoDisqueras);
        System.out.println("Catalogos disquera...");
        
        List<Idioma> catalogoIdiomas = (List<Idioma>) catalogoService.cargaCatalogo(ICatalogoService.CATALOGO_IDIOMAS);
        getServletContext().setAttribute(CATALOGO_IDIOMAS, catalogoIdiomas);
        System.out.println("Catalogos idiomas...");
        
        List<GeneroMusical> catalogoGeneroMusical = (List<GeneroMusical>) catalogoService.cargaCatalogo(ICatalogoService.CATALOGO_GENERO_MUSICAL);
        getServletContext().setAttribute(CATALOGO_GENERO_MUSICAL, catalogoGeneroMusical);
        System.out.println("Catalogos genero musical...");
        
        System.out.println("Catalogos cargados en scope application...");
    }
}

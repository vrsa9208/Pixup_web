/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.logica.services;

import java.util.List;
import mx.com.pixup.model.entidades.Menu;
import mx.com.pixup.portal.dao.impl.MenuDAODummy;
import mx.com.pixup.portal.dao.interfaces.IMenu;
import mx.com.pixup.portal.logica.interfaces.IMenuService;

/**
 *
 * @author JAVA-08
 */
public class MenuService implements IMenuService{

    private static MenuService instance;
    private IMenu menuDAO;
    
    private MenuService(){}
    
    public static MenuService getInstance(){
        if(instance == null){
            instance = new MenuService();
        }
        return instance;
    }
    
    @Override
    public List<Menu> cargaMenuPrincipal() {
        menuDAO = MenuDAODummy.getInstance();
        return menuDAO.cargaMenuPrincipal();
    }
    
}

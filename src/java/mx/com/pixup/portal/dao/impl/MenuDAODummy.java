/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import mx.com.pixup.model.entidades.Menu;
import mx.com.pixup.model.entidades.Submenu;
import mx.com.pixup.portal.dao.interfaces.IMenu;
import sun.security.jca.GetInstance;

/**
 *
 * @author JAVA-08
 */
public class MenuDAODummy implements IMenu{
    
    private static MenuDAODummy instance;
    
    private MenuDAODummy(){}
    
    public static MenuDAODummy getInstance(){
        if(instance == null){
            instance = new MenuDAODummy();
        }
        return instance;
    }

    @Override
    public List<Menu> cargaMenuPrincipal() {
        List<Menu> menus = new ArrayList<>();
        Menu home = new Menu();
        home.setId(1);
        home.setNombre("Home");
        home.setLiga("/store");
        home.setEstatus(2);
        menus.add(home);
        Menu shop = new Menu();
        shop.setId(2);
        shop.setNombre("Shop");
        shop.setLiga("#");
        shop.setEstatus(2);
        Submenu products = new Submenu();
        products.setId(1);
        products.setNombre("Products");
        products.setLiga("/store?action=products");
        List<Submenu> subMenuProducts = new ArrayList<>();
        subMenuProducts.add(products);
        shop.setSubmenu(subMenuProducts);
        menus.add(shop);
        return menus;
    }
    
}

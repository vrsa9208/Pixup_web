/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.logica.interfaces;

import java.util.List;
import mx.com.pixup.model.entidades.Menu;

/**
 *
 * @author JAVA-08
 */
public interface IMenuService {
    
    List<Menu> cargaMenuPrincipal();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.logica.interfaces;

/**
 *
 * @author JAVA-08
 */
public interface ICatalogoService {
    
   public static final Integer CATALOGO_PAIS = 1;
   public static final Integer CATALOGO_DISQUERA = 2;
   
   Object cargaCatalogo(Integer catalogo);
}

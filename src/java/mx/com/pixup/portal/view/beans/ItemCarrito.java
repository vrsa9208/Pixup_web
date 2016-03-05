/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.view.beans;

import mx.com.pixup.portal.model.Disco;

/**
 *
 * @author JAVA-08
 */
public class ItemCarrito {
    
    private int cantidad;
    private Disco disco;

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the disco
     */
    public Disco getDisco() {
        return disco;
    }

    /**
     * @param disco the disco to set
     */
    public void setDisco(Disco disco) {
        this.disco = disco;
    }
    
    
}

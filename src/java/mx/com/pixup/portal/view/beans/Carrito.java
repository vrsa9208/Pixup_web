/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.view.beans;

import java.util.ArrayList;
import java.util.List;
import mx.com.pixup.portal.model.Disco;

/**
 *
 * @author JAVA-08
 */
public class Carrito {
    
    private List<Disco> discos;

    public Carrito() {
        this.discos = new ArrayList<>();
    }
    
    /**
     * @return the discos
     */
    public List<Disco> getDiscos() {
        return discos;
    }

    /**
     * @param discos the discos to set
     */
    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }
    
    public void agregaDisco(Disco disco){
        if(disco != null) this.getDiscos().add(disco);
    }
}

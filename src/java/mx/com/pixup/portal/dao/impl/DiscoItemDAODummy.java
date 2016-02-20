/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import mx.com.pixup.model.entidades.DiscoItem;
import mx.com.pixup.portal.dao.interfaces.IDiscoItem;

/**
 *
 * @author JAVA-08
 */
public class DiscoItemDAODummy implements IDiscoItem{

    private static DiscoItemDAODummy instance;
    
    private DiscoItemDAODummy(){}
    
    public static DiscoItemDAODummy getInstance(){
        if(instance == null){
            instance = new DiscoItemDAODummy();
        }
        return instance;
    }
    
    @Override
    public List<DiscoItem> getDiscos() {
        List<DiscoItem> listaDiscos = new ArrayList();
        
        DiscoItem d1 = new DiscoItem(1, "Grandes Exitos", "Bunbury", 99.99);
        listaDiscos.add(d1);
        DiscoItem d2 = new DiscoItem(1, "Grandes Exitos", "Oasis", 113.50);
        listaDiscos.add(d2);
        DiscoItem d3 = new DiscoItem(1, "Grandes Exitos", "Adele", 78.90);
        listaDiscos.add(d3);
        DiscoItem d4 = new DiscoItem(1, "Grandes Exitos", "KISS", 150.00);
        listaDiscos.add(d4);
        DiscoItem d5 = new DiscoItem(1, "Grandes Exitos", "The Beatles", 356.50);
        listaDiscos.add(d5);
        DiscoItem d6 = new DiscoItem(1, "Grandes Exitos", "Foster the people", 99.99);
        listaDiscos.add(d6);
        
        return listaDiscos;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.logica.services;

import java.util.List;
import mx.com.pixup.model.entidades.DiscoItem;
import mx.com.pixup.portal.dao.impl.DiscoItemDAODummy;
import mx.com.pixup.portal.dao.interfaces.IDiscoItem;
import mx.com.pixup.portal.logica.interfaces.IDiscoItemService;

/**
 *
 * @author JAVA-08
 */
public class DiscoItemService implements IDiscoItemService{
    
    private static DiscoItemService instance;
    private IDiscoItem discoItemDao;
    
    private DiscoItemService(){}
    
    public static DiscoItemService getInstance(){
        if(instance == null){
            instance = new DiscoItemService();
        }
        return instance;
    }

    @Override
    public List<DiscoItem> getDiscos() {
        discoItemDao = DiscoItemDAODummy.getInstance();
        return discoItemDao.getDiscos();
    }
    
}

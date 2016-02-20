/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.logica.services;

import java.util.List;
import mx.com.pixup.portal.dao.impl.DiscoDaoJdbc;
import mx.com.pixup.portal.dao.interfaces.DiscoDao;
import mx.com.pixup.portal.logica.interfaces.IDiscoService;
import mx.com.pixup.portal.model.Disco;

/**
 *
 * @author JAVA-08
 */
public class DiscoService implements IDiscoService{
    
    private static DiscoService instance;
    private DiscoDao discoDao;
    
    private DiscoService(){
        discoDao = new DiscoDaoJdbc();
    }
    
    public static DiscoService getInstance(){
        if(instance == null){
            instance = new DiscoService();
        }
        return instance;
    }

    @Override
    public List<Disco> cargaDiscos() {
        return discoDao.findAllDiscos();
    }
    
}

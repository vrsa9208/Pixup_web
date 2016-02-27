/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.logica.services;


import mx.com.pixup.portal.dao.impl.DisqueraDaoJdbc;
import mx.com.pixup.portal.dao.impl.GeneroMusicalDaoJdbc;
import mx.com.pixup.portal.dao.impl.IdiomaDaoJdbc;
import mx.com.pixup.portal.dao.impl.PaisDaoJdbc;
import mx.com.pixup.portal.dao.interfaces.DisqueraDao;
import mx.com.pixup.portal.dao.interfaces.GeneroMusicalDao;
import mx.com.pixup.portal.dao.interfaces.IdiomaDao;
import mx.com.pixup.portal.dao.interfaces.PaisDao;
import mx.com.pixup.portal.logica.interfaces.ICatalogoService;

/**
 *
 * @author JAVA-08
 */
public class CatalogoService implements ICatalogoService{

    private static CatalogoService instance;
    private PaisDao paisDAO;
    private DisqueraDao disqueraDAO;
    private GeneroMusicalDao generoDAO;
    private IdiomaDao idiomaDAO;
    
    private CatalogoService(){
        this.paisDAO = new PaisDaoJdbc();
        this.disqueraDAO = new DisqueraDaoJdbc();
        this.generoDAO = new GeneroMusicalDaoJdbc();
        this.idiomaDAO = new IdiomaDaoJdbc();
    }
    
    public static CatalogoService getInstance(){
        if(instance == null) instance = new CatalogoService();
        return instance;
    }
    
    @Override
    public Object cargaCatalogo(Integer catalogo) {
        Object catalogoLista = null;
        
        switch(catalogo){
            case 1:
                catalogoLista = paisDAO.findAllPaises();
                break;
            case 2:
                catalogoLista = disqueraDAO.findAllDisqueras();
                break;
            case 3:
                catalogoLista = idiomaDAO.findAllIdiomas();
                break;
            case 4:
                catalogoLista = generoDAO.findAllGenerosMusicales();
                break;
        }
        
        return catalogoLista;
    }
    
}

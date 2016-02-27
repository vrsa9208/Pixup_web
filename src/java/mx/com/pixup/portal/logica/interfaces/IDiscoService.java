/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.logica.interfaces;

import java.util.List;
import mx.com.pixup.portal.model.Disco;

/**
 *
 * @author JAVA-08
 */
public interface IDiscoService {
    List<Disco> cargaDiscos();
    Boolean guardaDisco(Disco disco);
    void eliminaDisco(int id_disco);
    Disco buscaDisco(Integer id);
    Boolean actualizaDisco(Disco disco);
}

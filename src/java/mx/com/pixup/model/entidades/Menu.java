/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.model.entidades;

import java.util.List;

/**
 *
 * @author JAVA-08
 */
public class Menu {
    
    private Integer id;
    private String nombre;
    private Boolean seleccionado;
    private Integer estatus;
    private String liga;
    private List<Submenu> submenu;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the seleccionado
     */
    public Boolean getSeleccionado() {
        return seleccionado;
    }

    /**
     * @param seleccionado the seleccionado to set
     */
    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    /**
     * @return the estatus
     */
    public Integer getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the liga
     */
    public String getLiga() {
        return liga;
    }

    /**
     * @param liga the liga to set
     */
    public void setLiga(String liga) {
        this.liga = liga;
    }

    /**
     * @return the submenu
     */
    public List<Submenu> getSubmenu() {
        return submenu;
    }

    /**
     * @param submenu the submenu to set
     */
    public void setSubmenu(List<Submenu> submenu) {
        this.submenu = submenu;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.model.entidades;

/**
 *
 * @author JAVA-08
 */
public class Submenu {
    
    private Integer id;
    private String nombre;
    private String liga;
    private Boolean seleccionado;
    private Integer estatus;

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
    
}

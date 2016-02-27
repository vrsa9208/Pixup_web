/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.view.traductores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import mx.com.pixup.portal.model.Disco;
import mx.com.pixup.portal.model.Disquera;
import mx.com.pixup.portal.model.GeneroMusical;
import mx.com.pixup.portal.model.Idioma;
import mx.com.pixup.portal.model.Iva;
import mx.com.pixup.portal.model.Pais;

/**
 *
 * @author JAVA-08
 */
public class TraductorDisco {

    private SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-DD");
    private String titulo;
    private Date fechaLanzamiento;
    private Float precio;
    private Integer cantidad;
    private Integer idIdioma;
    private Integer idPais;
    private Integer idGenero;

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the fechaLanzamiento
     */
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * @param fechaLanzamiento the fechaLanzamiento to set
     */
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * @return the precio
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the idIdioma
     */
    public Integer getIdIdioma() {
        return idIdioma;
    }

    /**
     * @param idIdioma the idIdioma to set
     */
    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    /**
     * @return the idPais
     */
    public Integer getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    /**
     * @return the idGenero
     */
    public Integer getIdGenero() {
        return idGenero;
    }

    /**
     * @param idGenero the idGenero to set
     */
    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Boolean validaDatos(HttpServletRequest request) {
        Boolean validos = Boolean.TRUE;
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fechaLanzamiento");
        String precio = request.getParameter("precio");
        String cantidad = request.getParameter("cantidad");
        String idioma = request.getParameter("idioma");
        String pais = request.getParameter("pais");
        String genero = request.getParameter("genero_musical");
        String disquera = request.getParameter("disquera");

        if(titulo != null && !titulo.isEmpty()){
            this.titulo = titulo;
        }
        else{
            validos = Boolean.FALSE;
        }
        
        if(fecha != null && !fecha.isEmpty()){
            try{
                Date fechaD = this.formato.parse(fecha);
                //java.sql.Date dateSQL = new java.sql.Date(fechaD.getTime());
                this.fechaLanzamiento = this.formato.parse(fecha);
            }
            catch(ParseException pex){
                pex.getMessage();
                validos = Boolean.FALSE;
            }
        }
        else {
            validos = Boolean.FALSE;
        }
        
        if(precio != null && !precio.isEmpty()){
            try {
                this.precio = Float.parseFloat(precio);
            }
            catch(NumberFormatException nex){
                nex.getMessage();
                validos = Boolean.FALSE;
            }
        }
        else{
            validos = Boolean.FALSE;
        }
        
        if(cantidad != null && !cantidad.isEmpty()){
            try{
                this.cantidad = Integer.parseInt(cantidad);
            }
            catch(NumberFormatException nex){
                nex.getMessage();
                validos = Boolean.FALSE;
            }
        }
        else{
            validos = Boolean.FALSE;
        }
        
        if(idioma != null && !idioma.isEmpty()){
            try{
                this.idIdioma = Integer.parseInt(idioma);
            }
            catch(NumberFormatException nex){
                nex.getMessage();
                validos = Boolean.FALSE;
            }
        }
        else{
            validos = Boolean.FALSE;
        }
        
        if(pais != null && !pais.isEmpty()){
            try{
                this.idPais = Integer.parseInt(pais);
            }
            catch(NumberFormatException nex){
                nex.getMessage();
                validos = Boolean.FALSE;
            }
        }
        else{
            validos = Boolean.FALSE;
        }
        
        if(genero != null && !genero.isEmpty()){
            try{
                this.idGenero = Integer.parseInt(genero);
            }
            catch(NumberFormatException nex){
                nex.getMessage();
                validos = Boolean.FALSE;
            }
        }
        else{
            validos = Boolean.FALSE;
        }
        
        
        
        return Boolean.TRUE;
    }
    
    public Disco getDisco(){
        Disco disco = new Disco();
        disco.setTitulo(this.getTitulo());
        disco.setPrecio(this.getPrecio());
        disco.setCantidadDisponible(this.getCantidad());
        disco.setFechaLanzamiento(new java.sql.Date(this.getFechaLanzamiento().getTime()));
        Idioma idioma = new Idioma();
        idioma.setId(this.getIdIdioma());
        disco.setIdioma(idioma);
        Pais pais = new Pais();
        pais.setId(this.getIdPais());
        disco.setPais(pais);
        GeneroMusical genero = new GeneroMusical();
        genero.setId(this.getIdGenero());
        disco.setGeneroMusical(genero);
        Disquera disquera = new Disquera();
        disquera.setId(1);
        disco.setDisquera(disquera);
        Iva iva = new Iva();
        iva.setId(1);
        disco.setIva(iva);
        disco.setRutaImagen("");
        return disco;
    }
}

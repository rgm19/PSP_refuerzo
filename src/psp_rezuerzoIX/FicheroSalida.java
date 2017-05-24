/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_rezuerzoIX;

import java.io.Serializable;

/**
 *
 * @author usuario5
 */
public class FicheroSalida implements Serializable {
    
    byte[]contenidoFichero = new byte[1024];
    int byteValidos;
    
    boolean ultimoMensaje;
    
    private String nombre_fichero;

    public FicheroSalida() {
    }

    public boolean isUltimoMensaje() {
        return ultimoMensaje;
    }

    public void setUltimoMensaje(boolean ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }

    public String getNombre_fichero() {
        return nombre_fichero;
    }

    public void setNombre_fichero(String nombre_fichero) {
        this.nombre_fichero = nombre_fichero;
    }
    
    
    
    
}

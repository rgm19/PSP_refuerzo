/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoII;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author usuario5
 */
public class Usuarios {
    private String nombre;
    private BufferedReader IN;
    private PrintWriter OUT;
    private int ncli;

    public Usuarios(BufferedReader IN, PrintWriter OUT, int ncli) {
        this.ncli = ncli;
        initNombre();
        this.IN = IN;
        this.OUT = OUT;
        
    }

    public void initNombre(){
        nombre="Usuario["+ncli+"]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BufferedReader getIN() {
        return IN;
    }

    public void setIN(BufferedReader IN) {
        this.IN = IN;
    }

    public PrintWriter getOUT() {
        return OUT;
    }

    public void setOUT(PrintWriter OUT) {
        this.OUT = OUT;
    }

    public int getNcli() {
        return ncli;
    }

    public void setNcli(int ncli) {
        this.ncli = ncli;
    }

    
}

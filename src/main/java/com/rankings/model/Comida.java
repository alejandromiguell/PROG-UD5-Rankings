//Este es un modelo de Comida que representa un plato de comida con sus atributos y métodos.

package main.java.com.rankings.model;
public class Comida {
    
    //---------------------------------------Atributos---------------------------------------
    private String nombre;
    private String tipoCocinado;
    private String sabor;
    private int puntuacion; 
   //---------------------------------------Atributos---------------------------------------

    //---------------------------------------Constructores---------------------------------------
    public Comida (String nombre, String tipoCocinado, String sabor, int puntuacion) {
        this.nombre = nombre;
        this.tipoCocinado = tipoCocinado;
        this.sabor = sabor;
        this.puntuacion = puntuacion;
    }
    
   

//---------------------------------------Constructores---------------------------------------

//---------------------------------------Getters y Setters---------------------------------------
    
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String gettipoCocinado() {
        return tipoCocinado;
    }
    
    public void settipoCocinado(String tipoCocinado) {
        this.tipoCocinado = tipoCocinado;
    }
    
    public String getsabor() {
        return sabor;
    }
    
    public void setsabor(String sabor) {
        this.sabor = sabor;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }
    
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

//---------------------------------------Getters y Setters---------------------------------------
    
   public String toString() {
        return nombre + " - " + tipoCocinado + " - " + sabor + " - " + puntuacion + " puntos";
    }

    }

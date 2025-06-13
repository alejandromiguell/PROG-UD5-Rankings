package main.java.com.rankings.model;
public class Restaurante {
    
    //---------------------------------------Atributos---------------------------------------
    private String nombre;
    private String tipoCocina;
    private String sitio;
    private int puntuacion; 
   //---------------------------------------Atributos---------------------------------------

    //---------------------------------------Constructores---------------------------------------
    public Restaurante (String nombre, String tipoCocina, String sitio, int puntuacion) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.sitio = sitio;
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
    
    public String getTipoCocina() {
        return tipoCocina;
    }
    
    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }
    
    public String getsitio() {
        return sitio;
    }
    
    public void setsitio(String sitio) {
        this.sitio = sitio;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }
    
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

//---------------------------------------Getters y Setters---------------------------------------
    
   public String toString() {
        return nombre + " - " + tipoCocina + " - " + sitio + " - " + puntuacion + " puntos";
    }

    }

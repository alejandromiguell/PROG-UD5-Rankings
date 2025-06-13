package main.java.com.rankings.util;

import javax.swing.JOptionPane;


public class Validaciones {
    
  
    public static boolean textoVacio(String texto) {
        if (texto == null || texto.equals("")) {
            return true;
        }
        return false;
    }
    
    // Ver si la puntuacion es correcta
    public static boolean puntuacionCorrecta(int puntuacion) {
        if (puntuacion >= 1 && puntuacion <= 5) {
            return true;
        }
        return false;
    }
    
    // Pasar de texto a numero
    public static int textoANumero(String texto) {
        try {
            int numero = Integer.parseInt(texto);
            return numero;
        } catch (Exception e) {
            return -1;
        }
    }
    
    //Errores
    public static void error(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
  
    public static void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    // Preguntar si o no
    public static boolean preguntarSiNo(String pregunta) {
        int respuesta = JOptionPane.showConfirmDialog(null, pregunta, "Pregunta", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }
}
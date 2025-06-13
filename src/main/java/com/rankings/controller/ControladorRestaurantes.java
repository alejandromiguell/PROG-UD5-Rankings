// Esta clase controla la gestión de restaurantes, permitiendo añadir, mostrar, editar y eliminar restaurantes.

package main.java.com.rankings.controller;

import main.java.com.rankings.model.Restaurante;
import main.java.com.rankings.util.Validaciones;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class ControladorRestaurantes {

    private ArrayList<Restaurante> restaurantes;
    
  
    public ControladorRestaurantes() {
        restaurantes = new ArrayList<Restaurante>();
    }
    

    public void anadirRestaurante() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del restaurante:");
            if (Validaciones.textoVacio(nombre)) {
                Validaciones.error("El nombre no puede estar vacio");
                return;
            }
            
            String tipoCocina = JOptionPane.showInputDialog("Tipo de cocina:");
            if (Validaciones.textoVacio(tipoCocina)) {
                Validaciones.error("El tipo de cocina no puede estar vacio");
                return;
            }
            
            String ubicacion = JOptionPane.showInputDialog("Ubicacion:");
            if (Validaciones.textoVacio(ubicacion)) {
                Validaciones.error("La ubicacion no puede estar vacia");
                return;
            }
            
            String puntuacionTexto = JOptionPane.showInputDialog("Puntuacion (1-5):");
            int puntuacion = Validaciones.textoANumero(puntuacionTexto);
            
            if (puntuacion == -1) {
                Validaciones.error("La puntuacion debe ser un numero");
                return;
            }
            
            if (!Validaciones.puntuacionCorrecta(puntuacion)) {
                Validaciones.error("La puntuacion debe estar entre 1 y 5");
                return;
            }
            
            // Crear el restaurante y añadirlo
            Restaurante nuevoRestaurante = new Restaurante(nombre, tipoCocina, ubicacion, puntuacion);
            restaurantes.add(nuevoRestaurante);
            Validaciones.mensaje("Restaurante añadido correctamente!");
            
        } catch (Exception e) {
            Validaciones.error("Error al añadir restaurante");
        }
    }
    
    // Mostrar todos los restaurantes
    public void mostrarRestaurantes() {
        if (restaurantes.size() == 0) {
            Validaciones.mensaje("No hay restaurantes guardados");
            return;
        }
        
    
        ordenarPorPuntuacion();
        
        String mensaje = "=== RANKING DE RESTAURANTES ===\n\n";
        for (int i = 0; i < restaurantes.size(); i++) {
            mensaje += (i + 1) + ". " + restaurantes.get(i).toString() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje, "Ranking", JOptionPane.INFORMATION_MESSAGE);
    }
    

    public void editarRestaurante() {
        if (restaurantes.size() == 0) {
            Validaciones.mensaje("No hay restaurantes para editar");
            return;
        }
        
        String lista = "Elige el restaurante a editar:\n";
        for (int i = 0; i < restaurantes.size(); i++) {
            lista += i + ". " + restaurantes.get(i).getNombre() + "\n";
        }
        
        String numeroTexto = JOptionPane.showInputDialog(lista + "\nEscribe el numero:");
        int numero = Validaciones.textoANumero(numeroTexto);
        
        if (numero == -1 || numero < 0 || numero >= restaurantes.size()) {
            Validaciones.error("Numero no valido");
            return;
        }

        Restaurante restauranteEditar = restaurantes.get(numero);
        
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", restauranteEditar.getNombre());
        if (!Validaciones.textoVacio(nuevoNombre)) {
            restauranteEditar.setNombre(nuevoNombre);
        }
        
        String nuevoCocina = JOptionPane.showInputDialog("Nuevo tipo de cocina:", restauranteEditar.getTipoCocina());
        if (!Validaciones.textoVacio(nuevoCocina)) {
            restauranteEditar.setTipoCocina(nuevoCocina);
        }
        
        String nuevaUbicacion = JOptionPane.showInputDialog("Nueva ubicacion:", restauranteEditar.getsitio());
        if (!Validaciones.textoVacio(nuevaUbicacion)) {
            restauranteEditar.setsitio(nuevaUbicacion);
        }
        
        String nuevaPuntuacion = JOptionPane.showInputDialog("Nueva puntuacion (1-5):", restauranteEditar.getPuntuacion() + "");
        int puntuacion = Validaciones.textoANumero(nuevaPuntuacion);
        if (puntuacion != -1 && Validaciones.puntuacionCorrecta(puntuacion)) {
            restauranteEditar.setPuntuacion(puntuacion);
        }
        
        Validaciones.mensaje("Restaurante editado correctamente!");
    }
    

    public void eliminarRestaurante() {
        if (restaurantes.size() == 0) {
            Validaciones.mensaje("No hay restaurantes para eliminar");
            return;
        }
        
    
        String lista = "Elige el restaurante a eliminar:\n";
        for (int i = 0; i < restaurantes.size(); i++) {
            lista += i + ". " + restaurantes.get(i).getNombre() + "\n";
        }
        
        String numeroTexto = JOptionPane.showInputDialog(lista + "\nEscribe el numero:");
        int numero = Validaciones.textoANumero(numeroTexto);
        
        if (numero == -1 || numero < 0 || numero >= restaurantes.size()) {
            Validaciones.error("Numero no valido");
            return;
        }
        
   
        Restaurante restauranteEliminar = restaurantes.get(numero);
        boolean confirmar = Validaciones.preguntarSiNo("¿Seguro que quieres eliminar " + restauranteEliminar.getNombre() + "?");
        
        if (confirmar) {
            restaurantes.remove(numero);
            Validaciones.mensaje("Restaurante eliminado correctamente!");
        }
    }
    
    
    private void ordenarPorPuntuacion() {
        for (int i = 0; i < restaurantes.size() - 1; i++) {
            for (int j = 0; j < restaurantes.size() - 1 - i; j++) {
                if (restaurantes.get(j).getPuntuacion() < restaurantes.get(j + 1).getPuntuacion()) {
                    Restaurante temp = restaurantes.get(j);
                    restaurantes.set(j, restaurantes.get(j + 1));
                    restaurantes.set(j + 1, temp);
                }
            }
        }
    }
}
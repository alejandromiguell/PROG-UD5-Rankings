// Esta clase controla la gestión de restaurantes, permitiendo añadir, mostrar, editar y eliminar restaurantes.

package main.java.com.rankings.controller;

import main.java.com.rankings.model.Comida;
import main.java.com.rankings.util.Validaciones;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class ControladorRestaurantes {

    private ArrayList<Comida> comidas;
    
  
    public ControladorRestaurantes() {
        comidas = new ArrayList<Comida>();
    }


    public void anadirComida() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre de la comida:");
            if (Validaciones.textoVacio(nombre)) {
                Validaciones.error("El nombre no puede estar vacio");
                return;
            }
            
            String tipoCocinado = JOptionPane.showInputDialog("Tipo de cocinado:");
            if (Validaciones.textoVacio(tipoCocinado)) {
                Validaciones.error("El tipo de cocinado no puede estar vacio");
                return;
            }
            
            String sabor = JOptionPane.showInputDialog("Sabor:");
            if (Validaciones.textoVacio(sabor)) {
                Validaciones.error("El sabor no puede estar vacio");
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
            
            // Crear la comida y añadirla
            Comida nuevaComida = new Comida(nombre, tipoCocinado, sabor, puntuacion);
            comidas.add(nuevaComida);
            Validaciones.mensaje("Comida añadida correctamente!");
            
        } catch (Exception e) {
            Validaciones.error("Error al añadir comida");
        }
    }

    // Mostrar todos los comidas
    public void mostrarComidas() {
        if (comidas.size() == 0) {
            Validaciones.mensaje("No hay comidas guardadas");
            return;
        }
        
    
        ordenarPorPuntuacion();

        String mensaje = "=== RANKING DE COMIDAS ===\n\n";
        for (int i = 0; i < comidas.size(); i++) {
            mensaje += (i + 1) + ". " + comidas.get(i).toString() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje, "Ranking", JOptionPane.INFORMATION_MESSAGE);
    }
    

    public void editarComida() {
        if (comidas.size() == 0) {
            Validaciones.mensaje("No hay comidas para editar");
            return;
        }
        
        String lista = "Elige la comida a editar:\n";
        for (int i = 0; i < comidas.size(); i++) {
            lista += i + ". " + comidas.get(i).getNombre() + "\n";
        }
        
        String numeroTexto = JOptionPane.showInputDialog(lista + "\nEscribe el numero:");
        int numero = Validaciones.textoANumero(numeroTexto);

        if (numero == -1 || numero < 0 || numero >= comidas.size()) {
            Validaciones.error("Numero no valido");
            return;
        }

        Comida comidaEditar = comidas.get(numero);
        
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", comidaEditar.getNombre());
        if (!Validaciones.textoVacio(nuevoNombre)) {
            comidaEditar.setNombre(nuevoNombre);
        }
        
        String nuevoCocina = JOptionPane.showInputDialog("Nuevo tipo de cocina:", comidaEditar.gettipoCocinado());
        if (!Validaciones.textoVacio(nuevoCocina)) {
            comidaEditar.settipoCocinado(nuevoCocina);
        }

        String nuevoSabor = JOptionPane.showInputDialog("Nuevo sabor:", comidaEditar.getsabor());
        if (!Validaciones.textoVacio(nuevoSabor)) {
            comidaEditar.setsabor(nuevoSabor);
        }

        String nuevaPuntuacion = JOptionPane.showInputDialog("Nueva puntuacion (1-5):", comidaEditar.getPuntuacion() + "");
        int puntuacion = Validaciones.textoANumero(nuevaPuntuacion);
        if (puntuacion != -1 && Validaciones.puntuacionCorrecta(puntuacion)) {
            comidaEditar.setPuntuacion(puntuacion);
        }

        Validaciones.mensaje("Comida editada correctamente");
    }


    public void eliminarComida() {
        if (comidas.size() == 0) {
            Validaciones.mensaje("No hay comidas para eliminar");
            return;
        }

        String lista = "Elige la comida a eliminar:\n";
        for (int i = 0; i < comidas.size(); i++) {
            lista += i + ". " + comidas.get(i).getNombre() + "\n";
        }

        String numeroTexto = JOptionPane.showInputDialog(lista + "\nEscribe el numero:");
        int numero = Validaciones.textoANumero(numeroTexto);

        if (numero == -1 || numero < 0 || numero >= comidas.size()) {
            Validaciones.error("Numero no valido");
            return;
        }

        Comida comidaEliminar = comidas.get(numero);
        boolean confirmar = Validaciones.preguntarSiNo("¿Seguro que quieres eliminar " + comidaEliminar.getNombre() + "?");

        if (confirmar) {
            comidas.remove(numero);
            Validaciones.mensaje("Comida eliminada correctamente!");
        }
    }
    
    
    private void ordenarPorPuntuacion() {
        for (int i = 0; i < comidas.size() - 1; i++) {
            for (int j = 0; j < comidas.size() - 1 - i; j++) {
                if (comidas.get(j).getPuntuacion() < comidas.get(j + 1).getPuntuacion()) {
                    Comida temp = comidas.get(j);
                    comidas.set(j, comidas.get(j + 1));
                    comidas.set(j + 1, temp);
                }
            }
        }
    }
}
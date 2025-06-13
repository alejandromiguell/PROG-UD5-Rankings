package  main.java.com.rankings.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Ventana del menu principal
public class Ventana extends JFrame implements ActionListener {
    
    // Los botones
    private JButton botonAnadir;
    private JButton botonEditar;
    private JButton botonMostrar;
    private JButton botonEliminar;
    private JButton botonSalir;
    
    // Constructor
    public Ventana() {
        hacerVentana();
        hacerBotones();
    }
    
    // Hacer la ventana
    private void hacerVentana() {
        setTitle("Ranking de Restaurantes");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));
    }
    
   
    private void hacerBotones() {
        JLabel titulo = new JLabel("Menu Principal");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo);
        
        botonAnadir = new JButton("1. Añadir Restaurante");
        botonEditar = new JButton("2. Editar Restaurante");
        botonMostrar = new JButton("3. Mostrar Restaurantes");
        botonEliminar = new JButton("4. Eliminar Restaurante");
        botonSalir = new JButton("5. Salir");
        
        botonAnadir.addActionListener(this);
        botonEditar.addActionListener(this);
        botonMostrar.addActionListener(this);
        botonEliminar.addActionListener(this);
        botonSalir.addActionListener(this);
        
        add(botonAnadir);
        add(botonEditar);
        add(botonMostrar);
        add(botonEliminar);
        add(botonSalir);
    }
    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAnadir) {
            JOptionPane.showMessageDialog(this, "Elegiste: añadir restaurante");
        }
        else if (e.getSource() == botonEditar) {
            JOptionPane.showMessageDialog(this, "Elegiste: editar restaurante");
        }
        else if (e.getSource() == botonMostrar) {
            JOptionPane.showMessageDialog(this, "Elegiste: mostrar restaurantes");
        }
        else if (e.getSource() == botonEliminar) {
            JOptionPane.showMessageDialog(this, "Elegiste: eliminar restaurante");
        }
        else if (e.getSource() == botonSalir) {
            int respuesta = JOptionPane.showConfirmDialog(this, 
                "quieres salir del programa?", "Salir", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
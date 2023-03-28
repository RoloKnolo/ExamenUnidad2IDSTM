package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgramaRegistroUsuarios extends JFrame implements ActionListener {
    // Componentes del programa
    private JLabel etiquetaNombre;
    private JTextField campoNombre;
    private JLabel etiquetaApellido;
    private JTextField campoApellido;
    private JLabel etiquetaCorreo;
    private JTextField campoCorreo;
    private JButton botonRegistrar;
    private JLabel etiquetaBusqueda;
    private JTextField campoBusqueda;
    private JButton botonBuscar;
    private JButton botonAnterior;
    private JButton botonSiguiente;
    private JButton botonCambiarPanel;
    private JPanel panelPrincipal;
    private JPanel panelRegistro;
    private JPanel panelBusqueda;
    private JScrollPane scrollPane;
    private JFrame ventana;
    private int indicePanelActual;

    public ProgramaRegistroUsuarios() {
        // Crear la ventana
        ventana = new JFrame("Programa de registro de usuarios");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los componentes
        etiquetaNombre = new JLabel("Nombre:");
        campoNombre = new JTextField(20);
        etiquetaApellido = new JLabel("Apellido:");
        campoApellido = new JTextField(20);
        etiquetaCorreo = new JLabel("Correo electrónico:");
        campoCorreo = new JTextField(20);
        botonRegistrar = new JButton("Registrar");
        botonRegistrar.addActionListener(this);

        etiquetaBusqueda = new JLabel("Buscar usuario por nombre:");
        campoBusqueda = new JTextField(20);
        botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(this);

        botonAnterior = new JButton("<");
        botonAnterior.addActionListener(this);
        botonSiguiente = new JButton(">");
        botonSiguiente.addActionListener(this);
        botonCambiarPanel = new JButton("Cambiar panel");
        botonCambiarPanel.addActionListener(this);

        // Crear el panel de registro de usuarios
        panelRegistro = new JPanel();
        panelRegistro.setLayout(new BoxLayout(panelRegistro, BoxLayout.Y_AXIS));

        // Añadir los componentes al panel de registro
        panelRegistro.add(etiquetaNombre);
        panelRegistro.add(campoNombre);
        panelRegistro.add(etiquetaApellido);
        panelRegistro.add(campoApellido);
        panelRegistro.add(etiquetaCorreo);
        panelRegistro.add(campoCorreo);
        panelRegistro.add(botonRegistrar);
        panelRegistro.add(Box.createVerticalGlue());

        // Crear el panel de búsqueda de usuarios
        panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new BoxLayout(panelBusqueda, BoxLayout.Y_AXIS));

        // Añadir los componentes al panel de búsqueda
        panelBusqueda.add(etiquetaBusqueda);
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(botonBuscar);
        panelBusqueda.add(Box.createVerticalGlue());

        // Crear el panel principal y agregar los componentes
        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(botonAnterior, BorderLayout.WEST);
        panelPrincipal.add(botonSiguiente, BorderLayout.EAST);
        panelPrincipal.add(botonCambiarPanel, BorderLayout.NORTH);
        panelPrincipal.add(panelRegistro, BorderLayout.CENTER);

        // Crear el JScrollPane y agregar el panel principal
        scrollPane = new JScrollPane(panelPrincipal);

        // Agregar el JScrollPane a la ventana
        ventana.getContentPane().add(scrollPane);
        
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        // Inicializar el índice del panel actual
        indicePanelActual = 0;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAnterior) {
            if (indicePanelActual > 0) {
                indicePanelActual--;
                cambiarPanel();
            }
        } else if (e.getSource() == botonSiguiente) {
            // Cambiar al siguiente panel
            if (indicePanelActual < 1) {
                indicePanelActual++;
                cambiarPanel();
            }
        } else if (e.getSource() == botonCambiarPanel) {
            // Cambiar al panel opuesto
            indicePanelActual = (indicePanelActual + 1) % 2;
            cambiarPanel();
        } else if (e.getSource() == botonRegistrar) {
            // Registrar un usuario nuevo
            String nombre = campoNombre.getText();
            String apellido = campoApellido.getText();
            String correo = campoCorreo.getText();

            // Validar que los campos no estén vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un nuevo usuario
            Usuario usuario = new Usuario(nombre, apellido, correo);

            // Agregar el usuario a la lista de usuarios
            System.out.println("Usuario registrado: " + usuario);

            // Limpiar los campos de texto
            campoNombre.setText("");
            campoApellido.setText("");
            campoCorreo.setText("");
        } else if (e.getSource() == botonBuscar) {
            // Buscar un usuario por nombre
            String nombreBusqueda = campoBusqueda.getText();

            // Validar que el campo de búsqueda no esté vacío
            if (nombreBusqueda.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre de usuario para buscar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar el usuario y mostrarlo en consola
            System.out.println("Buscando usuario con nombre: " + nombreBusqueda);
        }
    }

    private void cambiarPanel() {
        // Obtener el panel correspondiente al índice actual
        JPanel panelNuevo;
        if (indicePanelActual == 0) {
            panelNuevo = panelRegistro;
        } else {
            panelNuevo = panelBusqueda;
        }

        // Cambiar el panel en el JScrollPane
        panelPrincipal.removeAll();
        panelPrincipal.add(botonAnterior, BorderLayout.WEST);
        panelPrincipal.add(botonSiguiente, BorderLayout.EAST);
        panelPrincipal.add(botonCambiarPanel, BorderLayout.NORTH);
        panelPrincipal.add(panelNuevo, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

  
}



   

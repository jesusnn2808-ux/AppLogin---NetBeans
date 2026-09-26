package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

public class LoginControler {
    private LoginView vista;
    private UserDAO dao;

    public LoginControler(LoginView vista, UserDAO dao) {
        this.vista = vista;
        this.dao = dao;
        conectarEventos();
    } // Constructor cerrado correctamente aquí

    public void conectarEventos() {
        this.vista.listenBtnIngresar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarLogin();
            }
        });
    } // Método conectarEventos cerrado aquí

    public void procesarLogin() {
        String user = vista.getUsuario();
        String pass = vista.getPassword();

        User usuarioLogueado = dao.autenticar(user, pass);

        if (usuarioLogueado != null) {
            vista.mostrarMensajeExito(usuarioLogueado.getUsername());
            vista.setVisible(false);
            
            // Ejecución polimórfica según el rol
            usuarioLogueado.mostrarMenu(this);
        } else {
            vista.mostrarMensajeError("Credenciales Inválidas");
        }
    }

    public void mostrarPanelAdmin(Admin admin) {
        MenuAdminView menuAdmin = new MenuAdminView(this);
        menuAdmin.setVisible(true);
    }

    public void mostrarPanelCliente(Client cliente) {
        MenuClientView menuCliente = new MenuClientView(this);
        menuCliente.setVisible(true);
    }

    public void regresarALogin() {
        LoginView nuevaVista = new LoginView();
        this.vista = nuevaVista;
        conectarEventos();
        this.vista.setVisible(true);
    }
} // Fin de la clase LoginControler
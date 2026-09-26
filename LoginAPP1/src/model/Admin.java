package model;

import controler.LoginControler;

public class Admin extends User {

    // Constructor que recibe los 4 parámetros obligatorios
    public Admin(int id, String username, String password, String rol) {
        super(id, username, password, rol);
    }

    @Override
    public void mostrarMenu(LoginControler controlador) {
        controlador.mostrarPanelAdmin(this);
    }
}
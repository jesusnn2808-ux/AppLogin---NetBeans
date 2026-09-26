package model;

import controler.LoginControler;

public class Client extends User {

    public Client(int id, String username, String password, String rol) {
        super(id, username, password, rol);
    }

    @Override
    public void mostrarMenu(LoginControler controlador) {
        controlador.mostrarPanelCliente(this);
    }
}
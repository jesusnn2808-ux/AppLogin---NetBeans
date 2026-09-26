package model;

import controler.LoginControler;

public abstract class User {
    protected int id;
    protected String username;
    protected String password;
    protected String rol;

    // Constructor de 4 parámetros
    public User(int id, String username, String password, String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRol() { return rol; }

    public abstract void mostrarMenu(LoginControler controlador);
}
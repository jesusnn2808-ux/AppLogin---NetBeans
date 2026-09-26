/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginapp1;

/**
 *
 * @author KhePasaLojiCTM
 */
import model.DBConection;
import java.sql.Connection;
        
public class LoginAPP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bienvenido, estamos probando la DB");
        
        Connection nuevaConexion = DBConection.getConexion();
        
        if(nuevaConexion !=null) {
            System.out.println("Conectado a la BD");
        }else {
            System.out.println("Fallo en la conexion");
        }
    }
    
}

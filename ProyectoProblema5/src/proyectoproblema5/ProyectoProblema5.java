/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoproblema5;
import vista.InicioSesionVista;

/**
 *
 * @author KATHE
 */
public class ProyectoProblema5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new InicioSesionVista().setVisible(true);
            }
        });
    }
    
}

package main;

import controller.MainMenuController;
import javax.swing.SwingUtilities;

/**
 * Clase main que instancia el controller, es decir instancia un objeto 
 * de la clase MainMenuController que se comunica con el frame y las clases
 * verificadoras.
 * Author Melisa Speranza - https://www.linkedin.com/in/melisa-speranza/
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainMenuController controller = new MainMenuController();
            }
        });
    }
    
}

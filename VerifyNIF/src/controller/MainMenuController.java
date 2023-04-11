/*
* Author Melisa Speranza - https://www.linkedin.com/in/melisa-speranza/
*En esta clase interactúa la clase MainFrame con las clases verificadoras
*VerifyNIE/VerifyNIF
*Se lanza el frame inicial y se añaden los listeners al botón y textField
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import views.MainFrame;
import main.*;


public class MainMenuController implements ActionListener, KeyListener {
        
    private static final MainFrame mainFrame = new MainFrame();
    
    
    public MainMenuController(){
        
        //Inicializes the mainFrame attribut to show the main frame.
        //For each component this object will be added as a listener.       
        
        //Adding the controller as "verify" button listener:
        JButton button = mainFrame.getjButton1();
        //Setting the button as the default button for enter key to work on it
        mainFrame.getRootPane().setDefaultButton(button);
        JTextField textField = mainFrame.getjTextField1();
        button.addActionListener(this);
        //Add the action to the textfield with Enter key
        //By setting the button as default it will activate with enter key, so
        //no key mapping is necesary if its only one key.
        textField.addActionListener(this);
                       
        //Inicializes the mainFrame attribute to show the main frame.
        //For each component this object will be added as a listener.
        mainFrame.setVisible(true);
        
        //Con este codigo se cerrará la aplicación con Escape key.
        mainFrame.getRootPane().getInputMap(textField.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
        mainFrame.getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.setVisible(false);
                System.exit(0);
            }
        });
      
    }
        
    //We are using two interfaces (Implements ActionListener...), so we must override all the methods.
     @Override
    public void actionPerformed(ActionEvent e) {
        implementation();
        
    }

    //En este método se encuentra la implementación inicial que determina si
    //el usuario ha introducido un NIE o un DNI, e instancia un objeto de la clase
    //verificadora apropiada - VerifyNIE o VerifyNIF
    public void implementation(){
        
        String textField = mainFrame.getjTextField1().getText();
        
        VerifyNIF verifyNIF = new VerifyNIF(textField);
        
        
        VerifyNIE verifyNIE = new VerifyNIE(textField);
        
        //Verifico qué  hay en el primer char del string para saber qué método de validación llamar:
        //si el charAt(0) es una letra, será verifyNIE. si no hay letra en el char 0 será verifyNIF
        
        String primerPos = textField.substring(0,1);
        
        if((primerPos.equalsIgnoreCase("x")) || (primerPos.equalsIgnoreCase("y")) || (primerPos.equalsIgnoreCase("z"))){
            
            if(verifyNIE.validar(textField)){
                JOptionPane.showMessageDialog(mainFrame, "NIE Correcto");
            }else {
                JOptionPane.showMessageDialog(mainFrame, "No es un NIE");
            }
            
        } else if(verifyNIF.validar(textField)){
            JOptionPane.showMessageDialog(mainFrame, "NIF Correcto");
        }else {
            JOptionPane.showMessageDialog(mainFrame, "No es un NIF");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

}


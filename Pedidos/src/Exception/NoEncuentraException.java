/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import javax.swing.JOptionPane;

/**
 *
 * @author sotog
 */
public class NoEncuentraException extends RuntimeException{

    public NoEncuentraException() {
        JOptionPane.showMessageDialog(null,"No se encontro");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author blazar
 */
public final class Maquina extends JPanel implements MetodosComunes {

    //:::::::::::::Variables::::::::::::
    JLabel msj;
    /**
     * Almacena los dígitos que el usuario va ingresando.
     */
    String nip;
    /**
     * Almacena los digitos de la cantidad que el usario va ingresando.
     */
    String cantidad;
    /**
     * Representa el saldo del cliente.
     */
    double saldo;
    /**
     *   Constante con el nip válido.
     */
    String nipValido;
    /**
     * Mensaje que pide al usuario digitar su NIP.
     */
    String msjInputNIP;
  
    /**
     * Mensaje que pide al usuario Ingresar  su tarjeta.
     */
    String msjInputCard;
    /**
     * Mensaje que pide al usuario que ingrese una cantidad.
     */
    String msjInputCantidad;
    /**
     * Mensaje que avisa al usario que su NIP es incorrecto
     */
    String msjNipIncorrecto;
    
    String msjInputCantidadDepositar;
    /**
     * Mensaje que avisa al usaurio que solo se permiten multiplos de 50
     */
    String msjSolo50;
    /**
     * Mensaje que avisa al cliente que el saldo es insuficiente.
     */
    String msjSaldoInsuficiente;
    String msjInputCantidadRetirar;
    
    JButton retirar;
    JButton consultar;
    JButton depositar;
    JButton menu;
    
    public enum Caja {
        aceptar,
        borrar,
        cancelar,
        retirar,
        consultar,
        depositar,
        nulo
    };
    public Caja caja = Caja.nulo;
    
    
    

    //Constructor
    public Maquina() {
        //configuramos las propiedas de nuestra clase
        this.setLayout(null);
        this.setBackground(new Color(216, 168, 199));
        
        //Definimos el nip de las variables
        this.nip = "";
        this.saldo = 8345;
        this.cantidad = "";
        this.nipValido = "3000";
        this.msjInputNIP = "<html>Ingrese su NIP: ";
        this.msjInputCard = "<html>Ingrese su tarjeta.<html>";
        
        this.msjInputCantidadRetirar = "<html>Ingrese la cantidad a retirar:<br><br>$ ";
        this.msjNipIncorrecto = "<html>Su NIP es incorrecto.";
        this.msjSolo50 = "<html>Solo se aceptan<br>múltiplos de $50<html>.";
        this.msjSaldoInsuficiente = "<html>Saldo insuficiente<html.";
        msjInputCantidadDepositar = "<html>Ingrese la cantidad<br>a depositar:<br>$ ";
        
        

        this.instanceObj();
        this.defBounds();
        this.otherOpciones();
        this.addContent();

    }

    //instanciar solo la clases
    @Override
    public void instanceObj() {
        this.msj = new JLabel(this.msjInputCard);
        this.msj.setFont(new Font("Arial", Font.PLAIN, 16));
        this.retirar = new JButton("Retirar");
        this.consultar = new JButton("Consultar");
        this.depositar = new JButton("Depositar");
        this.menu = new JButton("Ir al menú");

    }
    public void otherOpciones(){
        this.retirar.setEnabled(false);
        this.consultar.setEnabled(false);
        this.depositar.setEnabled(false);
        this.menu.setEnabled(false);
    }

    //establecer la posicion y el tamaño
    @Override
    public void defBounds() {
        int width = 100;
        int height = 25;
        int space = 30;
        int space2 = 12;
        this.msj.setBounds(10, 20, 250, 120);//
        this.retirar.setBounds(250, (space/2)+space2, width, height);
        this.consultar.setBounds(250, (height+space) + space2, width, height);
        this.depositar.setBounds(250, (height*2+space+(space/2))+space2, width, height);
        this.menu.setBounds(250, (height*3+space+(space*2/2))+space2, width, height);
    }
    
    //agregar los objetos al panel
    @Override
    public void addContent() {
        this.add(this.msj);
        this.add(this.retirar);
        this.add(this.consultar);
        this.add(this.depositar);
        this.add(this.menu);
    }

    @Override
    public void set_colors() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

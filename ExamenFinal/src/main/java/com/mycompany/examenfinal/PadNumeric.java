/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinal;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase que representa el panel numérico de un cajero automático
 *
 * @author blazar
 */
public final class PadNumeric extends JPanel implements MetodosComunes {

    /**
     * Objetos que representan los numeros del 0 al 9 donde, donde cada posición
     * del arreglo está asociado con su valor de etiqueta
     */
    JButton[] numeros;
    JButton aceptar;
    JButton borrar;
    JButton cancelar;
    JButton ingresar_tarjeta;

    public PadNumeric() {
        this.setLayout(null);
        this.instanceObj();
        this.defBounds();
        this.set_colors();
        this.addContent();
    }

    @Override
    public void instanceObj() {
        this.numeros = new JButton[10];
        for (var i = 0; i <= 9; i++) {
            this.numeros[i] = new JButton(Integer.toString(i));
        }
        this.aceptar = new JButton("Aceptar");
        this.borrar = new JButton("Borrar");
        this.cancelar = new JButton("Cancelar");
        this.ingresar_tarjeta = new JButton("Ingresar tarjeta");

        //desahibilitar los         
        for (var i = 0; i <= 9; i++) {
            this.numeros[i].setEnabled(false);
        }
        this.aceptar.setEnabled(false);
        this.cancelar.setEnabled(false);
        this.borrar.setEnabled(false);
    }

    @Override
    public void defBounds() {
        int width = 60; //base
        int height = 40; //altura
        int space = 20; //espaciado entre botones

        /*Definimos el tamaño y las posiciones de los botones*/
        this.numeros[7].setBounds(10, 10, width, height);
        this.numeros[8].setBounds(width + space, 10, width, height);
        this.numeros[9].setBounds((width * 2) + space + (space / 2), 10, width, height);

        this.numeros[4].setBounds(10, height + space, width, height);
        this.numeros[5].setBounds(width + space, height + space, width, height);
        this.numeros[6].setBounds((width * 2) + space + (space / 2), height + space, width, height);

        this.numeros[1].setBounds(10, (height * 2) + space + (space / 2), width, height);
        this.numeros[2].setBounds(width + space, (height * 2) + space + (space / 2), width, height);
        this.numeros[3].setBounds((width * 2) + space + (space / 2), (height * 2) + space + (space / 2), width, height);

        this.numeros[0].setBounds(width + space, (height * 2) + space * 4, width, height);

        //definimos otros botones
        width = 100;
        height = 40;
        space = 20;
        int space2 = 0;
        this.aceptar.setBounds(250, (space / 2) + space2, width, height);
        this.borrar.setBounds(250, (height + space) + space2, width, height);
        this.cancelar.setBounds(250, (height * 2 + space + (space / 2)) + space2, width, height);
        this.ingresar_tarjeta.setBounds(200, (height * 3 + space + (space * 2 / 2)), width + 50, height);
    }

    @Override
    public void addContent() {

        for (var i = 0; i <= 9; i++) {
            this.add(this.numeros[i]);
        }
        this.add(this.aceptar);
        this.add(this.borrar);
        this.add(this.cancelar);
        this.add(this.ingresar_tarjeta);
    }

    @Override
    public void set_colors() {
        this.aceptar.setBackground(new Color(4, 177, 23));
        this.borrar.setBackground(Color.YELLOW);
        this.cancelar.setBackground(Color.RED);

    }

}

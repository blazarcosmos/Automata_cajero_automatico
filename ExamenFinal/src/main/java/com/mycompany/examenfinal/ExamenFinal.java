/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenfinal;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author blazar
 */
public final class ExamenFinal extends JFrame implements MetodosComunes{

    /*Definicion de objetos*/
    Automata automata;
    Interfaz interfaz_GUI; //objetos que contrenda toda la GUI del interfaz_GUI
    Maquina maquina;
    PadNumeric padNumeric;
    int[][] positionImageXY = {}; //posiciones de las imagenes para realizar el automata

    public ExamenFinal() {
        super("Cajero automático");
        super.setLayout(null); //desactivamos el Layout
        this.setSize(1300, 800);
        this.setBackground(Color.yellow);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //cargamos componentes
        this.instanceObj();
        this.defBounds();
        this.set_colors();
                
        this.addContent(); //este metodo siempre debe ir despues de hacer cambios a los objetos graficos
        
    }

    /*Instanciar objetos*/
    @Override
    public void instanceObj() {
        this.automata = new Automata();
        this.automata.setLayout(null); //desactivamos el layout
        this.maquina = new Maquina();
        this.padNumeric = new PadNumeric();
        this.interfaz_GUI = new Interfaz(this.maquina, this.padNumeric, this.automata);
        //this.interfaz_GUI.setLayout(null); //desactivamos el layout

    }
    
    //Definicion de colores
    @Override
    public void set_colors(){
        this.interfaz_GUI.setBackground(new Color(171, 171, 171));
        this.automata.setBackground(Color.blue);
    }
    /*Definicion de coordenadas y tamaño*/
    @Override
    public void defBounds() {
        this.automata.setBounds(0, 0, 900, 800);
        this.interfaz_GUI.setBounds(900, 0, 400, 800);
        //this.padNumeric.setBounds(900,400, 400, 800);
    }

    /*Agregar componentes al panel*/
    @Override
    public void addContent() {
        this.getContentPane().add(this.automata);
        this.getContentPane().add(this.interfaz_GUI);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ExamenFinal().setVisible(true);
        });
    }
}

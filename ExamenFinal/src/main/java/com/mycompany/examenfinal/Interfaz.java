/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinal;

import javax.swing.JPanel;

/**
 *
 * @author blazar
 */
public final class Interfaz extends JPanel implements MetodosComunes {

    /**
     * Objeto que representa la parte de la máquina de un cajero automático: la
     * pantalla y los botones al lado;
     */
    private Maquina maquina;
    /**
     * Objeto que representa el conetenido del pad numerico, dígitos, boton de
     * BORRAR, ACEPTAR y de CANCELAR
     */
    private PadNumeric padNumeric;
    
    //private Automata automata;
    
    private EventClickPadNumeric clic;

    /**
     * Inicializa todos los componente de la clase.
     *
     * @param maquina Recibe un objeto de tipo Máquina
     * @param pad Recibe un objeto de tipo PadNumeric
     * @param automata
     */
    public Interfaz(Maquina maquina, PadNumeric pad, Automata automata) {
        this.setLayout(null);
        this.maquina = maquina;
        this.padNumeric = pad;
        this.clic = new EventClickPadNumeric(this.padNumeric, this.maquina, automata);
        //this.clic.toActiveClicks();
        this.defBounds();
        this.addContent();
    }

    @Override
    public void instanceObj() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void defBounds() {
        this.maquina.setBounds(10, 10, 365, 200);
        this.padNumeric.setBounds(10, 220, 365, 240);
    }

    @Override
    public void addContent() {
        this.add(this.maquina);
        this.add(this.padNumeric);
    }

    @Override
    public void set_colors() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

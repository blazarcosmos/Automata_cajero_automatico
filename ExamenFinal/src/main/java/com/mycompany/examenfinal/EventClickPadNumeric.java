/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase define el comportamiento de evento de clic de los botones de la
 * clase PadNumeric
 *
 * @author blazar
 */
public final class EventClickPadNumeric implements MetodosComunes {

    final int RETIRAR = 0;
    final int CONSULTAR = 1;
    final int DEPOSITAR = 2;
    final int INPUT_NIP = 3;
    final int INPUT_CARD = 4;
    private int opcion;

    private final PadNumeric padNumeric;
    private final Maquina maquina;
    /**
     * Variable de propósito general
     */
    private int varGeneral;
    /**
     * Posiciones para cada -q- nodo
     */
    int[][] q;

    /**
     * arreglo de objetos de eventos de clic para button
     */
    private ActionListener[] listener_btn_numeric;
    private ActionListener listenerRetirar;
    private ActionListener listenerConsultar;
    private ActionListener listenerDepositar;

    private ActionListener listenerAceptar;
    private ActionListener listenerBorrar;
    private ActionListener listenerCancelar;
    private ActionListener listenerIngresarTarjeta;
    private ActionListener listenerMenu;
    private final Automata automata;

    public EventClickPadNumeric(PadNumeric padNumeric, Maquina maquina, Automata automata) {
        //this.estado = states.inicio_fin;
        this.padNumeric = padNumeric;
        this.maquina = maquina;
        this.varGeneral = 0;
        this.automata = automata;

        this.opcion = this.INPUT_CARD;
        this.q = new int[][]{
            {413, 49}, //q0
            {413, 196}, //q1
            {413, 370}, //q2
            {286, 196}, //q3
            {413, 505}, //q4
            {253, 505}, //q5
            {561, 505} //q6
        };
        this.automata.set_q(q[0]);
        this.instanceObj();
        this.toActiveClicks();
    }

    /**
     * Activa los eventos del clic.
     */
    public void toActiveClicks() {

        //añadimos los eventos de clic a los botones numericos
        this.padNumeric.numeros[0].addActionListener(this.listener_btn_numeric[0]);
        this.padNumeric.numeros[1].addActionListener(this.listener_btn_numeric[1]);
        this.padNumeric.numeros[2].addActionListener(this.listener_btn_numeric[2]);
        this.padNumeric.numeros[3].addActionListener(this.listener_btn_numeric[3]);
        this.padNumeric.numeros[4].addActionListener(this.listener_btn_numeric[4]);
        this.padNumeric.numeros[5].addActionListener(this.listener_btn_numeric[5]);
        this.padNumeric.numeros[6].addActionListener(this.listener_btn_numeric[6]);
        this.padNumeric.numeros[7].addActionListener(this.listener_btn_numeric[7]);
        this.padNumeric.numeros[8].addActionListener(this.listener_btn_numeric[8]);
        this.padNumeric.numeros[9].addActionListener(this.listener_btn_numeric[9]);

        //añadimos los eventos de clic a los botones de la Maquina
        this.maquina.retirar.addActionListener(listenerRetirar);
        this.maquina.consultar.addActionListener(listenerConsultar);
        this.maquina.depositar.addActionListener(listenerDepositar);
        this.padNumeric.aceptar.addActionListener(listenerAceptar);
        this.padNumeric.borrar.addActionListener(listenerBorrar);
        this.padNumeric.cancelar.addActionListener(listenerCancelar);
        this.padNumeric.ingresar_tarjeta.addActionListener(this.listenerIngresarTarjeta);

        this.maquina.menu.addActionListener(listenerMenu);
    }

    /**
     * Desactiva los eventos de clic
     */
    public void toDesactiveClicks() {
        this.padNumeric.numeros[0].removeActionListener(this.listener_btn_numeric[0]);
        this.padNumeric.numeros[1].removeActionListener(this.listener_btn_numeric[1]);
        this.padNumeric.numeros[2].removeActionListener(this.listener_btn_numeric[2]);
        this.padNumeric.numeros[3].removeActionListener(this.listener_btn_numeric[3]);
        this.padNumeric.numeros[4].removeActionListener(this.listener_btn_numeric[4]);
        this.padNumeric.numeros[5].removeActionListener(this.listener_btn_numeric[5]);
        this.padNumeric.numeros[6].removeActionListener(this.listener_btn_numeric[6]);
        this.padNumeric.numeros[7].removeActionListener(this.listener_btn_numeric[7]);
        this.padNumeric.numeros[8].removeActionListener(this.listener_btn_numeric[8]);
        this.padNumeric.numeros[9].removeActionListener(this.listener_btn_numeric[9]);

    }

    @Override
    public void instanceObj() {
        this.listener_btn_numeric = new ActionListener[10];

        //definimos el comportamiento de los clics a los botones numericos
        this.listener_btn_numeric[0] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "0";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "0";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "0";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };

        this.listener_btn_numeric[1] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "1";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "1";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "1";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };
        this.listener_btn_numeric[2] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "2";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "2";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "2";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };
        this.listener_btn_numeric[3] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "3";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "3";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "3";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            };
        };
        this.listener_btn_numeric[4] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "4";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "4";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "4";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };
        this.listener_btn_numeric[5] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "5";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "5";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "5";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };
        this.listener_btn_numeric[6] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "6";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "6";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "6";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };
        this.listener_btn_numeric[7] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "7";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "7";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "7";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };
        this.listener_btn_numeric[8] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "8";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "8";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "8";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };
        this.listener_btn_numeric[9] = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.length() < 4) {
                        maquina.nip += "9";
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case RETIRAR -> {
                    if (maquina.cantidad.length() < 4) {
                        maquina.cantidad += "9";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + maquina.cantidad);
                    }
                }
                case DEPOSITAR -> {
                    if (maquina.cantidad.length() < 5) {
                        maquina.cantidad += "9";
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + maquina.cantidad);
                    }
                }
            }
        };

        //Definimos eventos de los botones de la Maquina
        this.listenerRetirar = (ActionEvent e) -> {
            this.opcion = this.RETIRAR;
            this.automata.set_q(q[4]);
            this.automata.repaint();
            this.maquina.retirar.setEnabled(false);
            this.maquina.consultar.setEnabled(false);
            this.maquina.depositar.setEnabled(false);

            for (var i = 0; i <= 9; i++) {
                this.padNumeric.numeros[i].setEnabled(true);
            }
            this.maquina.menu.setEnabled(true);
            this.padNumeric.cancelar.setEnabled(true);
            this.padNumeric.aceptar.setEnabled(true);
            this.padNumeric.borrar.setEnabled(true);
            this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar);
        };
        this.listenerConsultar = (ActionEvent e) -> {
            this.opcion = this.CONSULTAR;
            this.automata.set_q(q[3]);
            this.automata.repaint();
            this.maquina.depositar.setEnabled(false);
            this.maquina.retirar.setEnabled(false);
            this.maquina.consultar.setEnabled(false);
            this.maquina.menu.setEnabled(true);
            this.padNumeric.cancelar.setEnabled(true);
            this.maquina.msj.setText("<html>Su saldo actual es: $" + Double.toString(this.maquina.saldo)
                    + "<br><br>Presione Cancelar si desea <br>terminar su operación.<html>");
            //this.opcion = -1;

        };
        this.listenerDepositar = (ActionEvent e) -> {
            this.opcion = this.DEPOSITAR;
            this.automata.set_q(q[4]);
            this.automata.repaint();
            this.maquina.depositar.setEnabled(false);
            this.maquina.consultar.setEnabled(false);
            this.maquina.retirar.setEnabled(false);
            this.maquina.menu.setEnabled(true);
            this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + this.maquina.cantidad);

            this.padNumeric.aceptar.setEnabled(true);
            this.padNumeric.borrar.setEnabled(true);
            this.padNumeric.cancelar.setEnabled(true);
            for (var i = 0; i <= 9; i++) {
                this.padNumeric.numeros[i].setEnabled(true);
            }
        };

        this.listenerMenu = (ActionEvent e) -> {
            this.automata.set_q(q[2]);
            this.automata.repaint();
            this.opcion = -1;
            System.out.println("La opcion actual es: " + this.opcion);
            this.maquina.nip = "";
            this.maquina.cantidad = "";
            this.maquina.menu.setEnabled(false);
            this.maquina.consultar.setEnabled(true);
            this.maquina.retirar.setEnabled(true);
            this.maquina.depositar.setEnabled(true);
            this.maquina.msj.setText("<html>Seleccione la operación<br>que desea realizar.<html>");
        };

        //defnimos los eventos de clic del boton ACEPTAR
        this.listenerAceptar = (ActionEvent e) -> {
            switch (opcion) {
                case INPUT_NIP -> {
                    if (maquina.nip.equals(this.maquina.nipValido)) {
                        this.padNumeric.cancelar.setEnabled(true);
                        this.automata.set_q(q[2]);
                        this.automata.repaint();
                        this.maquina.nip = "";
                        this.maquina.msj.setText("<html>Seleccione la operación<br>que desea realizar<html>");
                        this.maquina.retirar.setEnabled(true);
                        this.maquina.consultar.setEnabled(true);
                        this.maquina.depositar.setEnabled(true);

                        this.maquina.menu.setEnabled(false);

                        for (var i = 0; i <= 9; i++) {
                            this.padNumeric.numeros[i].setEnabled(false);
                        }
                        this.padNumeric.aceptar.setEnabled(false);
                        this.padNumeric.borrar.setEnabled(false);
                        this.padNumeric.cancelar.setEnabled(false);

                    } else {

                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip + "<br><br>  "
                                + this.maquina.msjNipIncorrecto);
                        try {
                            // Esperar 2 segundos
                            this.automata.quit();
                            this.automata.repaint();
                            Thread.sleep(250); // 2000 milisegundos = 2 segundos
                            this.automata.set_q(q[5]);
                            this.automata.repaint();

                            // Aquí puedes colocar cualquier otro código que desees ejecutar después de esperar 2 segundos
                        } catch (InterruptedException ee) {
                            // Manejo de excepciones
                        }
                    }
                }
                case RETIRAR -> {
                    double cantidad = Double.parseDouble(this.maquina.cantidad);

                    if (cantidad % 50 != 0) {
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + this.maquina.cantidad
                                + "<br><br>Sólo se acepta múltiplos de 50.");
                    } else if (cantidad > this.maquina.saldo) {
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + this.maquina.cantidad
                                + "<br><br>Saldo insuficiente.");
                    } else {
                        //this.maquina.retirar.setEnabled(false);
                        //this.maquina.con
                        this.maquina.saldo -= cantidad;
                        this.maquina.cantidad = "";
                        this.opcion = -1;
                        this.maquina.msj.setText("¡Dinero retirado con éxito!");
                        this.automata.set_q(q[5]);
                        this.automata.repaint();
                    }

                }
                case DEPOSITAR -> {
                    double cantidad = Double.parseDouble(this.maquina.cantidad);
                    if (cantidad > 10000) {
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar
                                + this.maquina.cantidad + "<br><br>No puede depositar más de $10000");
                    }
                    if (cantidad > 0 && cantidad <= 10000) {
                        this.maquina.saldo += cantidad;
                        this.automata.set_q(q[6]);
                        this.automata.repaint();
                        this.maquina.msj.setText("<html>¡Dinero depositado con éxito!<br><br>Presione Cancelar si <br>desea terminar la operación.<html>");
                        this.maquina.menu.setEnabled(true);
                        this.padNumeric.cancelar.setEnabled(true);
                        this.padNumeric.aceptar.setEnabled(false);
                        this.padNumeric.borrar.setEnabled(false);
                        this.maquina.cantidad = "";

                    }
                }
            }
        };
        //defnimos los eventos de clic del boton BOrrar
        this.listenerBorrar = (ActionEvent e) -> {

            switch (opcion) {
                case RETIRAR -> {
                    if (!this.maquina.cantidad.isEmpty()) { // Verificar que la cadena no esté vacía
                        this.maquina.cantidad = this.maquina.cantidad.substring(0, this.maquina.cantidad.length() - 1); // Eliminar el último carácter
                        this.maquina.msj.setText(this.maquina.msjInputCantidadRetirar + this.maquina.cantidad);
                    }
                }
                case INPUT_NIP -> {
                    if (!this.maquina.nip.isEmpty()) { // Verificar que la cadena no esté vacía
                        this.maquina.nip = this.maquina.nip.substring(0, this.maquina.nip.length() - 1); // Eliminar el último carácter
                        this.maquina.msj.setText(this.maquina.msjInputNIP + this.maquina.nip);
                    }
                }
                case DEPOSITAR -> {
                    if (!this.maquina.cantidad.isEmpty()) { // Verificar que la cadena no esté vacía
                        this.maquina.cantidad = this.maquina.cantidad.substring(0, this.maquina.cantidad.length() - 1); // Eliminar el último carácter
                        this.maquina.msj.setText(this.maquina.msjInputCantidadDepositar + this.maquina.cantidad);
                    }
                }
            }
        };
        this.listenerCancelar = (ActionEvent e) -> {
            this.automata.set_q(q[0]);
            this.automata.repaint();
            this.opcion = this.INPUT_CARD;
            this.maquina.msj.setText(this.maquina.msjInputCard);
            this.maquina.msj.repaint();
            this.padNumeric.ingresar_tarjeta.setEnabled(true);

            this.maquina.menu.setEnabled(false);
            this.maquina.cantidad = "";
            this.maquina.nip = "";
            for (var i = 0; i <= 9; i++) {
                this.padNumeric.numeros[i].setEnabled(false);
            }
            this.padNumeric.aceptar.setEnabled(false);
            this.padNumeric.borrar.setEnabled(false);
            this.padNumeric.cancelar.setEnabled(false);
            this.maquina.depositar.setEnabled(false);
            this.maquina.retirar.setEnabled(true);
            this.maquina.consultar.setEnabled(false);
            this.maquina.retirar.setEnabled(false);
        };
        this.listenerIngresarTarjeta = (ActionEvent e) -> {
            if (this.opcion == this.INPUT_CARD) {
                this.automata.set_q(q[1]);
                this.automata.repaint();
                System.out.println("hola mundo");
                this.opcion = this.INPUT_NIP;
                this.maquina.msj.setText(this.maquina.msjInputNIP);
                this.maquina.msj.repaint();
                System.out.println("Valor de OPCION: " + this.opcion);

                this.padNumeric.ingresar_tarjeta.setEnabled(false);
                //habilitar clics del pad numerico
                for (var i = 0; i <= 9; i++) {
                    this.padNumeric.numeros[i].setEnabled(true);
                }
                this.padNumeric.aceptar.setEnabled(true);
                this.padNumeric.borrar.setEnabled(true);
                this.padNumeric.cancelar.setEnabled(true);
            }
        };
    }

    @Override
    public void defBounds() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addContent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void set_colors() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

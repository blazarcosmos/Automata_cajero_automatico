/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * one piece.
 * @author blazar
 */
public class Automata extends JPanel {

    /**
     * Arreglo de posiciones para cada nodo del autómata
     */
    private int qx, qy;

    /**
     * hola mundo
     */
    private int w, h;

    private BufferedImage qn;
    private BufferedImage qn_color;
    private BufferedImage fondo;

    public Automata() {
        this.qx = 413;
        this.qy = 49;
        
        try {
            this.fondo = ImageIO.read(new File("C:\\Users\\blazar\\Documents\\NetBeansProjects\\ExamenFinal\\img\\fondo.png"));
            this.qn_color = ImageIO.read(new File("C:\\Users\\blazar\\Documents\\NetBeansProjects\\ExamenFinal\\img\\qn.png"));
            this.qn = ImageIO.read(new File("C:\\Users\\blazar\\Documents\\NetBeansProjects\\ExamenFinal\\img\\automata1.png"));
        } catch (IOException e) {

        }
    }
    public void set_q(int[] arg){
        this.qx = arg[0];
        this.qy = arg[1];
        this.w = this.qn_color.getWidth();
        this.h = this.qn_color.getHeight();
    }
    public void quit(){
        this.w = 0;
        this.h = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {

        if (fondo != null) {
            g.drawImage(fondo, 0, 0, fondo.getWidth() + 100, fondo.getHeight(), this);
        }
        if (qn_color != null) {
            g.drawImage(qn_color, this.qx, this.qy, this.w, this.h, this);
        }
        if (qn != null) {
            g.drawImage(qn, 250, 50, qn.getWidth(), qn.getHeight(), this);

        }
    }
}

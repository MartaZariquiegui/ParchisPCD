/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchispcd;

import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author martazariquiegui
 */
public class HiloJuego implements Runnable{
    
    private Socket socket;
    private Jugador jugador;
    private Ficha ficha;
    private Dado dados;

    public HiloJuego(Socket socket, Jugador jugador, Ficha ficha, Dado dados){
        this.socket = socket;
        this.jugador = jugador;
        this.dados = dados;
    }
    
    @Override
    public void run() {
        
        for (PrintWriter writer : Servidor.getWriters()) {
            writer.println("Es el turno de " + jugador.getNombre());
        }
        int tirada = dados.tirada();
        for (PrintWriter writer : Servidor.getWriters()) {
            writer.println(jugador.getNombre() + " ha sacado " + tirada);
        }
    }
    
}


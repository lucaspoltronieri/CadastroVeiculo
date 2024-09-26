/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.teste;

/**
 *
 * @author Lucas
 */
public class VeicExistException extends Exception {

    public VeicExistException() {
        System.out.println("\nJá existe um veículo com essa placa\n");

    }

}

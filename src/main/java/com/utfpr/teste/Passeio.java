/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.teste;

/**
 *
 * @author Usuario
 */
public class Passeio extends Veiculo {

    private int qtdPassageiros;

    public Passeio() {

        this.qtdPassageiros = 0;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    float calcVel(float VelocMax) {
        return VelocMax * 1000;
    }

    @Override
    public String toString() {
        return "Veículo de passeio :\n"
                + "Placa.................:" + getPlaca() + "\n"
                + "Marca.................:" + getMarca() + "\n"
                + "Modelo................:" + getModelo() + "\n"
                + "Potencia..............:" + getMotor().getPotencia() + "\n"
                + "Pistão................:" + getMotor().getQtdPist() + "\n"
                + "Cor...................:" + getCor() + "\n"
                + "Velocidade máxima.....:" + getVelocMax() + "\n"
                + "Quantidade rodas......:" + getQtdRodas() + "\n"
                + "Quantidade passageiros:" + getQtdPassageiros() + "\n";
    }

}

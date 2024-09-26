/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.teste;

/**
 *
 * @author Usuario
 */
public class Carga extends Veiculo{
    
    private int cargaMax;
    private int tara;
    
    public Carga(){
        this.cargaMax = 0;
        this.tara = 0;
    }    

    public int getCargaMax() {
        return cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    float calcVel(float VelocMax) {
        return VelocMax * 100000;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.teste;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class DBVeiculos {
    
    private List<Passeio> DBPasseio;
    private List<Carga> DBCarga;
    
    public DBVeiculos(){
        
        DBPasseio = new ArrayList<>();
        DBCarga = new ArrayList<>();
    }

    public List<Passeio> getDBPasseio() {
        return DBPasseio;
    }

    public List<Carga> getDBCarga() {
        return DBCarga;
    }

    public void setDBPasseio(List<Passeio> DBPasseio) {
        this.DBPasseio = DBPasseio;
    }

    public void setDBCarga(List<Carga> DBCarga) {
        this.DBCarga = DBCarga;
    }
    
    public void setDBPasseio(Passeio passeio) throws VeicExistException{
        if(!existePlacaPasseio(passeio)){
            DBPasseio.add(passeio);
        } else {
            throw new VeicExistException();
        }
    }
    
    public void setDBCarga(Carga carga) throws VeicExistException{
        if(!existePlacaCarga(carga)){
            DBCarga.add(carga);
        } else {
            throw new VeicExistException();
        }
    }
    
    public boolean existePlacaPasseio(Passeio passeio){
        for(Passeio p: DBPasseio){
            if(p.getPlaca().equals(passeio.getPlaca())){
                return true;
            }
        }
        return false;        
    }
    
    public boolean existePlacaCarga(Carga carga){
        for(Carga c: DBCarga){
            if(c.getPlaca().equals(carga.getPlaca())){
                return true;
            }
        }
        return false;
    }
    
    public void excluirVeiculoPasseioPlaca(String placa) { 
        boolean veiculoEncontrado = false;
        for(Passeio p: getDBPasseio()){
            if(p.getPlaca().equalsIgnoreCase(placa)){
                DBPasseio.remove(p);
                veiculoEncontrado = true;
                break;
            }
        }
        if(!veiculoEncontrado){
            System.out.println("Não existe veiculo com essa placa");
        }
    }
    
    public void excluirVeiculoCargaPlaca(String placa){
        for(int i=0; i < DBCarga.size(); i++){
            if(DBCarga.get(i).getPlaca().equalsIgnoreCase(placa)){
                DBCarga.remove(i);
            }
            else
            {
                System.out.println("Veículo não existe!");
            }
        }
    }
    
}

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

    public DBVeiculos() {

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

    public void setDBPasseio(Passeio passeio) throws VeicExistException {
        if (getDBPasseio().stream().anyMatch(p -> p.getPlaca().equals(passeio.getPlaca()))) {
            throw new VeicExistException();
        }
        DBPasseio.add(passeio);
    }

    public void setDBCarga(Carga carga) throws VeicExistException {
        if (getDBCarga().stream().anyMatch(c -> c.getPlaca().equals(carga.getPlaca()))) {
            throw new VeicExistException();
        }
        DBCarga.add(carga);
    }

    public void imprimirTodosVeiculosPasseio() {
        if (getDBPasseio().isEmpty()) {
            System.out.println("Não existe veículo cadastrado para exibir");
        } else {
            getDBPasseio().forEach(System.out::println);
        }
    }

    public void imprimirTodosVeiculosCarga() {
        if (getDBCarga().isEmpty()) {
            System.out.println("Não existe veículo cadastrado para exibir");
        } else {
            getDBCarga().forEach(System.out::println);
        }
    }

    public void imprimirVeiculoPasseioPlaca(String placa) {
        getDBPasseio().stream()
                .filter(p -> p.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .ifPresentOrElse(
                        p -> System.out.println(p),
                        () -> System.out.println("Não existe veiculo com essa placa")
                );

    }

    public void imprimirVeiculoCargaPlaca(String placa) {
        getDBCarga().stream()
                .filter(c -> c.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .ifPresentOrElse(
                        c -> System.out.println("p"),
                        () -> System.out.println("Não existe veículo com essa placa")
                );

    }

    public void excluirVeiculoPasseioPlaca(String placa) {
        boolean removerVeiculo = DBPasseio.removeIf(p -> p.getPlaca().equalsIgnoreCase(placa));
        if (removerVeiculo) {
            System.out.println("Veículo excluído com sucesso");
        } else {
            System.out.println("Não existe veículo com essa placa");
        }
    }

    public void excluirVeiculoCargaPlaca(String placa) {
        boolean removerVeiculo = DBCarga.removeIf(p -> p.getPlaca().equalsIgnoreCase(placa));
        if (removerVeiculo) {
            System.out.println("Veículo excluído com sucesso");
        } else {
            System.out.println("Não existe veículo com essa placa");
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.teste;

/**
 *
 * @author Lucas
 */
public class CadastroVeiculo {

    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();
    private static final Leitura l = new Leitura();
    private static final DBVeiculos dbveiculos = new DBVeiculos();

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.println("Sistema de Gestão de Veículos - Menu Inicial");
            System.out.println("(1) - Cadastrar Veículo de Passeio");
            System.out.println("(2) - Cadastrar Veículo de Carga");
            System.out.println("(3) - Imprimir Todos os Veículos de Passeio");
            System.out.println("(4) - Imprimir Todos os Veículos de Carga");
            System.out.println("(5) - Imprimir Veículo de Passeio pela Placa");
            System.out.println("(6) - Imprimir Veículo de Carga pela Placa");
            System.out.println("(7) - (EXCLUIR) Veículo de Passeio pela Placa");
            System.out.println("(8) - (EXCLUIR) Veículo de Carga pela Placa");
            System.out.println("(9) - Sair do Sistema");

            opcao = Integer.parseInt(l.entDados("Escolha uma opção"));

            switch (opcao) {
                case 1 ->
                    cadastrarVeiculoPasseio();
                case 2 ->
                    cadastrarVeiculoCarga();
                case 3 -> {
                    dbveiculos.imprimirTodosVeiculosPasseio();
                    l.entDados("Enter para continuar:");
                }
                case 4 -> {
                    dbveiculos.imprimirTodosVeiculosCarga();
                    l.entDados("Enter para continuar:");
                }
                case 5 -> {
                    String placa = l.entDados("Entre com a placa:");
                    dbveiculos.imprimirVeiculoPasseioPlaca(placa);
                }
                case 6 -> {
                    String placa = l.entDados("Entre com a placa:");
                    dbveiculos.imprimirVeiculoCargaPlaca(placa);
                }
                case 7 -> {
                    String placa = l.entDados("Entre com a placa:");
                    dbveiculos.excluirVeiculoPasseioPlaca(placa);
                }
                case 8 -> {
                    String placa = l.entDados("Entre com a placa:");
                    dbveiculos.excluirVeiculoCargaPlaca(placa);
                }
                case 9 ->
                    System.out.println("Saindo do sistema...");
                default ->
                    System.out.println("Escolha uma opção entre 1 a 7");
            }
        } while (opcao != 9);
    }

    public static void cadastrarVeiculoPasseio() {
        boolean continuar = true;

        while (continuar) {

            passeio = new Passeio();
            passeio.setPlaca(l.entDados("Placa............:"));
            try {
                dbveiculos.setDBPasseio(passeio);
            } catch (VeicExistException ex) {
            }

            String opcao = l.entDados("Deseja Cadastrar outro veículo S/N");
            if (opcao.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
    }

    public static void cadastrarVeiculoCarga() {
        boolean continuar = true;

        while (continuar) {

            carga = new Carga();
            carga.setPlaca(l.entDados("Placa.................: "));
            try {
                dbveiculos.setDBCarga(carga);
            } catch (VeicExistException ex) {
            }

            String opcao = l.entDados("Deseja cadastrar outro veículo S/N");
            if (opcao.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
    }
}

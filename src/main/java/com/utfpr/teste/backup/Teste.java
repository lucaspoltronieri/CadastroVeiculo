/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.utfpr.teste.backup;

import com.utfpr.teste.Carga;
import com.utfpr.teste.Leitura;
import com.utfpr.teste.Passeio;

/**
 *
 * @author Usuario
 */
public class Teste {
    
    private static Passeio passeio = new Passeio();
    private static Passeio vetPasseio[] = new Passeio[5];
    private static Carga carga = new Carga();
    private static Carga vetCarga[] = new Carga[5];
    private static Leitura l = new Leitura();
    

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
            System.out.println("(7) - Sair do Sistema");

            opcao = Integer.parseInt(l.entDados("Escolha uma opção"));

            switch(opcao) {
                case 1 -> cadastrarVeiculoPasseio();
                case 2 -> cadastrarVeiculoCarga();
                case 3 -> imprimirTodosVeiculosPasseio();
                case 4 -> imprimirTodosVeiculosCarga();
                case 5 -> imprimirVeiculoPasseioPlaca();
                case 6 -> imprimirVeiculoCargaPlaca();
                case 7 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Escolha uma opção entre 1 a 7");
            }
        } while (opcao != 7);
    }    
    
    public static void cadastrarVeiculoPasseio(){
        boolean continuar = true;
        
        while(continuar){
            
            boolean vetorCheio = true;
            
            //verifica se há espaço no vetor
            for (int i = 0; i < vetPasseio.length; i++){
                if(vetPasseio[i] == null){
                    vetorCheio = false;
                    break;
                }
            }
            
            if(vetorCheio){
                System.out.println("Vetor Cheio");
                return;
            }
            
            passeio = new Passeio();
            passeio.setPlaca(l.entDados("Placa............:"));
            
            //adiciona veiculo vetor
            for (int i = 0; i < vetPasseio.length; i++){
                if(vetPasseio[i] == null){
                    vetPasseio[i] = passeio;
                    break;
                }
            }
            String opcao = l.entDados("Deseja Cadastrar outro veículo S/N");
            if(opcao.equalsIgnoreCase("n")){
                continuar = false;
            }           
        }
    }
    
    public static void cadastrarVeiculoCarga(){
        boolean continuar = true;
        
        while(continuar){
            boolean vetorCheio = true;
            
            for(int i = 0; i < vetCarga.length; i++){
                if(vetCarga[i] == null){
                    vetorCheio = false;
                    break;
                }
            }
            
            if(vetorCheio){
                System.out.println("Vetor Cheio");
                return;
            }
            
            carga = new Carga();
            carga.setPlaca(l.entDados("Placa.................: "));
            
            for(int i = 0; i < vetCarga.length; i++){
                if(vetCarga[i] == null){
                    vetCarga[i] = carga;
                    break;
                }
            }
            String opcao = l.entDados("Deseja cadastrar outro veículo S/N");
            if(opcao.equalsIgnoreCase("n")){
                continuar = false;
            }
        }
    }
    public static void imprimirTodosVeiculosPasseio(){
        for(Passeio p: vetPasseio){
            if( p != null){
                System.out.println(passeio.getPlaca());
                
            }
            else{
                System.out.println("Nâo existe veiculo cadastrado");
                l.entDados("Press Enter para retornar ao menu");
                return;
            }
        }
        
    }
    public static void imprimirTodosVeiculosCarga(){
        for(Carga c: vetCarga){
            if(c !=null){
                System.out.println(carga.getPlaca());
                l.entDados("Press-ENTER-Continuar");
                return;
            }
            else {
                System.out.println("Não existe veículo cadastrado");
                l.entDados("Press-ENTER-Continuar");
                return;
            }
        }
    }
    public static void imprimirVeiculoPasseioPlaca(){
        String placa = l.entDados("Informe a placa:");
        for(int i = 0; i < vetPasseio.length; i++){
            if(vetPasseio[i] !=null && vetPasseio[i].getPlaca().equalsIgnoreCase(placa)){
                System.out.println(vetPasseio[i].getPlaca());
                l.entDados("Press-Enter-Continuar");
                return;
            }
            else{
                System.out.println("Não encontrado");                
                l.entDados("Press-Enter-Continuar");
                return;
            }
        }
    }
    public static void imprimirVeiculoCargaPlaca(){
        String placa = l.entDados("Informe a placa:");
        for(Carga c: vetCarga){
            if(c !=null && c.getPlaca().equalsIgnoreCase(placa)){
                System.out.println(c.getPlaca());
                l.entDados("Press-Enter-Continuar");
                return;
            }
            else{
                System.out.println("Não encontrado");
                l.entDados("Press-Enter-Continuar");
                return;
            }
        }
    }
}

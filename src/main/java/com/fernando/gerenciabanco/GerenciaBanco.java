/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fernando.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author ferna
 */
public class GerenciaBanco {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Gerenciamento Bancário!");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobreNome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
         Conta conta = new Conta(nome, sobreNome, cpf);

        do {
            exibirMenu();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Seu saldo é de: " + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    Double valorDeposito = scanner.nextDouble();
                    conta.realizarDeposito(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    Double valorSaque = scanner.nextDouble();
                    conta.realizarSaque(valorSaque);
                    break;
                case 4:
                    System.out.println("Obrigado por usar o Gerenciamento Bancário. Adeus!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);

    }
    
    public static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Realizar Depósito");
        System.out.println("3. Realizar Saque");
        System.out.println("4. Encerrar");
        System.out.print("Digite o número da opção: ");
    }
}
class Conta{
    
    private String nome;
    private String sobreNome;
    private String cpf;
    private Double saldo;
    
    public Conta(String nome, String sobreNome, String cpf) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }
    
     public Double consultarSaldo() {
        return saldo;
     }

    public void realizarDeposito(Double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void realizarSaque(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

 

  
    
   
}   
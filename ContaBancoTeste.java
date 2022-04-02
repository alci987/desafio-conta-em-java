package br.com.banco;

import java.util.Scanner;

public class ContaBancoTeste {
    
    public static void main(String[] args) {
        ContaBanco c1 = new ContaBanco();
        c1.setNumConta(111);
        c1.abrirConta("CC");
        c1.setDono("Alciliano da Silva Lima");
        c1.depositar(80);


        ContaBanco c2 = new ContaBanco();
        c2.setNumConta(222);
        c2.abrirConta("CP");
        c2.setDono("Ana Mirian da Silva");
        c2.sacar(50.0f);

        c1.estdoAtual();
        c2.estdoAtual();
        
    }
}

package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {

    public static void main(String[] args) {

        // Instancia a interface de usuário
        InterfaceUsuario ui = new InterfaceUsuario();

        System.out.println("======= Sistema de Financiamento Imobiliário =======");

        // Coleta os dados do financiamento com validação
        double valorImovel       = ui.pedirValorImovel();
        int prazoFinanciamento   = ui.pedirPrazoFinanciamento();
        double taxaJurosAnual    = ui.pedirTaxaJuros();

        // Cria o objeto Financiamento com os dados coletados
        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

        // Exibe os dados e resultados usando o método da classe
        financiamento.exibirDadosFinanciamento();
    }
}
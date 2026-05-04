package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import modelo.Terreno.TipoZona;
import util.GerenciadorArquivos;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        InterfaceUsuario ui = new InterfaceUsuario();

        //  Financiamento 1: Casa (dados do usuario)
        System.out.println("======= Sistema de Financiamento Imobiliário =======");
        System.out.println("\n[Financiamento 1 - Casa] Informe os dados:");
        financiamentos.add(new Casa(
                ui.pedirValorImovel(),
                ui.pedirPrazoFinanciamento(),
                ui.pedirTaxaJuros(),
                ui.pedirAreaTerreno(),
                ui.pedirAreaConstruida()
        ));

        //  Financiamentos fixos no código
        financiamentos.add(new Casa       (350_000.0, 15, 0.09, 200.0, 140.0));
        financiamentos.add(new Apartamento(500_000.0, 10, 0.10, 2, 8));
        financiamentos.add(new Apartamento(280_000.0, 20, 0.08, 1, 3));
        financiamentos.add(new Terreno    (120_000.0,  8, 0.11, TipoZona.COMERCIAL));

        //  Exibir todos os financiamentos
        for (Financiamento f : financiamentos) {
            f.exibirDadosFinanciamento();
        }

        //  Totalizadores
        double somaValorImoveis        = 0;
        double somaTotalFinanciamentos = 0;
        for (Financiamento f : financiamentos) {
            somaValorImoveis        += f.getValorImovel();
            somaTotalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\n============== Resumo Geral ==============");
        System.out.printf("Soma dos valores dos imóveis:   R$ %,.2f%n", somaValorImoveis);
        System.out.printf("Soma total dos financiamentos:  R$ %,.2f%n", somaTotalFinanciamentos);
        System.out.println("==========================================");

        // PERSISTÊNCIA — Arquivo de Texto
        GerenciadorArquivos.salvarEmTexto(financiamentos);
        GerenciadorArquivos.lerDeTexto();

        // PERSISTÊNCIA — Serialização
        GerenciadorArquivos.salvarSerializado(financiamentos);

        ArrayList<Financiamento> financiamentosRecuperados = GerenciadorArquivos.lerSerializado();

        System.out.println("\n[Serializado] Comprovação — exibindo dados recuperados:");
        for (Financiamento f : financiamentosRecuperados) {
            f.exibirDadosFinanciamento();
        }
    }
}
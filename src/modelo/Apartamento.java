package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private int vagasGaragem;
    private int andar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                       int vagasGaragem, int andar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.andar        = andar;
    }

    public int getVagasGaragem() { return vagasGaragem; }
    public int getAndar()        { return andar; }

    @Override
    public double calcularTotalPagamento() {
        return getValorImovel() * (1 + (getTaxaJurosAnual() * getPrazoFinanciamento()));
    }

    @Override
    public double calcularPagamentoMensal() {
        return calcularTotalPagamento() / (getPrazoFinanciamento() * 12);
    }

    @Override
    public String paraLinhaTexto() {
        return super.paraLinhaTexto()
                + String.format("|vagasGaragem=%d|andar=%d", vagasGaragem, andar);
    }

    @Override
    public void exibirDadosFinanciamento() {
        super.exibirDadosFinanciamento();
        System.out.printf("Andar:                  %dº%n",  andar);
        System.out.printf("Vagas de garagem:       %d%n",   vagasGaragem);
        System.out.println("=============================================");
    }
}
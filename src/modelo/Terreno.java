package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {

    private static final long   serialVersionUID = 1L;
    private static final double ACRESCIMO        = 1.02;

    public enum TipoZona { RESIDENCIAL, COMERCIAL, INDUSTRIAL, RURAL }

    private TipoZona tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                   TipoZona tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public TipoZona getTipoZona() { return tipoZona; }

    @Override
    public double calcularPagamentoMensal() {
        int    meses      = getPrazoFinanciamento() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12;
        return (getValorImovel() / meses) * (1 + taxaMensal) * ACRESCIMO;
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    @Override
    public String paraLinhaTexto() {
        return super.paraLinhaTexto()
                + String.format("|tipoZona=%s", tipoZona);
    }

    @Override
    public void exibirDadosFinanciamento() {
        super.exibirDadosFinanciamento();
        System.out.printf("Tipo de zona:           %s%n",   tipoZona);
        System.out.printf("Acréscimo de risco:     %.0f%%%n", (ACRESCIMO - 1) * 100);
        System.out.println("=============================================");
    }
}
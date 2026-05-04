package modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {

    private static final long   serialVersionUID = 1L;
    private static final double SEGURO_MENSAL    = 240.0;

    private double areaTerreno;
    private double areaConstruida;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                double areaTerreno, double areaConstruida) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaTerreno    = areaTerreno;
        this.areaConstruida = areaConstruida;
    }

    public double getAreaTerreno()    { return areaTerreno; }
    public double getAreaConstruida() { return areaConstruida; }

    @Override
    public double calcularPagamentoMensal() {
        int    meses      = getPrazoFinanciamento() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12;
        return (getValorImovel() / meses) * (1 + taxaMensal) + SEGURO_MENSAL;
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    @Override
    public String paraLinhaTexto() {
        return super.paraLinhaTexto()
                + String.format("|areaTerreno=%.2f|areaConstruida=%.2f", areaTerreno, areaConstruida);
    }

    @Override
    public void exibirDadosFinanciamento() {
        super.exibirDadosFinanciamento();
        System.out.printf("Área do terreno:        %.2f m²%n", areaTerreno);
        System.out.printf("Área construída:        %.2f m²%n", areaConstruida);
        System.out.printf("Seguro mensal incluso:  R$ %,.2f%n", SEGURO_MENSAL);
        System.out.println("=============================================");
    }
}
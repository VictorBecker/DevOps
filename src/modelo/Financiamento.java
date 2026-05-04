package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private double valorImovel;
    private int    prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel        = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual     = taxaJurosAnual;
    }

    // Getters
    public double getValorImovel()        { return valorImovel; }
    public int    getPrazoFinanciamento() { return prazoFinanciamento; }
    public double getTaxaJurosAnual()     { return taxaJurosAnual; }

    // Métodos abstratos
    public abstract double calcularPagamentoMensal();
    public abstract double calcularTotalPagamento();

    // Linha formatada para arquivo de texto — cada subclasse estende com seus atributos
    public String paraLinhaTexto() {
        return String.format("%s|%.2f|%d|%.4f|%.2f|%.2f",
                getClass().getSimpleName(),
                valorImovel,
                prazoFinanciamento,
                taxaJurosAnual,
                calcularPagamentoMensal(),
                calcularTotalPagamento()
        );
    }

    // Exibição comum
    public void exibirDadosFinanciamento() {
        System.out.println("\n========== Dados do Financiamento ==========");
        System.out.printf("Tipo:                   %s%n",       getClass().getSimpleName());
        System.out.printf("Valor do imóvel:        R$ %,.2f%n", valorImovel);
        System.out.printf("Prazo:                  %d anos (%d meses)%n", prazoFinanciamento, prazoFinanciamento * 12);
        System.out.printf("Taxa de juros anual:    %.2f%%%n",   taxaJurosAnual * 100);
        System.out.printf("Pagamento mensal:       R$ %,.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do pagamento:     R$ %,.2f%n", calcularTotalPagamento());
    }
}
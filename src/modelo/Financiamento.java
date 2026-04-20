package modelo;

public class Financiamento {

    private double valorImovel;
    private int prazoFinanciamento; // em anos
    private double taxaJurosAnual;

    // Construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Calcula o pagamento mensal
    public double calcularPagamentoMensal() {
        int totalMeses = prazoFinanciamento * 12;
        double taxaMensal = taxaJurosAnual / 12;
        return (valorImovel / totalMeses) * (1 + taxaMensal);
    }

    // Calcula o total do pagamento
    public double calcularTotalPagamento() {
        int totalMeses = prazoFinanciamento * 12;
        return calcularPagamentoMensal() * totalMeses;
    }

    // Exibe os dados do financiamento na tela
    public void exibirDadosFinanciamento() {
        System.out.println("\n========== Dados do Financiamento ==========");
        System.out.printf("Valor do imóvel:        R$ %,.2f%n", valorImovel);
        System.out.printf("Prazo:                  %d anos (%d meses)%n", prazoFinanciamento, prazoFinanciamento * 12);
        System.out.printf("Taxa de juros anual:    %.2f%%%n", taxaJurosAnual * 100);
        System.out.printf("Pagamento mensal:       R$ %,.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do pagamento:     R$ %,.2f%n", calcularTotalPagamento());
        System.out.println("=============================================");
    }
}
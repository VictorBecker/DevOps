package util;

import java.util.Locale;
import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    // Pede ao usuário o valor do imóvel (somente valores positivos)
    public double pedirValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel (R$): ");
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("Erro: o valor do imóvel deve ser positivo. Tente novamente.");
                }
            } else {
                System.out.println("Erro: entrada inválida. Digite um número válido.");
                scanner.next(); // descarta entrada inválida
                valor = -1;    // força repetição do loop
            }
        } while (valor <= 0);

        return valor;
    }

    // Pede ao usuário o prazo do financiamento em anos (somente valores positivos)
    public int pedirPrazoFinanciamento() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            if (scanner.hasNextInt()) {
                prazo = scanner.nextInt();
                if (prazo <= 0) {
                    System.out.println("Erro: o prazo deve ser um número inteiro positivo. Tente novamente.");
                }
            } else {
                System.out.println("Erro: entrada inválida. Digite um número inteiro válido.");
                scanner.next(); // descarta entrada inválida
                prazo = -1;    // força repetição do loop
            }
        } while (prazo <= 0);

        return prazo;
    }

    // Pede ao usuário a taxa de juros anual (somente valores positivos)
    public double pedirTaxaJuros() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (ex: 0.12 para 12%): ");
            if (scanner.hasNextDouble()) {
                taxa = scanner.nextDouble();
                if (taxa <= 0) {
                    System.out.println("Erro: a taxa de juros deve ser positiva. Tente novamente.");
                }
            } else {
                System.out.println("Erro: entrada inválida. Digite um número válido.");
                scanner.next(); // descarta entrada inválida
                taxa = -1;     // força repetição do loop
            }
        } while (taxa <= 0);

        return taxa;
    }
}
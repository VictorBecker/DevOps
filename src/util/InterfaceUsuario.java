package util;

import modelo.Terreno.TipoZona;
import java.util.Scanner;

public class InterfaceUsuario {

    private static final Scanner scanner = new Scanner(System.in);

    // Limites de validação
    private static final double VALOR_IMOVEL_MIN = 1_000.0;
    private static final double VALOR_IMOVEL_MAX = 100_000_000.0;
    private static final int    PRAZO_MIN         = 1;
    private static final int    PRAZO_MAX         = 35;
    private static final double TAXA_MIN          = 0.001;
    private static final double TAXA_MAX          = 1.0;

    //  Métodos auxiliares privados

    private static double lerDoubleNoIntervalo(String mensagem, double min, double max) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim().replace(",", ".");
            try {
                double valor = Double.parseDouble(entrada);
                if (valor >= min && valor <= max) return valor;
                System.out.printf("Erro: o valor deve estar entre %.2f e %.2f. Tente novamente.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida. Digite um número válido.");
            }
        }
    }

    private static int lerInteiroNoIntervalo(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) return valor;
                System.out.printf("Erro: o valor deve estar entre %d e %d. Tente novamente.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida. Digite um número inteiro válido.");
            }
        }
    }

    //  Dados comuns do financiamento

    public double pedirValorImovel() {
        System.out.printf("(Valor entre R$ %,.2f e R$ %,.2f)%n", VALOR_IMOVEL_MIN, VALOR_IMOVEL_MAX);
        return lerDoubleNoIntervalo("Digite o valor do imóvel (R$): ", VALOR_IMOVEL_MIN, VALOR_IMOVEL_MAX);
    }

    public int pedirPrazoFinanciamento() {
        System.out.printf("(Prazo entre %d e %d anos)%n", PRAZO_MIN, PRAZO_MAX);
        return lerInteiroNoIntervalo("Digite o prazo do financiamento (em anos): ", PRAZO_MIN, PRAZO_MAX);
    }

    public double pedirTaxaJuros() {
        System.out.printf("(Taxa entre %.1f%% e %.0f%% ao ano)%n", TAXA_MIN * 100, TAXA_MAX * 100);
        return lerDoubleNoIntervalo("Digite a taxa de juros anual (ex: 0.12 para 12%): ", TAXA_MIN, TAXA_MAX);
    }

    //  Atributos específicos: Casa

    public double pedirAreaTerreno() {
        return lerDoubleNoIntervalo("Digite a área do terreno (m²): ", 10.0, 100_000.0);
    }

    public double pedirAreaConstruida() {
        return lerDoubleNoIntervalo("Digite a área construída (m²): ", 10.0, 100_000.0);
    }

    //  Atributos específicos: Apartamento

    public int pedirVagasGaragem() {
        return lerInteiroNoIntervalo("Digite o número de vagas de garagem: ", 0, 10);
    }

    public int pedirAndar() {
        return lerInteiroNoIntervalo("Digite o número do andar: ", 1, 200);
    }

    //  Atributos específicos: Terreno

    public TipoZona pedirTipoZona() {
        TipoZona[] opcoes = TipoZona.values();
        while (true) {
            System.out.println("Tipos de zona disponíveis:");
            for (int i = 0; i < opcoes.length; i++) {
                System.out.printf("  %c - %s%n", 'a' + i, opcoes[i]);
            }
            // Lógica usada para facilitar novas opcoes futuras
            System.out.print("Escolha o tipo de zona (letra): ");
            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.length() == 1) {
                int indice = entrada.charAt(0) - 'a';
                if (indice >= 0 && indice < opcoes.length) return opcoes[indice];
            }
            System.out.println("Erro: entrada inválida. Digite uma letra válida da lista.");
        }
    }
}
package util;

import modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class GerenciadorArquivos {

    private static final String ARQUIVO_TEXTO       = "financiamentos.txt";
    private static final String ARQUIVO_SERIALIZADO = "financiamentos.ser";

    // 1. ARQUIVO DE TEXTO
    public static void salvarEmTexto(ArrayList<Financiamento> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_TEXTO))) {
            // Cabeçalho explicativo
            writer.write("TIPO|VALOR_IMOVEL|PRAZO_ANOS|TAXA_ANUAL|PARCELA_MENSAL|TOTAL|ATRIBUTOS_ESPECIFICOS");
            writer.newLine();

            for (Financiamento f : lista) {
                writer.write(f.paraLinhaTexto());
                writer.newLine();
            }

            System.out.println("\n[Texto] Arquivo salvo: " + ARQUIVO_TEXTO);

        } catch (IOException e) {
            System.out.println("[Texto] Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public static void lerDeTexto() {
        System.out.println("\n[Texto] Lendo arquivo: " + ARQUIVO_TEXTO);
        System.out.println("---------------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_TEXTO))) {
            String linha;
            boolean primeiraLinha = true;
            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) {           // pula o cabeçalho
                    primeiraLinha = false;
                    continue;
                }
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("[Texto] Erro ao ler arquivo: " + e.getMessage());
        }

        System.out.println("---------------------------------------------------");
    }

    // 2. ARQUIVO SERIALIZADO
    public static void salvarSerializado(ArrayList<Financiamento> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO_SERIALIZADO))) {

            oos.writeObject(lista);
            System.out.println("\n[Serializado] Arquivo salvo: " + ARQUIVO_SERIALIZADO);

        } catch (IOException e) {
            System.out.println("[Serializado] Erro ao salvar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Financiamento> lerSerializado() {
        System.out.println("\n[Serializado] Lendo arquivo: " + ARQUIVO_SERIALIZADO);

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARQUIVO_SERIALIZADO))) {

            ArrayList<Financiamento> lista = (ArrayList<Financiamento>) ois.readObject();
            System.out.println("[Serializado] " + lista.size() + " financiamento(s) carregado(s) com sucesso.");
            return lista;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[Serializado] Erro ao ler: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
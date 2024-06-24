package estudos_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AtualizarSalarioArquivoTxt {
    public static void main(String[] args) {
        // Caminho do arquivo
        String nomeArquivo = "C:\\JULIO FACINA\\AmbienteJAVA\\nomes_e_enderecos.txt";
        String nomeArquivoAtualizado = "C:\\JULIO FACINA\\AmbienteJAVA\\nomes_e_enderecos_atualizado.txt";

        try (FileReader arquivoLeitura = new FileReader(nomeArquivo);
             BufferedReader leitor = new BufferedReader(arquivoLeitura);
             FileWriter arquivoEscrita = new FileWriter(nomeArquivoAtualizado, true);
             BufferedWriter escritor = new BufferedWriter(arquivoEscrita);
             PrintWriter escreverNoArquivo = new PrintWriter(escritor);
             InputStreamReader leitorEntrada = new InputStreamReader(System.in);
             BufferedReader leitorTeclado = new BufferedReader(leitorEntrada)) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Exibe a linha atual do arquivo
                System.out.println("Linha original: " + linha);

                // Solicita ao usuário o novo salário
                System.out.print("Digite o novo salário para " + linha + ": ");
                String novoSalario = leitorTeclado.readLine();

                // Cria a linha atualizada com o novo salário
                String linhaAtualizada = linha + ", salario: " + novoSalario;

                // Escreve a linha atualizada no arquivo de saída
                escreverNoArquivo.println(linhaAtualizada);
                System.out.println("Linha atualizada: " + linhaAtualizada);
            }

            System.out.println("Atualização concluída.");

        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever no arquivo: " + e.getMessage());
        }
    }
}

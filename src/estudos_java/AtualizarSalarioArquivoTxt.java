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

/*
--- RESULTADO DA DIGITAÇÃO ---
João da Silva, Rua das Flores, 123, salario: 4500
Maria Oliveira, Avenida Principal, 456, salario: 5000
Pedro Santos, Travessa das Árvores, 789, salario: 745
Ana Souza, Praça Central, 321, salario: 3000
Marcos Costa, Alameda dos Passarinhos, 654, salario: 500
Carla Pereira, Rua das Palmeiras, 987, salario: 1200
José Lima, Avenida dos Girassóis, 234, salario: 1000
Fernanda Almeida, Rua das Margaridas, 567, salario: 2300
Ricardo Santos, Alameda dos Ipês, 890, salario: 900
Camila Vieira, Rua das Violetas, 543, salario: 1100
Felipe Rodrigues, Avenida das Orquídeas, 876, salario: 11000
Amanda Ferreira, Rua das Acácias, 219, salario: 670
Lucas Oliveira, Travessa dos Pinheiros, 876, salario: 2200
Gabriela Silva, Avenida dos Lírios, 543, salario: 1800
Daniel Costa, Rua das Hortênsias, 210, salario: 1900
*/
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

/*
 
 Explicação do Uso do try

No programa acima, o try foi utilizado para garantir que todos 
os recursos que são abertos (como arquivos de leitura e escrita, 
e fluxos de entrada do teclado) sejam devidamente fechados ao final, 
independentemente de ocorrerem exceções ou não. Aqui estão os 
principais pontos sobre como o try foi aplicado:

Inicialização de Recursos: Dentro do bloco try, diversos recursos 
foram inicializados usando a sintaxe do try-with-resources. Isso 
é feito para que esses recursos sejam automaticamente fechados ao 
final do bloco try.
    
FileReader, BufferedReader, FileWriter, BufferedWriter, 
PrintWriter, InputStreamReader e BufferedReader são todos 
recursos que são inicializados dentro do try. Esses recursos 
são automaticamente fechados no final do bloco try, 
independentemente de exceções ocorrerem ou não.

Leitura do Arquivo e Entrada do Usuário: Dentro do try, o 
programa lê cada linha do arquivo de entrada (nomeArquivoEntrada) 
e permite que o usuário digite um novo salário para cada linha 
lida. A entrada do usuário é lida usando leitorTeclado.readLine().

Se ocorrerem exceções durante a leitura do arquivo (IOException), 
o fluxo de controle será transferido para o bloco catch.

Escrita no Arquivo: Após processar cada linha do arquivo de 
entrada e obter o novo salário do usuário, o programa cria uma 
linha atualizada (linhaAtualizada) e a escreve no arquivo de 
saída (nomeArquivoSaida) usando escreverNoArquivo.println(linhaAtualizada).

Tratamento de Exceções: O bloco catch (IOException e) captura 
qualquer exceção de entrada/saída que possa ser lançada durante 
a leitura ou escrita de arquivos. Em caso de exceção, uma mensagem 
de erro é exibida usando System.out.println("Erro ao ler ou 
escrever no arquivo: " + e.getMessage());.

Fechamento de Recursos: O fechamento dos recursos é feito 
automaticamente pelo try-with-resources ao final do bloco 
try, incluindo o fechamento dos arquivos de leitura e escrita 
e dos fluxos de entrada do teclado.

Benefícios do try-with-resources

O uso do try-with-resources simplifica o código, eliminando a 
necessidade de explicitamente fechar recursos em um bloco finally. 
Ele também ajuda a evitar vazamentos de recursos ao garantir que 
todos os recursos sejam fechados corretamente, mesmo se ocorrerem 
exceções durante a execução do programa.
         
        
 */
        
        
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
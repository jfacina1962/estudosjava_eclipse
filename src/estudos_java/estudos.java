package estudos_java;

/*
João da Silva, Rua das Flores, 123
Maria Oliveira, Avenida Principal, 456
Pedro Santos, Travessa das Árvores, 789
Ana Souza, Praça Central, 321
Marcos Costa, Alameda dos Passarinhos, 654
Carla Pereira, Rua das Palmeiras, 987
José Lima, Avenida dos Girassóis, 234
Fernanda Almeida, Rua das Margaridas, 567
Ricardo Santos, Alameda dos Ipês, 890
Camila Vieira, Rua das Violetas, 543
Felipe Rodrigues, Avenida das Orquídeas, 876
Amanda Ferreira, Rua das Acácias, 219
Lucas Oliveira, Travessa dos Pinheiros, 876
Gabriela Silva, Avenida dos Lírios, 543
Daniel Costa, Rua das Hortênsias, 210

 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class estudos {
    public static void main(String[] args) {
        // Caminho do arquivo
        String nomearquivo = "C:\\JULIO FACINA\\AmbienteJAVA\\nomes_e_enderecos.txt";

        try {
            FileReader arquivo = new FileReader(nomearquivo);
            BufferedReader leitor = new BufferedReader(arquivo);

            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close(); // Fechando o leitor após a leitura
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
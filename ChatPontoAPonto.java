import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatPontoAPonto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.print("Digite seu nome ou apelido: ");
            String nome = teclado.nextLine();

            System.out.print("Digite a porta para escutar conexões (sua porta): ");
            int porta = Integer.parseInt(teclado.nextLine());

            ServerSocket servidor = new ServerSocket(porta);
            System.out.println("Escutando conexões na porta " + porta + "...");

            System.out.print("Você quer se conectar a outro cliente? (sim/nao): ");
            String resposta = teclado.nextLine();

            if (resposta.equalsIgnoreCase("sim")) {
                System.out.print("Digite o endereço IP do outro cliente: ");
                String ip = teclado.nextLine();
                System.out.print("Digite a porta do outro cliente: ");
                int outraPorta = Integer.parseInt(teclado.nextLine());

                Socket conexao = new Socket(ip, outraPorta);
                System.out.println("Conectado ao cliente em " + ip + ":" + outraPorta);

                // Envio
                Thread envio = new Thread(() -> gerenciarEnvio(conexao, nome));
                envio.start();

                // Recebimento
                Thread recebimento = new Thread(() -> gerenciarRecebimento(conexao));
                recebimento.start();
            }

            // Sempre escuta conexões
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado!");

            // Envio
            Thread envio = new Thread(() -> gerenciarEnvio(cliente, nome));
            envio.start();

            // Recebimento
            Thread recebimento = new Thread(() -> gerenciarRecebimento(cliente));
            recebimento.start();

        } catch (IOException e) {
            System.out.println("Erro ao escutar conexões: " + e.getMessage());
        }
    }
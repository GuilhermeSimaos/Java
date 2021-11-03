import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        /* Especificações : 
             O cliente pode enviar e receber somente uma mensagem por vez, então não espame!(pretendo melhorar isso)
             Caso responda 4 ou "não", recebe mensagem do servidor e verifica se é igual a "fechando",
             caso seja, encerrar conexão.
        */
        
        try {
            // Iniciando Socket para conectar ao Servidor
            Socket client = new Socket("localhost", 35355);
            
            // Laço de repetição para tratar troca de mensagem
            while (client.isConnected()) {                
                InputFromServer(client);
                OutputToServer(client);
            }
            
            // Fechando conexão
            FecharConexao(client);
        } catch (IOException e) {
            System.out.println("\nErro: "+ e.getMessage());
        }
    }
    // Método que trata de pegar a mensagem vinda do Servidor
    public static void InputFromServer(Socket client) throws IOException{
        InputStream InFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(InFromServer);
        String mensagem = in.readUTF();
        
        System.out.println("\n\nServer: "+mensagem);
        
        if (mensagem.contains("Fechando")) {        // Utilizado para encerrar a conexao de imediato
            FecharConexao(client);
        }
    }
    // Método que trata de mandar mensagem para o Servidor
    public static void OutputToServer(Socket client) throws IOException{
        OutputStream ToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(ToServer);
                   
        System.out.print("You: ");
        out.writeUTF(s.nextLine());
    }
    // Método para fechar conexão, puramente opcional mas preferível
    private static void FecharConexao(Socket client) throws IOException{
        client.close();
    }
}

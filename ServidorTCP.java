import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    
    public static void main(String[] args) throws IOException {
        try {
            /* Especificações : 
                 Servidor deve ecoar os comandos recebidos e perguntar se deseja continuar após as escolhas, exceto opção 4.
                 Se escolhido 4 ou "não", encerrar conexão. 
                 Atender somente um cliente.
            */
            
            // Iiniciando o servidor.
            ServerSocket server = new ServerSocket(35355);
            System.out.println("Aguardando conexao na porta \033[36m"+server.getLocalPort()+"\033[m...");
            
            // Aceitando conexao de cliente
            Socket client = server.accept();
            System.out.printf("Cliente conectado!\tIP: \033[36m%1$s\033[m\n\n",client.getInetAddress().getHostName());
            
            // Laço de repetição para tratar troca de mensagem, poderia ficar melhor.
            while (client.isConnected()) {
                OutputToClient(client,Menu());
                InputFromClient(client);
            }
            
            // Encerrar conexao
            FecharConexao(client);
        
        } catch (IOException e) {
            System.out.println("\nErro: "+e.getMessage());
        }
    }
    // Método que Trata de pegar a mensagem vinda do Socket client
    public static void InputFromClient(Socket client) throws IOException{
        InputStream FromClient = client.getInputStream();
        DataInputStream in = new DataInputStream(FromClient);
        String Msg = in.readUTF();
        
        System.out.println("User: " + Msg); // Não é necessário mostrar isso, puramente opcional
        
        if (Msg.contains("4")) {            // Caso o client escolha sair diretamente
            OutputToClient(client, "Comando recebido \033[36m"+Msg+"\033[m\n\t\033[33mFechando Conexao...\033[m");
            FecharConexao(client);
        }else{                      
            OutputToClient(client, "Comando recebido \033[36m"+Msg+"\033[m\n\tDeseja Continuar? S/N");
            Msg = in.readUTF();
            if (Msg.toLowerCase().contains("n")) {      //Caso o client escolha sair indiretamente
                OutputToClient(client, "Comando recebido \033[36m"+Msg+"\033[m\n\t\033[33mFechando Conexao...\033[m");
                FecharConexao(client);
            }
        }
    }
    // Método que trata de enviar mensagem para o Socket client
    public static void OutputToClient(Socket client,String mensagem) throws IOException{
        OutputStream FromServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(FromServer);
        
        out.writeUTF(mensagem);
    }
    // Método para impressão do Menu de Opções
    public static String Menu(){
        return "\033[36m----- Menu de opcoes -----\033[m\n\t\033[36m1\033[m - Funcao 1\n\t\033[36m2\033[m - Funcao 2\n\t\033[36m3\033[m - Funcao 3\n\t\033[36m4\033[m - Encerrar Conexao\n";
    }
    // Método para fechar conexão, opcional mas preferível
    public static void FecharConexao(Socket client) throws IOException{
        client.close();
    }
}

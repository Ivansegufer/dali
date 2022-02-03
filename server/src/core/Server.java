/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package core;

import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.io.IOException;

import utils.IPValidator;
import core.handlers.ClientHandler;

public class Server {
    
    private ServerSocket serverSocket;
    
    final private InetAddress inetAddress;
    final private int backlog;
    final private short port;
    
    public Server(String host, short port, int backlog) throws Exception {
        if(!IPValidator.isValidIPAddress(host))
            throw new Exception("No valid IP address");
        
        this.inetAddress = InetAddress.getByName(host);
        this.backlog = backlog;
        this.port = port;
    }
    
    public void startServer() {
        try {
            serverSocket = new ServerSocket(
                this.port,
                this.backlog,
                this.inetAddress
            );
            serverSocket.setReuseAddress(true);
            listenConnection();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if(this.serverSocket != null) {
                try {
                    this.serverSocket.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void listenConnection() throws IOException {
        while(true) {
            Socket client = this.serverSocket.accept();
            System.out.printf("Nuevo cliente conectado %s:%d\n",
                client.getInetAddress().getHostAddress(),
                client.getPort());
            ClientHandler handler = new ClientHandler(client);

            new Thread(handler).start();
        }
    }
}

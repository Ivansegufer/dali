/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

/**
 * Clase principal, la clase Startup se encarga de iniciar el servidor
 * con una configuración inicial
 */

import core.Server;

public class Startup {
    
    static final int BACKLOG = 50;
    static final short PORT = 5050;
    static final String INET_ADDRESS = "127.0.0.1";
    
    public static void main(String[] args) {
        Server app;
        try {
            app = new Server(INET_ADDRESS, PORT, BACKLOG);
            app.startServer();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

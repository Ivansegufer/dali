/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package core.handlers;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

import core.controllers.*;

public class ClientHandler implements Runnable {
    
    private final String EXIT_WORD = "exit--exit";
    private final Socket clientSocket;
    private ControllerBase controller;
    
    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }
    
    @Override
    public void run()
    {
        PrintWriter  writer = null;
        BufferedReader reader = null;

        try {
            writer = new PrintWriter(
                clientSocket.getOutputStream(), true);
            reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

            String buffeString;
            /*
            String clientHostAddress = clientSocket
                .getInetAddress().getHostAddress();
            int clientPort = clientSocket.getPort();
            */
            while((buffeString = reader.readLine()) != null)
            {
                String[] splittedBuffer = buffeString.split("--");
                String endpoint = splittedBuffer[0];
                String payloadRequest = splittedBuffer[1];
                
                if(!EXIT_WORD.equalsIgnoreCase(buffeString)) {
                    if(!endpoint.equals("/game")) {
                        switch(endpoint) {
                            case "/register" -> { 
                                this.controller = new RegisterController(payloadRequest);
                                String response = this.controller.resolveRequest();
                                writer.println(response);
                            }
                            case "/session" -> { 
                                this.controller = new SessionController(payloadRequest);
                                String response = this.controller.resolveRequest();
                                writer.println(response);
                            }
                        }
                        break;
                    }
                    else {
                        System.out.println("Let's play");  
                    }
                }
                else break;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(writer != null) {
                    writer.close();
                }
                if(reader != null) {
                    reader.close();
                    clientSocket.close();
                }
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}

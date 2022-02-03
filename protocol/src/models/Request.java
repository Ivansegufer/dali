/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package models;

public class Request<T> extends Action<T> {
    
    public Request(String version, String uri, boolean active, String token, T body) {
        this.header = new Header();
        this.header.protocolVersion = version;
        this.header.uri = uri;
        
        this.session = new Session();
        this.session.activeSession = active;
        this.session.sessionToken = token;
        
        this.body = body;
    }
    
    public Request() { }
}



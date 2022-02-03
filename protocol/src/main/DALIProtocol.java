package main;

/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

import builders.*;
import interfaces.IBodyConvertible;
import enumerations.BODY_TYPES;

import com.google.gson.*;
import models.Action;

public class DALIProtocol {
    private IProtocolBuilder protocolBuilder = null;
    private IResolveProtocolBuilder resolverProtocolBuilder = null;
    
    public DALIProtocol(String uri) throws Exception {
        this.protocolBuilder = ProtocolBuilder.getInstanceNoSession(uri);
        this.resolverProtocolBuilder = new ResolveRequestProtocolBuilder();
    }
    
    public DALIProtocol(String uri, String token) throws Exception {
        this.protocolBuilder = ProtocolBuilder.getInstanceWithSession(uri, true, token);
        this.resolverProtocolBuilder = new ResolveRequestProtocolBuilder();
    }
    
    public String getActionString(BODY_TYPES type, IBodyConvertible body) {
        Action action = this.protocolBuilder.getActionProtocol(type, body);
        return new Gson().toJson(action);
    }
    
    public Action resolveAction(BODY_TYPES type, String actionString) {
        Action action = this.resolverProtocolBuilder.resolveActionProtocol(type, actionString);
        return action;
    }
    
}

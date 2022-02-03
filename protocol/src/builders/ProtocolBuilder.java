/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package builders;

import enumerations.BODY_TYPES;
import models.*;

import interfaces.IBodyConvertible;
import entities.quiz.*;
import entities.TeacherSession;
import entities.TeacherRegister;
import responses.CommonResponse;

public class ProtocolBuilder implements IProtocolBuilder {
    
    private final String protocolVersion = "1.0";
    private final boolean sessionActive;
    private final String sessionToken;
    private final String uri;
    
    private static ProtocolBuilder thisInstance = null;
    
    private ProtocolBuilder(String uri, boolean active, String token) {
        this.uri = uri;   
        this.sessionActive = active;
        this.sessionToken = token;
    }
    
    public static ProtocolBuilder getInstanceNoSession(String uri) {
        if(thisInstance == null)
           thisInstance = new ProtocolBuilder(uri, false, "");
        return thisInstance;
    }
    
    public static ProtocolBuilder getInstanceWithSession(String uri, boolean active, String token) {
        if(thisInstance == null)
           thisInstance = new ProtocolBuilder(uri, active, token);
        return thisInstance;
    }
    
    public static void cleanInstance() {
        thisInstance = null;
    }
    
    @Override
    public Action getActionProtocol(BODY_TYPES type, IBodyConvertible body) {
        Action action = null;
        switch(type) {
            case BODY_QUESTION -> action = new Request<>(
                    this.protocolVersion,
                    this.uri,
                    this.sessionActive,
                    this.sessionToken,
                    (QuestionBank)body
                );
            case BODY_SESSION -> action = new Request<>(
                    this.protocolVersion,
                    this.uri,
                    this.sessionActive,
                    this.sessionToken,
                    (TeacherSession)body
                );
            case BODY_REGISTER -> action = new Request<>(
                    this.protocolVersion,
                    this.uri,
                    this.sessionActive,
                    this.sessionToken,
                    (TeacherRegister)body
                );
            case COMMON_RESPONSE -> action = new Response<>(
                    this.protocolVersion,
                    this.uri,
                    this.sessionActive,
                    this.sessionToken,
                    (CommonResponse)body
            );
        }
        return action;
    }
}

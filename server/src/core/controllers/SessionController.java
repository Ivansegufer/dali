/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package core.controllers;

import com.google.gson.internal.LinkedTreeMap;
import data.ISession;
import data.TeacherService;
import enumerations.BODY_TYPES;
import responses.CommonResponse;

public class SessionController extends ControllerBase {
    
    @Override
    public String resolveRequest() {
        this.service = TeacherService.getInstance();
        String password = ((ISession)this.service).getSession(action);
        if (password != null && !password.equals("")) {
            if(password.equals((String)((LinkedTreeMap)action.body).get("password"))) {
                this.body = new CommonResponse(200, "Has been logged successfully");
                return this.protocol.getActionString(BODY_TYPES.COMMON_RESPONSE, body);
            }
            else {
                this.body = new CommonResponse(300, "Password incorrect");
                return this.protocol.getActionString(BODY_TYPES.COMMON_RESPONSE, body);
            }
        }
        this.body = new CommonResponse(404, "User not found");
        return this.protocol.getActionString(BODY_TYPES.COMMON_RESPONSE, body);
    }
    
    public SessionController(String payload) {
        super("/session");
        this.action = this.protocol.resolveAction(BODY_TYPES.BODY_SESSION, payload);
    }
}

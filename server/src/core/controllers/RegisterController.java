/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package core.controllers;

import data.*;
import enumerations.BODY_TYPES;
import responses.CommonResponse;

public class RegisterController extends ControllerBase {
    
    @Override
    public String resolveRequest() {
        this.service = TeacherService.getInstance();
        if (this.service.register(this.action)) {
            this.body = new CommonResponse(201, "Has been created the resource");
            return this.protocol.getActionString(BODY_TYPES.COMMON_RESPONSE, body);
        }
        this.body = new CommonResponse(401, "Has been ocurred and error creating the resource");
        return this.protocol.getActionString(BODY_TYPES.COMMON_RESPONSE, body);
    }
    
    public RegisterController(String payload) {
        super("/register");
        this.action = this.protocol.resolveAction(BODY_TYPES.BODY_REGISTER, payload);
    }
}

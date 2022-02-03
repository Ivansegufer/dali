/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package builders;

import java.lang.reflect.Type;
import com.google.gson.*;

import enumerations.BODY_TYPES;
import entities.TeacherRegister;
import entities.TeacherSession;
import models.Action;
import models.Request;

public class ResolveRequestProtocolBuilder implements IResolveProtocolBuilder {
    
    @Override
    public Action resolveActionProtocol(BODY_TYPES type, String actionString) {
        switch (type) {
            case BODY_REGISTER -> {
                Type requestRegisterType = new Request<TeacherRegister>().getClass();
                Action action = new Gson().fromJson(actionString, requestRegisterType);
                return action;
            }
            case BODY_SESSION -> {
                Type requestSessionType = new Request<TeacherSession>().getClass();
                Action action = new Gson().fromJson(actionString, requestSessionType);
                return action;
            }
        }
        return null;
    }
}

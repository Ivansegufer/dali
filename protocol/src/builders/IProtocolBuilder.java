/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package builders;

import interfaces.IBodyConvertible;
import enumerations.BODY_TYPES;
import models.Action;

public interface IProtocolBuilder {
    public Action getActionProtocol(BODY_TYPES type, IBodyConvertible body);
}

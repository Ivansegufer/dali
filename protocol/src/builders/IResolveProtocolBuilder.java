/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package builders;

import models.Action;
import enumerations.BODY_TYPES;

public interface IResolveProtocolBuilder {
    public Action resolveActionProtocol(BODY_TYPES type, String actionString);
}

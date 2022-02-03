/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package responses;

import interfaces.IBodyConvertible;

public class CommonResponse implements IBodyConvertible {
    public int statusCode;
    public String message;
    
    public CommonResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}

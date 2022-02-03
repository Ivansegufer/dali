/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package entities;

import interfaces.IBodyConvertible;

public class TeacherSession implements IBodyConvertible {
    public String email;
    public String password;
    
    public TeacherSession(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

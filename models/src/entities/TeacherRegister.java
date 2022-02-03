/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package entities;

import interfaces.IBodyConvertible;

public class TeacherRegister implements IBodyConvertible {
    public String name;
    public String surname;
    public String email;
    public String password;
    
    public TeacherRegister(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}

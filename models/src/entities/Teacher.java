/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package entities;

import java.util.List;

import entities.quiz.QuestionBank;
import interfaces.IBodyConvertible;

public class Teacher implements IBodyConvertible {
    
    public String name;
    public String surname;
    public String email;
    public String password;
    
    public List<QuestionBank> questionBanks;
}

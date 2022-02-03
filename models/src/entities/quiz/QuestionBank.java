/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package entities.quiz;

import java.util.*;
import interfaces.IBodyConvertible;

public class QuestionBank implements IBodyConvertible {
    
    public String name;
    public String description;
    public String creationDate;
    public String startDate;
    
    public List<Question> questions;
    
    public QuestionBank(String name, String description, String creationDate, String startDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.startDate = startDate;
        
        questions = new ArrayList<Question>(); 
    }
}

/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package entities.quiz;

public class Answer {
    
    public String description;
    public boolean isCorrect;
    
    public Answer(String description, boolean isCorrect) {
        this.description = description;
        this.isCorrect = isCorrect;
    }
}

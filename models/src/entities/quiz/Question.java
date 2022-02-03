/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package entities.quiz;

// import java.awt.Image;
import entities.quiz.Answer;
import java.util.*;

public class Question {
    
    public String title;
    /**
    * If images are required enable this field and enable java.awt.Image
    * public Image image;
    */
    
    public List<Answer> answers; 
    
    public Question(String title) {
        this.title = title;
        
        this.answers = new ArrayList<Answer>();
    }
}

/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPValidator {
    private IPValidator() {}
    
    public static boolean isValidIPAddress(String IPAddress) {
        if(IPAddress == null || IPAddress.length() < 9) return false;
        
        String zeroTo255 = "(\\d{1,2}|(0|1)\\"
            + "d{2}|2[0-4]\\d|25[0-5])";
        
        String regex
            = zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255;
        
        Matcher matcher = Pattern.compile(regex)
            .matcher(IPAddress);
        
        return matcher.matches();
    }
}

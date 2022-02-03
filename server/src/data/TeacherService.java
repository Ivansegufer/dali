/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package data;

import com.google.gson.internal.LinkedTreeMap;
import java.sql.SQLException;
import models.Action;

public class TeacherService extends DataService implements ISession {
    private static DataService selfInstance = null;
    
    private TeacherService() {
        super("localhost", "dali");
    }
    
    public static DataService getInstance() {
        if(selfInstance == null) {
            selfInstance = new TeacherService();
        }
        return selfInstance;
    }
    
    @Override
    public boolean register(Action action) {
        boolean isSuccessful;
        
        try {
            this.manager.open();
            String procedureStatement = "{call sp_agregarProfesor (?,?,?,?)}";
            String[] params = {
                (String)((LinkedTreeMap)action.body).get("name"),
                (String)((LinkedTreeMap)action.body).get("surname"),
                (String)((LinkedTreeMap)action.body).get("email"),
                (String)((LinkedTreeMap)action.body).get("password"),
            };
            this.manager.executeProcedure(procedureStatement, params);
            isSuccessful = true;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
            isSuccessful = false;
        }
        finally {
            try {
               this.manager.close(); 
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccessful;
    }

    @Override
    public String getSession(Action action) {
        String password = "";
        try {
            this.manager.open();
            String procedureStatement = "{call sp_obtenerPassword (?,?)}";
            String[] params = {
                (String)((LinkedTreeMap)action.body).get("email"),
            };
            password = this.manager.executeProcedureWithOneOutParam(procedureStatement, params);
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
               this.manager.close(); 
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return password;
    }
}

/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package data;

import models.Action;

public abstract class DataService {
    protected DatabaseManager manager;
    
    protected DataService(String host, String db) {
        this.manager = new DatabaseManager(host, db);
    }
    
    public abstract boolean register(Action actionToSave);
}

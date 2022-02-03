/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package core.controllers;

import data.DataService;
import interfaces.IBodyConvertible;
import main.DALIProtocol;
import models.Action;

public abstract class ControllerBase {
    protected Action action;
    protected IBodyConvertible body;
    protected DataService service;
    protected DALIProtocol protocol;
    
    public abstract String resolveRequest();
    
    public ControllerBase(String uri) {
        try {
            this.protocol = new DALIProtocol(uri);
        }
        catch(Exception e) {
            System.out.println("Has been ocurred an error while instance protocol"
                + " service: " + uri);
        }
    }
}

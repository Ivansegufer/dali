/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package models;

public abstract class Action<T> {
    public Header header;
    public Session session;
    public T body;
}

/**
 * @author Sebastian Guzman Fernandez
 * @author Luis Esteban Reyna
 * @author Ana Maria Gutierrez
 * @author Danna Cruz Vera
 */

package data;

import java.sql.*;

class DatabaseManager {
    private String host;
    private String database;
    private Connection connection;
    private CallableStatement statement;
    
    public DatabaseManager(String host, String database) {
        this.host = host;
        this.database = database;
    }
    
    public synchronized void open() throws SQLException {
        if(this.connection == null) {
            String connectionString = String.format("jdbc:mysql://%s/%s", this.host, this.database);
            connection = DriverManager.getConnection(connectionString, "root", "Ivansegufer.21"); 
        }
        else
            System.out.println("The database is alredy open");
    }
    
    public synchronized boolean close() throws SQLException {
        if(this.connection != null) {
            if(!connection.isClosed()) {
                this.connection.close();
                this.connection = null;
                return true;
            }
            else {
                System.out.println("The database couldn't be close");
                return false;
            }
        }
        System.out.println("Connection must not be null");
        return false;
    }
    
    public synchronized void executeProcedure(String procedureStatement, String[] parameters) throws SQLException {
        if(!connection.isClosed()) {
            this.statement = this.connection.prepareCall(procedureStatement);
            int counterParam = 0;
            for(String param : parameters) {
                this.statement.setString(++counterParam, param);
            }
            this.statement.execute();
            System.out.println("Has been executed procedure successfully");
            return;
        }
        System.out.println("The connection is closed");
    }
    public synchronized String executeProcedureWithOneOutParam(String procedureStatement, String[] parameters) throws SQLException {
        if(!connection.isClosed()) {
            this.statement = this.connection.prepareCall(procedureStatement);
            int counterParam = 0;
            for(String parameter : parameters) {
                this.statement.setString(++counterParam, parameter);
            }
            this.statement.registerOutParameter(++counterParam, Types.VARCHAR);
            this.statement.execute();
            System.out.println("Has been executed procedure successfully");
            return this.statement.getString(counterParam);
        }
        System.out.println("The connection is closed");
        return "";
    }
}

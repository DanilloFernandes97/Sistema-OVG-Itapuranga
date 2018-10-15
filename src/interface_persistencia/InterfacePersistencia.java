package interface_persistencia;

import java.io.IOException;
import java.sql.SQLException;    

public interface InterfacePersistencia<T>  { 
    
    public boolean salvar (T pObjeto) throws IOException, ClassNotFoundException, SQLException;
    
    public boolean getExiste(final int pID) throws IOException, ClassNotFoundException, SQLException;
    
    public int getProximoCodigo() throws IOException, ClassNotFoundException, SQLException;
    
    public boolean getObjeto(final int pID, T pObjeto) throws IOException, ClassNotFoundException, SQLException;
    
    public boolean delete(final int pID) throws IOException, ClassNotFoundException, SQLException;                  
        
}

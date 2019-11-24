package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andre
 */
public abstract class GenericDAO<T> {
    private Connection connection;
    
    GenericDAO(){
        this.connection = ConnectionDatabase.getConnection();
    }
     
    public Connection getConnection(){
        return this.connection;
    }
    
    public void delete(String sql, int id){
         try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            getConnection().close();
        } catch (SQLException e) {
            System.err.print("ERRO AO DELETAR");
           
        }
    }
    
    abstract public T inserir(T obj);
    abstract public void editar(T obj);
    abstract public void remover(T obj);
    abstract public T buscarPorId(int id);
    abstract public List<T> listar();
}

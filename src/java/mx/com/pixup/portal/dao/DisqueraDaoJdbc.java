/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pixup.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import mx.com.pixup.portal.model.Disquera;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author vrsa9208
 */
public class DisqueraDaoJdbc implements DisqueraDao{
    
    private DataSource dataSource;
    
    public DisqueraDaoJdbc(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pixup");
        this.dataSource = dataSource;
    }
    
    @Override
    public Disquera insertDisquera(Disquera disquera) {
        Connection connection = null;
        //PreparedStatement es mas rapido y seguro que Statement
        PreparedStatement preparedStatement = null;
        String sql = "insert into disquera (nombre) values (?)";
        ResultSet resultSet = null;
        
        try{
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, disquera.getNombre());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            
            resultSet.next();
            disquera.setId(resultSet.getInt(1));
            return disquera;
        }catch(Exception ex){
            return null;
        }finally{
            try{if(preparedStatement != null)preparedStatement.close();}catch(Exception e){};
            try{if(connection != null)connection.close();}catch(Exception e){};
        }
    }

    @Override
    public Disquera updateDisquera(Disquera disquera) {
        String sql = "update disquera set nombre = ? where id = ?";
        
        //try-with-resources-statement
        //Cierra los recursos al finalizar
        try(Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            
            preparedStatement.setString(1, disquera.getNombre());
            preparedStatement.setInt(2,disquera.getId());
            
            preparedStatement.execute();
            return disquera;
        } catch(Exception ex){
            return null;
        }
    }

    @Override
    public void deleteDisquera(Disquera disquera) {
        Connection connection = null;
        //PreparedStatement es mas rapido y seguro que Statement
        PreparedStatement preparedStatement = null;
        String sql = "delete from disquera where id = ?";
        
        try{
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, disquera.getId());
            preparedStatement.execute();
        }catch(Exception ex){
            
        }finally{
            try{if(preparedStatement != null)preparedStatement.close();}catch(Exception e){};
            try{if(connection != null)connection.close();}catch(Exception e){};
        }
    }

    @Override
    public List<Disquera> findAllDisqueras() {
        String sql = "select * from disquera";
        
        //try-with-resources-statement
        //Cierra los recursos al finalizar
        try(Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();){
            List<Disquera> listaDisqueras = new ArrayList<Disquera>();
            while(resultSet.next()){
                Disquera disqueraTemporal = new Disquera();
                disqueraTemporal.setId(resultSet.getInt("id"));
                disqueraTemporal.setNombre(resultSet.getString("nombre"));
                listaDisqueras.add(disqueraTemporal);
            }
            
            return listaDisqueras;
        } catch(Exception ex){
            return null;
        }
    }

    @Override
    public Disquera findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

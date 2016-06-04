package crudsimple;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author toby 
 */
public class CRUD {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUD() {
        try{
            if((con = conexion.getConexionMYSQL())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }else
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
//
//    CRUD(Bean persona) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    //Inserta una nueva pelicula en la Base de Datos
    public boolean insert(Bean persona){
        try {
            String query = "INSERT INTO persona VALUES("+persona.getId()+",'"+persona.getNombre()+"',"+persona.getEdad()+")";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Devuelve el resultset con los datos de persona
    public ResultSet selectXtodas(){
        try {
            String query = "SELECT * FROM persona";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Devuelve el resultset con los datos de persona con select por genero
    public ResultSet selectXgenero(String genero){
        try {
            String query = "SELECT * FROM persona WHERE genero = '"+genero+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Devuelve el resultset con los datos de persona con select por pais
    public ResultSet selectXpais(String pais){
        try {
            String query = "SELECT * FROM persona WHERE pais = '"+pais+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    //Elimina la pelicula
    public boolean delete(int id){
        try {
            String query = "DELETE FROM persona WHERE id = '"+id+"'";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Actualiza los datos de la pelicula
    public boolean update(int id,String nombre,String genero,int anio,String actor,String pais){
        try {
            String query = "UPDATE persona SET"
                    + " nombre = '"+nombre+"',"
                    + " genero = '"+genero+"',"
                    + " anio = '"+anio+"',"
                    + " actor = '"+actor+"',"
                    + " pais = '"+pais+"' WHERE id = '"+id+"';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

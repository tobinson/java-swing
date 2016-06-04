
package crudsimple;

/**
 *
 * @author Pc
 */
public class Bean {
    int id;
    String nombre;
    int edad;
    //constructor para insertar
    public Bean(String nombre, int edad) {        
        this.nombre = nombre;
        this.edad = edad;
        
    }
     //constructor para editar
    public Bean(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
    

    public Bean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }  
     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.*;
/**
 *
 * @author juriel
 */
public class DAOAutor {
  public Autor  Insertar(String cedula, String nombres, String apellidos, String email,
          java.sql.Date fechaNac){
      
      String transaccion ="INSERTA INTO Autor(cedula,nombres, apellidos, email, fechaNac) VALUES('"
              + nombres +"',  '"
              + apellidos +"',  "
              + email +"',  '"
              + cedula +"',  '"
              + fechaNac +"') '";
         
      if (new DataBase().Actualizar(transaccion) > 0) {
          return new Autor(cedula, nombres, apellidos, email, fechaNac);
      }
       return null ;       
  }
  
public int  Actualizar (int id, String nombres, String apellidos, String email, String cedula,
java.sql.Date fechaNac){
String transaccion="UPDATE Autor SET nombres='"
   + nombres +"',apellidos'"   
        +apellidos +"', email'"
        +email+"', fechaNac'"
        +fechaNac+"', cedula'"
        + cedula +"' WHERE id_Autor="
        + id ;

return new DataBase().Actualizar(transaccion);
}
public List ObtenerDatos(){
    String transaccion= "SELECT * FROM Autor";
    List<Map> registros= new DataBase().listar(transaccion);
    List<Autor> autores = new ArrayList();
    
    for (Map registro : registros){
        Autor aut = new Autor((int) registro.get("id_autor"),
                (String) registro.get("nombres"),
                 (String) registro.get("apellidos"),
                 (String) registro.get("email"),
                 (String) registro.get("cedula"),
        (java.sql.Date) registro.get("fechaNac"));
        autores.add(aut);
    }
    return autores;
}
public int Eliminar(int id){
    String transacion = "DELETE FROM Autor WHERE id_autor  ='"+ id +"'";
    
    return new DataBase().Actualizar(transacion);
}
}

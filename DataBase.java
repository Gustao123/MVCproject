package modelo;

import java.sql.*;
import java.util.*;

/**
 *
 * @author juriel
 */
public class DataBase {
   private final String URL= "jdbc:mysql://localhost:3306/publicacion";
   private final String user="sai";
   private final String password="M2023***";
     
   private Connection conexion;
   
   public DataBase(){
       try {
           conexion=DriverManager.getConnection(URL, user, password);
           System.out.println("conexión Establecida");
           
       }catch (SQLException e){
           System.out.println("Error de conexión");
           e.printStackTrace();      
       }
   }      
   

     public int Actualizar(String consulta){
     try{
    Statement st=conexion.createStatement();
    return st.executeUpdate(consulta);
    
        }catch (SQLException e){
   e.printStackTrace();
   }
     return 0;
     }
     private List organizarDatos(ResultSet rs){
     List filas =new ArrayList();
try{
int numcolumnas=rs.getMetaData().getColumnCount();
while (rs.next()){
Map<String, Object>renglon=new HashMap();
for(int i=1; i<=numcolumnas; i++){
String nombrecampos=rs.getMetaData().getColumnName(i);
Object valor=rs .getObject(nombrecampos);
renglon.put(nombrecampos, valor);
     }
filas.add(renglon);
 }

}catch(SQLException e){
  e.printStackTrace();
  }
return filas;
     
   }
public List listar (String consulta){
ResultSet rs=null;
List  resultado =new ArrayList();
try{
    Statement st =conexion.createStatement();
    rs=st.executeQuery(consulta);
    resultado=organizarDatos(rs);
    
}catch(SQLException e){
    System.out.println("No se realizó la consulta");
    e.printStackTrace();
}
return resultado;
}
public void  cerrarconexion(){
    try{
        conexion.close();
    }catch (SQLException e){
        e.printStackTrace();
    }
} 

}

 








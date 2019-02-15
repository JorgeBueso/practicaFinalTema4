

import java.sql.*;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class ConexionBBDD
{
    Connection conn1; 
    
    public void ConexionBBDD()
    {
        conn1 = null;
        try 
        {
            String url1 = "jdbc:mysql://localhost:3306/libreria";
            String user = "root";
            String password = "root";
            
            // objeto = clase.método();
            conn1 = DriverManager.getConnection(url1, user, password);
            
            if (conn1 != null) 
            {
                System.out.println("Conectado a librería..");
            }
            
        }
        catch (SQLException ex)
        {
            
        System.err.println("NO SE HA PODIDO CONECTAR CON LA BBDD");
        try
        {
            if(conn1!=null)
            {
                conn1.rollback();
            }
        }
        catch(SQLException se2)
        {
            se2.printStackTrace();
        }
        ex.printStackTrace();
       
        
        
        }
    }
    
  //Funciones para la tabla clientes
    
    public void InsertaDatosClientes(String dni , String nombre, String apellido, String correo ,String telefono) 
    {
        try
        {
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
            
            sta.executeUpdate("INSERT INTO cliente VALUES('" + dni + "', '" + nombre + "', '" + apellido + "', '" + correo + "', '" + telefono + "')");
            
            conn1.commit();
        }
        catch(SQLException ex)
        {
            System.err.println("ERROR: al AÑADIR");
            try
            {
                if(conn1!=null)
                {
                    conn1.rollback();
                }
            }catch(SQLException se2)
            {
                se2.printStackTrace();
            }
            ex.printStackTrace();
        }
  
    }
    
    public DefaultTableModel BuscarClientes(String dni /*, String nombre, String apellido, String correo ,String telefono*/)
    {
    
      //para dar forma a la tabla
      DefaultTableModel modelo = new DefaultTableModel();
           
        try
        {     
            Statement sta = conn1.createStatement();
            String query = "SELECT * FROM cliente WHERE dni LIKE'" + dni + "%'";
            System.out.println(query);
            ResultSet rs = sta.executeQuery(query);
            //le pasamos el resultado de la consulta
            ResultSetMetaData rsMd = rs.getMetaData();
            //compruebo cuantos resultados me devuelve la consulta
            int numColumnas = rsMd.getColumnCount();
            
            //para que me devuelva las columnas
            modelo.addColumn("dni");
            modelo.addColumn("nombre");
            modelo.addColumn("apellidos");
            modelo.addColumn("correo");
            modelo.addColumn("telefono");
            //pararecorrer los datos de la consulta hago un while
            //me da los datos de una fila
            while(rs.next())
            {
              //declaro un array de tipo objeto el model 
              //nececesitará  objetos
              Object[] filas =  new Object[numColumnas];
                //ahora hago un for para que me vaya dando 
                //los resultados de todas las filas,
                //e ir pasándole todos los datos a la variable filas.
                for(int i= 0; i<numColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);                    
                }
               
            modelo.addRow(filas);
                
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
    
    public void ModificarCliente(String dni,String nuevoNombre,String nuevoApellido,String nuevoCorreo,String nuevoTelefono)
    {   
        try
        {
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
                                        
            sta.executeUpdate ("UPDATE cliente SET nombre = '" + nuevoNombre +"', apellidos = '"+ nuevoApellido +"' , correo = '"+ nuevoCorreo + "', telefono = '"+ nuevoTelefono + " ' WHERE dni = '" + dni + "'" );
            
                                           
            conn1.commit();
            
        }catch(SQLException ex)
        {
            System.err.println("ERROR: al modificar");
            try
            {
                if(conn1!=null)
                {
                    conn1.rollback();
                }
            }catch(SQLException se2)
            {
                se2.printStackTrace();
            }
            ex.printStackTrace();
        }
    
    
    }
     
    public void EliminaCliente(String dni)
    {
        try
        {
            //pongo el autocommit a false, por si falla que no me de error el callback. 
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
            if(dni !="")
            {
            String query = "DELETE FROM cliente WHERE dni = " + dni;
            sta.executeUpdate(query);
            System.out.println(query);
            }
            
            sta.close();
            
            System.out.println("se ha ELIMINADO correctamente");
            
        }
        catch(SQLException ex)
        {
           
            System.err.println("ERROR:al hacer un eliminar"); 
            try
            { 
                if(conn1!=null)
                {
                    conn1.rollback();
                }
            }
            catch(SQLException se2)
            {

                se2.printStackTrace();
            } 
            ex.printStackTrace();

            
        }
    }
    
    public void CerrarConexion()
    {
        try
        {
            conn1.close();
            System.out.println("CONEXIÓN CERRADA CORRECTAMENTE");
        }
        catch(SQLException ex)
        {
            System.err.println("ERROR AL CERRAR LA CONEXIÓN");
            ex.printStackTrace();
        }
    }
    
  //Funciones para tabla libros
      
    
    public void InsertarDatosLibros(String ISBN,String titulo,String autor, String NumPag,String anno_publicacion,
                                    String edicion,String genero,String tipoCubierta, String idioma)
    {
        try
        {
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
            
            sta.executeUpdate("INSERT INTO libro VALUES('" + ISBN + "', '" + titulo + "', '" + autor + "', '" + NumPag + "', '" + anno_publicacion +"' , '"
                                                           + edicion + "' , '"+ genero + "' , '" + tipoCubierta +"' , '" + idioma + "')"); 
            
            conn1.commit();
        }
        catch(SQLException ex)
        {
            System.err.println("ERROR: al AÑADIR");
            try
            {
                if(conn1!=null)
                {
                    conn1.rollback();
                }
            }catch(SQLException se2)
            {
                se2.printStackTrace();
            }
            ex.printStackTrace();
        }
        
    }
    
    public void ModificaLibro(String nuevoISBN,String nuevoTitulo,String nuevoAutor,String nuevaPag,String nuevoAnno,String nuevaEdicion,String nuevoGenero,String nuevaCubierta,String nuevoIdioma)
    {
        try
        {
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
                                        
                sta.executeUpdate ("UPDATE LIBRO SET titulo = '"+ nuevoTitulo +"' , autor = '"+ nuevoAutor + "', NumPag = '"+ nuevaPag + " ', Anno_publicacion= '"+ nuevoAnno +"', edicion = '"+nuevaEdicion+"', genero= '"+nuevoGenero+"' ,tipoCubierta = '"+nuevaCubierta+"' , idioma= '"+nuevoIdioma +"' WHERE ISBN = '" + nuevoISBN + "'" );
            
                                           
            conn1.commit();
            
        }catch(SQLException ex)
        {
            System.err.println("ERROR: al modificar");
            try
            {
                if(conn1!=null)
                {
                    conn1.rollback();
                }
            }catch(SQLException se2)
            {
                se2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
    
    public void EliminaLibro(String ISBN)
    {      
        try
        {
        //pongo el autocommit a false, por si falla que no me de error el callback. 
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
            String query = "DELETE FROM libro WHERE ISBN = " + ISBN ;
            sta.execute(query);
            System.out.println(query);
            conn1.commit();
            sta.close();
            
            System.out.println("se ha ELIMINADO correctamente");
        }
        catch(Exception ex)
        {
             System.err.println("ERROR:al hacer un eliminar"); 
            try
            { 
                if(conn1!=null)
                {
                    conn1.rollback();
                }
            }
            catch(SQLException se2)
            {
                se2.printStackTrace();
            } 
            ex.printStackTrace();
        }
    }
   
    //esta funcion la he demodificar , no hace nada
    public DefaultTableModel BuscaLibro(String ISBN)
    {
        DefaultTableModel modelo = new DefaultTableModel();
        
        try
        {       
            String query = "SELECT * from libro WHERE ISBN = ?";
            PreparedStatement pst = conn1.prepareStatement(query);
            pst.setString(1,ISBN);
            
            ResultSet rs = pst.executeQuery();
            //le pasamos el resultado de la consulta
            ResultSetMetaData rsMd = rs.getMetaData();
            
            //compruebo cuantos resultados me devuelve la consulta
            int numColumnas = rsMd.getColumnCount();
          
            //pararecorrer los datos de la consulta hago un while
            //me da los datos de una fila
            while(rs.next())
            {
              //declaro un array de tipo objeto el model 
              //nececesitará  objetos
              Object[] filas =  new Object[numColumnas];
                //ahora hago un for para que me vaya dando 
                //los resultados de todas las filas,
                //e ir pasándole todos los datos a la variable filas.
                for(int i= 0; i<numColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);       
                }
               
            modelo.addRow(filas);
                
            }
            rs.close();
            pst.close();
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
    
    
    //Funciones para la tabla compra
    
   public void InsertarDatosCompra(String id_libro,String precio,String cantidad,String libro,String dni,String fecha_compra)
   {
     try
        {
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
            
            sta.executeUpdate("INSERT INTO libro VALUES('" + id_libro + "', '" + precio + "', '" + cantidad + "', '" + libro + "', '" + dni +"' , '"
                                                           + fecha_compra + "')"); 
            
            conn1.commit();
        }
        catch(SQLException ex)
        {
            System.err.println("ERROR: al AÑADIR");
            try
            {
                if(conn1!=null)
                {
                    conn1.rollback();
                }
            }catch(SQLException se2)
            {
                se2.printStackTrace();
            }
            ex.printStackTrace();
        }
   } 
    

}


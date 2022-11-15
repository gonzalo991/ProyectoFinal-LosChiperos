package Persistencia;

import static Persistencia.Connect.connect;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Cita;

public class ControllerCitas {

    //Método para obtener todas las citas
    public static List<Cita> getCitas() throws SQLException, ParseException {

    //Definimos e instanciamos una Lista de arreglos
        List<Cita> listarCitas = new ArrayList<Cita>();
        //Se define e inicializa una sentencia 

        Statement stmt = null;
        //Definimos la consulta a la base de datos

        String sql = "SELECT * FROM cita";

        //Entramos en el bloque try and catch
        try {
            //Solicitamos la conexión a la db
            Connection conn;
            conn = connect();
            stmt = conn.createStatement();
            //Inicializamos un set de resultados
            ResultSet rs;
            //Con el set de resultados enviamos la consulta
            rs = stmt.executeQuery(sql);

            //Entramos en un bucle while con la condición de se ejecute mientras que el set de resultados tenga un indice seguido de otro
            while (rs.next()) {
                //Instanciamos la cita
                Cita cita = new Cita();
                //Empezamos a cargar los resultados mediante los setters
                cita.setId(rs.getInt("id"));
                cita.setFecha_cita(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_cita")));// debo convertir dado que parece que en sqlite la celda date son text
                cita.setDosis(rs.getInt("dosis"));
                cita.setVacunatorio(rs.getString("vacunatorio"));
                cita.setId_paciente(rs.getInt("id_paciente"));

                //Con el método add, agregamos a las lista de arreglos listarCitas tosos los objetos cita que resulten de la consulta
                listarCitas.add(cita);

            }

            //Cerramos la conexion a la base de datos
            conn.close();

            //Devolvemos la lista 
            return listarCitas;

            //En Caso de haber algún error se ejecutará el bloque catch enviando una excepción
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listarCitas;
    }

    //Método para obtener el turno que se le dio a un paciente para vacunarse mediante el dni
    public static Cita getCitaByDNI(String dni) throws SQLException, ParseException {

        //Declaro la consulta mysql
        String sql = "select c.id, c.dosis, c.fecha_cita, c.vacunatorio, c.id_paciente from "
                + "pacientes as p "
                + "inner join cita as c on p.id = c.id_paciente "
                + "where p.dni = ?";

        //Instancio la cita
        Cita cita = new Cita();

        try {
            
            //Conexión a la base de datos
            Connection conn;
            conn = connect();
            //Inicializo una sentencia con parámetros y le paso la consulta
            PreparedStatement prepared = conn.prepareStatement(sql);
            //luego le paso los parámetros
            prepared.setString(1, dni);
            //inicializamo el result set y ejecutamos la consulta
            ResultSet rs;
            rs = prepared.executeQuery();

            //Cargamos los datos del result set al objeto cita
            while (rs.next()) {

                cita.setId(rs.getInt("id"));
                cita.setDosis(rs.getInt("dosis"));
                cita.setFecha_cita(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_cita")));// debo convertir dado que parece que en sqlite la celda date son text
                cita.setVacunatorio(rs.getString("vacunatorio"));
                cita.setId_paciente(rs.getInt("id_paciente"));
            }
            
            //Cerramos la conexión a la base de datos y devolvemos el objeto
            conn.close();
            
            return cita;
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
        return cita;
    }

    public static List<Cita> getCitas(String fecha_cita, boolean estado) throws ParseException{
    //Definimos e instanciamos una Lista de arreglos
        List<Cita> listarCitas = new ArrayList<Cita>();
        //Se define e inicializa una sentencia 

        //Statement stmt = null;
        //Definimos la consulta a la base de datos

        String sql = "select c.id, p.nombre, p.apellido, c.dosis, v.vacunatorio, c.fecha_cita, c.estado, c.id_paciente, c.id_vacunatorio from " 
                 +"pacientes as p "
                 +"inner join cita as c on p.id = c.id_paciente " 
                 +"inner join vacunatorio as v on c.id_vacunatorio = v.id "
                 +"where c.fecha_cita = ? and c.estado = ?";

        //Entramos en el bloque try and catch
        try {
              //Conexión a la base de datos
            Connection conn;
            conn = connect();
            //Inicializo una sentencia con parámetros y le paso la consulta
            PreparedStatement prepared = conn.prepareStatement(sql);
            //luego le paso los parámetros
                                                         

            
            prepared.setString(1, fecha_cita);
            prepared.setBoolean(2, estado);
            //inicializamo el result set y ejecutamos la consulta
            ResultSet rs;
            rs = prepared.executeQuery();

            //Entramos en un bucle while con la condición de se ejecute mientras que el set de resultados tenga un indice seguido de otro
            while (rs.next()) {
                //Instanciamos la cita
                Cita cita = new Cita();
                //Empezamos a cargar los resultados mediante los setters
                cita.setId(rs.getInt("id"));
                cita.setFecha_cita(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_cita")));// debo convertir dado que parece que en sqlite la celda date son text
                cita.setDosis(rs.getInt("dosis"));
                cita.setVacunatorio(rs.getString("vacunatorio"));
                cita.setEstado(rs.getBoolean("estado")); 
                cita.setNombre(rs.getString("nombre"));
                cita.setApellido(rs.getString("apellido"));
                cita.setId_paciente(rs.getInt("id_paciente"));
                cita.setId_vacunatorio(rs.getInt("id_vacunatorio"));
                        
               
                //Con el método add, agregamos a las lista de arreglos listarCitas tosos los objetos cita que resulten de la consulta
                listarCitas.add(cita);

            }

            //Cerramos la conexion a la base de datos
            conn.close();

            //Devolvemos la lista 
            return listarCitas;

            //En Caso de haber algún error se ejecutará el bloque catch enviando una excepción
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listarCitas;
    }
    
    //Método para borrar el turno con el id
    public static void CitaDeleteById(int id) {
        String sql = "DELETE FROM cita where id = ?";
       
        try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.executeUpdate();
            System.out.println("Cita eliminada ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //método para borrar el turno con el id del paciente
    public static void CitaDeleteByPaciente(int id_paciente) {
        String sql = "DELETE FROM cita where id_paciente = ?";

        try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setInt(1, id_paciente);
            prepared.executeUpdate();
            System.out.println("Cita eliminada ok");
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

//método para actualizar el día del turno
    public static void CitaUpdate(Cita c) {

        String sql = "UPDATE cita SET fecha_cita = ? , "
                + "dosis = ? ,"
                + "vacunatorio = ? "
                + "WHERE id = ?";
        try {
            Connection conn;
            conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(1, df.format(c.getFecha_cita()));
            pstmt.setInt(2, c.getDosis());
            pstmt.setString(3, c.getVacunatorio());
            pstmt.setInt(4, c.getId());

            pstmt.executeUpdate();
            System.out.println("Paciente actualizado Ok");
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    //Método para acordar un turno
    public static void CitaInsert(Cita c) {
        System.out.println("in controlle"+c.getVacunatorio());
        String sql = "INSERT INTO cita (fecha_cita,dosis,vacunatorio,id_paciente,id_vacunatorio,estado) VALUES(?,?,?,?,?,?)";
        
        try {
            Connection conn;
            conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(1, df.format(c.getFecha_cita()));
            pstmt.setInt(2, c.getDosis());
            pstmt.setString(3, c.getVacunatorio());
            pstmt.setInt(4, c.getId_paciente());
            pstmt.setInt(5, c.getId_vacunatorio());
            pstmt.setBoolean(6, c.isEstado());
            

            pstmt.executeUpdate();
            System.out.println("Cita ingresada Ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

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
import java.util.List;
import model.Aplicacion;

public class ControllerAplicacion {

    public static List<Aplicacion> AllAplicaciones() throws SQLException, ParseException {

        List<Aplicacion> ListA = new ArrayList<Aplicacion>();
        Statement stmt = null;
        String sql = "SELECT * FROM Aplicacion";

        try {

            Connection conn;
            conn = connect();
            stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Aplicacion a = new Aplicacion();
                a.setId(rs.getInt("id"));
                a.setFecha_ult_dosis(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_cita")));// debo convertir dado que parece que en sqlite la celda date son text
                a.setVacunatorio(rs.getString("vacunatorio"));
                a.setLote_vacuna(rs.getString("lote_vacuna"));
                a.setMarca_vacuna(rs.getString("marca_vacuna"));
                a.setNumeroDosis(rs.getInt("num_dosis"));
                a.setId_paciente(rs.getInt("id_paciente"));

                ListA.add(a);

            }
            conn.close();
            return ListA;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ListA;
    }

    public static List<Aplicacion> AplicacionByDNI(String dni) throws SQLException, ParseException {
        
        List<Aplicacion> ListA = new ArrayList<Aplicacion>();

        String sql = "select a.id, a.fecha_ult_dosis, a.vacunatorio, a.lote_vacuna, a.marca_vacuna, a.num_dosis, a.id_paciente " 
                    + "from pacientes as p "
                    + "inner join aplicaciones as a on p.id = a.id_paciente "
                    + "where p.dni = ?";

        try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, dni);
            ResultSet rs;
            rs = prepared.executeQuery();

            while (rs.next()) {
                Aplicacion a = new Aplicacion();
                a.setId(rs.getInt("id"));
                a.setFecha_ult_dosis(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_ult_dosis")));// debo convertir dado que parece que en sqlite la celda date son text
                a.setVacunatorio(rs.getString("vacunatorio"));
                a.setLote_vacuna(rs.getString("lote_vacuna"));
                a.setMarca_vacuna(rs.getString("marca_vacuna"));
                a.setNumeroDosis(rs.getInt("num_dosis"));
                a.setId_paciente(rs.getInt("id_paciente"));
                ListA.add(a);
            }
           
            conn.close();
            return ListA;
            
        } catch (SQLException e) {
          
            System.out.println(e.getMessage());
        }
       
        return ListA;
    }

    public static void AplicacionDeleteById(int id) {
        String sql = "DELETE FROM aplicaciones where id = ?";
        try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.executeUpdate();
            System.out.println("Aplicación eliminada ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void AplicacionDeleteByPaciente(int id_paciente) {
        String sql = "DELETE FROM aplicaciones where id_paciente = ?";
        try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setInt(1, id_paciente);
            prepared.executeUpdate();
            System.out.println("Aplicaciones eliminadas ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void AplicacionUpdate(Aplicacion a) {

        String sql = "UPDATE aplicaciones SET fecha_ult_dosis = ? , "
                + "vacunatorio = ? ,"
                + "lote_vacuna = ? ,"
                + "marca_vacuna = ? ,"
                + "num_dosis = ? "
                + "WHERE id = ?";
        try {
            Connection conn;
            conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(1, df.format(a.getFecha_ult_dosis()));
            pstmt.setString(2, a.getVacunatorio());
            pstmt.setString(3, a.getLote_vacuna());
            pstmt.setString(4, a.getMarca_vacuna());
            pstmt.setInt(5, a.getNumeroDosis());
            pstmt.setInt(6, a.getId());

            pstmt.executeUpdate();
            System.out.println("Aplicación actualizado Ok");
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void AplicacionInsert(Aplicacion a) {

        String sql = "INSERT INTO aplicaciones (fecha_ult_dosis,vacunatorio,lote_vacuna,marca_vacuna,num_dosis,id_paciente) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn;
            conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(1, df.format(a.getFecha_ult_dosis()));
            pstmt.setString(2, a.getVacunatorio());
            pstmt.setString(3, a.getLote_vacuna());
            pstmt.setString(4, a.getMarca_vacuna());
            pstmt.setInt(5, a.getNumeroDosis());
            pstmt.setInt(6, a.getId_paciente());

            pstmt.executeUpdate();
            System.out.println("Aplicacion ingresada Ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

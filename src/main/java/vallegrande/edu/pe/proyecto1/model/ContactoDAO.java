package vallegrande.edu.pe.proyecto1.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    // =========================
    // GUARDAR
    // =========================
    public void guardar(Contacto c) {

        String sql = """
                INSERT INTO contacto
                (nombre, correo, telefono, mensaje)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getMensaje());

            ps.executeUpdate();

            System.out.println("✔ Contacto guardado");

        } catch (SQLException e) {

            System.out.println("✖ Error al guardar");
            System.out.println(e.getMessage());
        }
    }

    // =========================
    // LISTAR
    // =========================
    public List<Contacto> listar() {

        List<Contacto> lista = new ArrayList<>();

        String sql = "SELECT * FROM contacto";

        try (
                Connection con = Conexion.getConexion();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {

            while (rs.next()) {

                Contacto c = new Contacto();

                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("telefono"));
                c.setMensaje(rs.getString("mensaje"));

                lista.add(c);
            }

        } catch (SQLException e) {

            System.out.println("✖ Error al listar");
            System.out.println(e.getMessage());
        }

        return lista;
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Contacto buscarPorId(int id) {

        String sql = "SELECT * FROM contacto WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Contacto c = new Contacto();

                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setCorreo(rs.getString("correo"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setMensaje(rs.getString("mensaje"));

                    return c;
                }
            }

        } catch (SQLException e) {

            System.out.println("✖ Error al buscar");
            System.out.println(e.getMessage());
        }

        return null;
    }

    // =========================
    // ACTUALIZAR
    // =========================
    public boolean actualizar(int id, Contacto actualizado) {

        String sql = """
                UPDATE contacto
                SET nombre = ?, correo = ?, telefono = ?, mensaje = ?
                WHERE id = ?
                """;

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, actualizado.getNombre());
            ps.setString(2, actualizado.getCorreo());
            ps.setString(3, actualizado.getTelefono());
            ps.setString(4, actualizado.getMensaje());
            ps.setInt(5, id);

            int filas = ps.executeUpdate();

            System.out.println("✔ Contacto actualizado");

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("✖ Error al actualizar");
            System.out.println(e.getMessage());

            return false;
        }
    }

    // =========================
    // ELIMINAR
    // =========================
    public boolean eliminar(int id) {

        String sql = "DELETE FROM contacto WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            System.out.println("✔ Contacto eliminado");

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("✖ Error al eliminar");
            System.out.println(e.getMessage());

            return false;
        }
    }
}
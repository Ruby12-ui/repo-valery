package vallegrande.edu.pe.proyecto1.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitaDAO {

    // =========================
    // GUARDAR
    // =========================
    public void guardar(Visita v) {

        String sql = """
                INSERT INTO visita
                (codigo, nombre, apellido, especialidad, nacionalidad, experiencia)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, v.getCodigo());
            ps.setString(2, v.getNombre());
            ps.setString(3, v.getApellidos());
            ps.setString(4, v.getEspecialidad());
            ps.setString(5, v.getNacionalidad());
            ps.setString(5, v.getExperiencia());

            ps.executeUpdate();

            System.out.println("✔ guardada");

        } catch (SQLException e) {

            System.out.println("✖ Error al guardar");
            System.out.println(e.getMessage());
        }
    }

    // =========================
    // LISTAR
    // =========================
    public List<Visita> listar() {

        List<Visita> lista = new ArrayList<>();

        String sql = "SELECT * FROM visita";

        try (
                Connection con = Conexion.getConexion();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {

            while (rs.next()) {

                Visita v = new Visita();

                v.setId(rs.getInt("id"));
                v.setCodigo(rs.getString("codigo"));
                v.setNombre(rs.getString("nombre"));
                v.setApellidos(rs.getString("apellidos"));
                v.setEspecialidad(rs.getString("especialidad"));
                v.setNacionalidad(rs.getString("nacionalidan"));
                v.setExperiencia(rs.getString("experiencia"));

                lista.add(v);
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
    public Visita buscarPorId(int id) {

        String sql = "SELECT * FROM visita WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Visita v = new Visita();

                    v.setId(rs.getInt("id"));
                    v.setCodigo(rs.getString("codigo"));
                    v.setNombre(rs.getString("nombre"));
                    v.setApellidos(rs.getString("apellidos"));
                    v.setEspecialidad(rs.getString("especialidad"));
                    v.setNacionalidad(rs.getString("nacionalidan"));
                    v.setExperiencia(rs.getString("experiencia"));


                    return v;
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
    public boolean actualizar(int id, Visita actualizado) {

        String sql = """
                  INSERT INTO visita
                      (codigo, nombre, apellido, especialidad, nacionalidad, experiencia)
                  VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, actualizado.getCodigo());
            ps.setString(2, actualizado.getNombre());
            ps.setString(3, actualizado.getApellidos());
            ps.setString(4, actualizado.getEspecialidad());
            ps.setString(5, actualizado.getNacionalidad());
            ps.setString(6, actualizado.getExperiencia());
            ps.setInt(7, id);

            int filas = ps.executeUpdate();

            System.out.println("✔ actualizada");

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

        String sql = "DELETE FROM visita WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            System.out.println("✔ eliminada");

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("✖ Error al eliminar");
            System.out.println(e.getMessage());

            return false;
        }
    }
}
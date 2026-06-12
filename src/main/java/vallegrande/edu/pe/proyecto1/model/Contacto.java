package vallegrande.edu.pe.proyecto1.model;

import java.util.Objects;

public class Contacto {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String mensaje;

    // =========================
    // CONSTRUCTORES
    // =========================

    public Contacto() {
    }

    public Contacto(int id, String nombre, String correo,
                    String telefono, String mensaje) {

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    public Contacto(String nombre, String correo,
                    String telefono, String mensaje) {

        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    // =========================
    // GETTERS Y SETTERS
    // =========================

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // =========================
    // TO STRING
    // =========================

    @Override
    public String toString() {

        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }

    // =========================
    // EQUALS
    // =========================

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contacto contacto = (Contacto) o;

        return id == contacto.id;
    }

    // =========================
    // HASHCODE
    // =========================

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
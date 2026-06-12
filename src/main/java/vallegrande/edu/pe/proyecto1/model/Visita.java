package vallegrande.edu.pe.proyecto1.model;

public class Visita {

    private int id;
    private String codigo;
    private String nombre;
    private String apellidos;
    private String especialidad;
    private String nacionalidad;
    private String experiencia;


    // =========================
    // CONSTRUCTORES
    // =========================

    public Visita() {
    }

    public Visita(int id, String nombre, String correo,
                  String telefono, String fecha, String visitantes) {

        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.nacionalidad = nacionalidad;
        this.experiencia = experiencia;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.experiencia = especialidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia =  experiencia;
    }

    // =========================
    // TO STRING
    // =========================

    @Override
    public String toString() {

        return "Visita{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }
}
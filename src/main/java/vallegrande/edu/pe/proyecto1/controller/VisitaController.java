package vallegrande.edu.pe.proyecto1.controller;

import vallegrande.edu.pe.proyecto1.model.Visita;
import vallegrande.edu.pe.proyecto1.model.VisitaDAO;
import vallegrande.edu.pe.proyecto1.view.FrmVisita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class VisitaController implements ActionListener {

    private FrmVisita vista;
    private VisitaDAO dao = new VisitaDAO();

    public VisitaController(FrmVisita vista) {

        this.vista = vista;

        // BOTONES
        vista.btnRegistrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);

        // EVENTO TABLA
        vista.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDatos();
            }
        });

        listar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistrar) {
            guardar();
        }

        if (e.getSource() == vista.btnActualizar) {
            actualizar();
        }

        if (e.getSource() == vista.btnEliminar) {
            eliminar();
        }

        if (e.getSource() == vista.btnNuevo) {
            limpiar();
        }
    }

    // ================= GUARDAR =================
    private void guardar() {

        Visita v = new Visita();

        v.setCodigo(vista.txtCodigo.getText());
        v.setNombre(vista.txtNombre.getText());
        v.setApellidos(vista.txtApellidos.getText());
        v.setEspecialidad(vista.txtEspecialidad.getText());
        v.setNacionalidad(vista.txtNacionalidad.getText());
        v.setExperiencia(vista.txtExperiencia.getText());


        dao.guardar(v);

        JOptionPane.showMessageDialog(null, "registrado");

        listar();
        limpiar();
    }

    // ================= LISTAR =================
    private void listar() {

        List<Visita> lista = dao.listar();

        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"ID", "Codigo", "Nombre", "Apellido", "Especialidad", "Nacionalidad", "Experiencia"}, 0
        );

        for (Visita v : lista) {

            modelo.addRow(new Object[]{
                    v.getId(),
                    v.getCodigo(),
                    v.getNombre(),
                    v.getApellido(),
                    v.getEspecialidad(),
                    v.getNacionalidad(),
                    v.getExperiencia()
            });
        }

        vista.tabla.setModel(modelo);
    }

    // ================= CARGAR DATOS =================
    private void cargarDatos() {

        int fila = vista.tabla.getSelectedRow();

        if (fila == -1) {
            return;
        }

        vista.txtCodigo.setText(vista.tabla.getValueAt(fila, 1).toString());
        vista.txtNombre.setText(vista.tabla.getValueAt(fila, 2).toString());
        vista.txtApellido.setText(vista.tabla.getValueAt(fila, 3).toString());
        vista.tEspecialida.setText(vista.tabla.getValueAt(fila, 4).toString());
        vista.txtNacionalidad.setText(vista.tabla.getValueAt(fila, 5).toString());
        vista.txtExperiencia.setText(vista.tabla.getValueAt(fila, 6).toString());
    }

    // ================= LIMPIAR =================
    private void limpiar() {

        vista.txtCodigo.setText("");
        vista.txtNombre.setText("");
        vista.txtApellidos.setText("");
        vista.txtEspecialidad.setText("");
        vista.txtNacionalidad.setText("");
        vista.txtExperiencia.setText("");

        vista.tabla.clearSelection();
    }

    // ================= ACTUALIZAR =================
    private void actualizar() {

        int fila = vista.tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(null, "Seleccione una fila");

            return;
        }

        int id = (int) vista.tabla.getValueAt(fila, 0);

        Visita v = new Visita();

        v.setId(id);
        v.setCodigo(vista.txtCodigo.getText());
        v.setNombre(vista.txtNombre.getText());
        v.setApellidos(vista.txtApellidos.getText());
        v.setEspecialidad(vista.txtEspecialidad.getText());
        v.setNacionalidad(vista.txtNacionalidad.getText());
        v.setExperiencia(vista.txtExperiencia.getText());

        dao.actualizar(id, v);

        JOptionPane.showMessageDialog(null, "actualizada");

        listar();
        limpiar();
    }

    // ================= ELIMINAR =================
    private void eliminar() {

        int fila = vista.tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(null, "Seleccione una fila");

            return;
        }

        int id = (int) vista.tabla.getValueAt(fila, 0);

        dao.eliminar(id);

        JOptionPane.showMessageDialog(null, "eliminado");

        listar();
        limpiar();
    }
}
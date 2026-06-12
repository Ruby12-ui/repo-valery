package vallegrande.edu.pe.proyecto1.controller;

import vallegrande.edu.pe.proyecto1.model.Contacto;
import vallegrande.edu.pe.proyecto1.model.ContactoDAO;
import vallegrande.edu.pe.proyecto1.view.FrmContacto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class ContactoController implements ActionListener {

    private FrmContacto vista;
    private ContactoDAO dao = new ContactoDAO();

    public ContactoController(FrmContacto vista) {

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

        Contacto c = new Contacto();

        c.setNombre(vista.txtNombre.getText());
        c.setCorreo(vista.txtCorreo.getText());
        c.setTelefono(vista.txtTelefono.getText());
        c.setMensaje(vista.txtMensaje.getText());

        dao.guardar(c);

        JOptionPane.showMessageDialog(null, "Contacto registrado");

        listar();
        limpiar();
    }

    // ================= LISTAR =================
    private void listar() {

        List<Contacto> lista = dao.listar();

        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"ID", "Nombre", "Correo", "Teléfono", "Mensaje"}, 0
        );

        for (Contacto c : lista) {

            modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getCorreo(),
                    c.getTelefono(),
                    c.getMensaje()
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

        vista.txtNombre.setText(vista.tabla.getValueAt(fila, 1).toString());
        vista.txtCorreo.setText(vista.tabla.getValueAt(fila, 2).toString());
        vista.txtTelefono.setText(vista.tabla.getValueAt(fila, 3).toString());
        vista.txtMensaje.setText(vista.tabla.getValueAt(fila, 4).toString());
    }

    // ================= LIMPIAR =================
    private void limpiar() {

        vista.txtNombre.setText("");
        vista.txtCorreo.setText("");
        vista.txtTelefono.setText("");
        vista.txtMensaje.setText("");

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

        Contacto c = new Contacto();

        c.setId(id);
        c.setNombre(vista.txtNombre.getText());
        c.setCorreo(vista.txtCorreo.getText());
        c.setTelefono(vista.txtTelefono.getText());
        c.setMensaje(vista.txtMensaje.getText());

        dao.actualizar(id, c);

        JOptionPane.showMessageDialog(null, "Contacto actualizado");

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

        JOptionPane.showMessageDialog(null, "Contacto eliminado");

        listar();
        limpiar();
    }
}
package vallegrande.edu.pe.proyecto1.view;

import vallegrande.edu.pe.proyecto1.controller.VisitaController;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class FrmVisita extends JFrame {

    // ================= CAMPOS =================
    public JTextField txtCodigo     = new JTextField();
    public JTextField txtNombre     = new JTextField();
    public JTextField txtApellido    = new JTextField();
    public JTextField txtEspecialidad  = new JTextField();
    public JTextField txtNacionalidad     = new JTextField();
    public JTextField txtExperiencia = new JTextField();

    public JTable tabla = new JTable();

    public JButton btnRegistrar  = new JButton("Guardar");
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnEliminar   = new JButton("Eliminar");
    public JButton btnNuevo      = new JButton("Nuevo");

    // ================= COLORES PREMIUM =================
    private final Color negroProfundo = new Color(10, 0, 2);
    private final Color granateOscuro = new Color(74, 0, 7);
    private final Color rojoBase      = new Color(158, 0, 14);
    private final Color rojoBrillo    = new Color(250, 0, 21);
    private final Color blancoBrillo  = new Color(255, 255, 255);

    // ================= ANIMACIÓN =================
    private float glow = 0;
    private boolean subir = true;

    public FrmVisita() {

        setTitle("AGREIMA - GESTIÓN DE VISITAS");

        setSize(1250, 720);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setContentPane(new FondoPremium());

        setLayout(new BorderLayout());

        JPanel top = new JPanel();

        top.setOpaque(false);

        top.setPreferredSize(new Dimension(1200, 90));

        top.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));

        JLabel titulo = new JLabel("AGREIMA - GESTIÓN DE VISITAS AL HUERTO");

        titulo.setForeground(blancoBrillo);

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));

        top.add(titulo);

        add(top, BorderLayout.NORTH);

        JPanel contenido = new JPanel(
                new GridLayout(1, 2, 25, 25)
        );

        contenido.setOpaque(false);

        contenido.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        25,
                        25,
                        25
                )
        );

        JPanel formPanel = crearCard();

        formPanel.setLayout(new BorderLayout());

        JPanel form = new JPanel();

        form.setOpaque(false);

        form.setLayout(
                new GridLayout(12, 1, 12, 12)
        );

        form.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );

        JLabel subtitulo = new JLabel("Formulario de Reserva de Visita");

        subtitulo.setForeground(rojoBrillo);

        subtitulo.setFont(
                new Font("Segoe UI", Font.BOLD, 24)
        );

        form.add(subtitulo);

        form.add(label("codigo"));
        styleField(txtCodigo);
        form.add(txtCodigo);

        form.add(label("Nombre completo"));
        styleField(txtNombre);
        form.add(txtNombre);

        form.add(label("Apellido Completo"));
        styleField(txtApellido);
        form.add(txtApellido);

        form.add(label("Especialidad"));
        styleField(txtEspecialidad);
        form.add(txtEspecialidad);

        form.add(label("Nacionalidad"));
        styleField(txtNacionalidad);
        form.add(txtNacionalidad);

        form.add(label("Experiencia--"));
        styleField(txtExperiencia);
        form.add(txtExperiencia);

        JPanel botones = new JPanel(
                new GridLayout(1, 4, 12, 12)
        );

        botones.setOpaque(false);

        styleButton(btnRegistrar, rojoBrillo);

        styleButton(btnActualizar, rojoBase);

        styleButton(btnEliminar, new Color(70, 0, 0));

        styleButton(btnNuevo, new Color(40, 40, 40));

        botones.add(btnRegistrar);

        botones.add(btnActualizar);

        botones.add(btnEliminar);

        botones.add(btnNuevo);

        form.add(botones);

        formPanel.add(form);

        JPanel tablePanel = crearCard();

        tablePanel.setLayout(new BorderLayout());

        tablePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );

        JLabel tablaTitulo = new JLabel("Registros");

        tablaTitulo.setForeground(rojoBrillo);

        tablaTitulo.setFont(
                new Font("Segoe UI", Font.BOLD, 24)
        );

        tablePanel.add(tablaTitulo, BorderLayout.NORTH);

        tabla.setBackground(
                new Color(25, 5, 8)
        );

        tabla.setForeground(blancoBrillo);

        tabla.setGridColor(
                new Color(80, 0, 10)
        );

        tabla.setRowHeight(34);

        tabla.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );

        tabla.setSelectionBackground(rojoBrillo);

        tabla.setSelectionForeground(blancoBrillo);

        tabla.setShowVerticalLines(false);

        JTableHeader th = tabla.getTableHeader();

        th.setBackground(
                new Color(50, 0, 5)
        );

        th.setForeground(blancoBrillo);

        th.setFont(
                new Font("Segoe UI", Font.BOLD, 13)
        );

        JScrollPane scroll = new JScrollPane(tabla);

        scroll.setBorder(null);

        scroll.getViewport().setBackground(
                new Color(25, 5, 8)
        );

        tablePanel.add(scroll, BorderLayout.CENTER);

        contenido.add(formPanel);

        contenido.add(tablePanel);

        add(contenido, BorderLayout.CENTER);

        new VisitaController(this);

        Timer timer = new Timer(25, e -> {

            if (subir) {
                glow += 0.03f;
            } else {
                glow -= 0.03f;
            }

            if (glow >= 1f) {
                subir = false;
            }

            if (glow <= 0f) {
                subir = true;
            }

            repaint();
        });

        timer.start();
    }

    private JPanel crearCard() {

        return new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(
                        new Color(20, 0, 10, 220)
                );

                g2.fillRoundRect(
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        35,
                        35
                );
            }
        };
    }

    private JLabel label(String text) {

        JLabel l = new JLabel(text);

        l.setForeground(blancoBrillo);

        l.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );

        return l;
    }

    private void styleField(JTextField txt) {

        txt.setBackground(
                new Color(25, 5, 8)
        );

        txt.setForeground(blancoBrillo);

        txt.setCaretColor(blancoBrillo);

        txt.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );
    }

    private void styleButton(JButton b, Color c) {

        b.setBackground(c);

        b.setForeground(blancoBrillo);

        b.setFont(
                new Font("Segoe UI", Font.BOLD, 13)
        );

        b.setFocusPainted(false);

        b.setBorderPainted(false);

        b.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }

    class FondoPremium extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            int w = getWidth();

            int h = getHeight();

            GradientPaint fondo = new GradientPaint(
                    0,
                    0,
                    granateOscuro,
                    w,
                    h,
                    negroProfundo
            );

            g2.setPaint(fondo);

            g2.fillRect(0, 0, w, h);
        }
    }
}
package vallegrande.edu.pe.proyecto1.view;

import javax.swing.*;
import java.awt.*;

public class FrmLogin extends JFrame {

    private JPasswordField txtPassword = new JPasswordField();

    private JButton btnEntrar = new JButton("INGRESAR");

    // ================= ANIMACIÓN =================
    private float anim = 0f;

    private boolean subir = true;

    // ================= COLORES =================
    private final Color sombraProfunda = new Color(10, 0, 2);

    private final Color sombraMedia = new Color(74, 0, 7);

    private final Color rojoBase = new Color(158, 0, 14);

    private final Color rojoBrillo = new Color(250, 0, 21);

    public FrmLogin() {

        setTitle("AGREIMA | ACCESO");

        setSize(550, 350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ================= FONDO =================
        FondoPanel fondo = new FondoPanel();

        fondo.setLayout(new GridBagLayout());

        setContentPane(fondo);

        // ================= CARD =================
        JPanel card = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                // ================= FONDO =================
                g2.setColor(new Color(15, 0, 5, 215));

                g2.fillRoundRect(
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        35,
                        35
                );

                // ================= BORDE =================
                int brillo = (int) (120 + anim * 135);

                GradientPaint borde = new GradientPaint(
                        0,
                        0,
                        new Color(250, 0, 21, brillo),
                        getWidth(),
                        getHeight(),
                        new Color(158, 0, 14, brillo)
                );

                g2.setPaint(borde);

                g2.setStroke(new BasicStroke(3f));

                g2.drawRoundRect(
                        2,
                        2,
                        getWidth() - 5,
                        getHeight() - 5,
                        35,
                        35
                );
            }
        };

        card.setOpaque(false);

        card.setPreferredSize(new Dimension(420, 240));

        card.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10, 20, 10, 20);

        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;

        // ================= TITULO =================
        JLabel titulo = new JLabel("ACCESO AGREIMA");

        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        titulo.setForeground(Color.WHITE);

        c.gridy = 0;

        card.add(titulo, c);

        // ================= TEXTO =================
        JLabel texto = new JLabel("Sistema Premium de Granada Fresca");

        texto.setHorizontalAlignment(SwingConstants.CENTER);

        texto.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        texto.setForeground(new Color(241, 153, 153));

        c.gridy = 1;

        card.add(texto, c);

        // ================= PASSWORD =================
        txtPassword.setPreferredSize(new Dimension(250, 45));

        txtPassword.setBackground(new Color(25, 0, 5));

        txtPassword.setForeground(Color.WHITE);

        txtPassword.setCaretColor(Color.WHITE);

        txtPassword.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(rojoBrillo),
                        "Contraseña",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 12),
                        Color.WHITE
                )
        );

        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        c.gridy = 2;

        card.add(txtPassword, c);

        // ================= BOTÓN =================
        styleButton(btnEntrar);

        c.gridy = 3;

        card.add(btnEntrar, c);

        fondo.add(card);

        // ================= EVENTO =================
        btnEntrar.addActionListener(e -> validar());

        // ================= ANIMACIÓN =================
        Timer timer = new Timer(20, e -> {

            if (subir) {
                anim += 0.04f;
            } else {
                anim -= 0.04f;
            }

            if (anim >= 1f) {
                subir = false;
            }

            if (anim <= 0f) {
                subir = true;
            }

            repaint();
        });

        timer.start();
    }

    // ================= VALIDAR =================
    private void validar() {

        String pass = new String(txtPassword.getPassword());

        if (pass.equals("agrehima")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Bienvenido a AGREIMA"
            );

            new FrmInicioAgreima().setVisible(true);

            this.dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Contraseña incorrecta"
            );
        }
    }

    // ================= BOTÓN =================
    private void styleButton(JButton b) {

        b.setBackground(rojoBase);

        b.setForeground(Color.WHITE);

        b.setFont(new Font("Segoe UI", Font.BOLD, 14));

        b.setFocusPainted(false);

        b.setBorderPainted(false);

        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b.setPreferredSize(new Dimension(200, 40));

        b.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {

                b.setBackground(rojoBrillo);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {

                b.setBackground(rojoBase);
            }
        });
    }

    // ================= FONDO =================
    class FondoPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(
                    RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY
            );

            int w = getWidth();

            int h = getHeight();

            // ================= FONDO =================
            GradientPaint gp = new GradientPaint(
                    0,
                    0,
                    sombraMedia,
                    w,
                    h,
                    sombraProfunda
            );

            g2.setPaint(gp);

            g2.fillRect(0, 0, w, h);

            // ================= BRILLO LATERAL =================
            int glow = (int) (90 + anim * 150);

            GradientPaint left = new GradientPaint(
                    0,
                    0,
                    new Color(250, 0, 21, glow),
                    120,
                    0,
                    new Color(74, 0, 7, 0)
            );

            g2.setPaint(left);

            g2.fillRect(0, 0, 140, h);

            GradientPaint right = new GradientPaint(
                    w,
                    0,
                    new Color(250, 0, 21, glow),
                    w - 120,
                    0,
                    new Color(74, 0, 7, 0)
            );

            g2.setPaint(right);

            g2.fillRect(w - 140, 0, 140, h);

            // ================= LÍNEAS =================
            g2.setColor(new Color(255, 255, 255, 10));

            for (int i = 0; i < w; i += 18) {

                int offset = (int) (anim * 15);

                g2.drawLine(i + offset, 0, i, h);
            }

            // ================= BRILLO CENTRAL =================
            int alpha = (int) (40 + anim * 50);

            g2.setColor(new Color(250, 0, 21, alpha));

            g2.fillOval(
                    w / 2 - 180,
                    h / 2 - 180,
                    360,
                    360
            );
        }
    }
}
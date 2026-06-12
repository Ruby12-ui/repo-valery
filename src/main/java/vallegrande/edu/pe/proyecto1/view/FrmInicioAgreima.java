package vallegrande.edu.pe.proyecto1.view;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class FrmInicioAgreima extends JFrame {

    private JButton btnEntrar = new JButton("Entrar al Sistema");
    private JButton btnContactos = new JButton("Contactos");
    private JButton btnVisitas = new JButton("Visitas");

    private float anim = 0;
    private boolean up = true;

    public FrmInicioAgreima() {

        setTitle("Agreima Premium");

        setSize(850, 520);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(new FondoAgreima());

        setLayout(new GridBagLayout());

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

                g2.setColor(new Color(20, 0, 10, 200));

                g2.fillRoundRect(
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        30,
                        30
                );

                int alpha = (int) (120 + (anim * 100));

                g2.setColor(new Color(220, 20, 60, alpha));

                g2.setStroke(new BasicStroke(2f));

                g2.drawRoundRect(
                        2,
                        2,
                        getWidth() - 4,
                        getHeight() - 4,
                        30,
                        30
                );
            }
        };

        card.setPreferredSize(new Dimension(520, 320));

        card.setOpaque(false);

        card.setLayout(new BorderLayout());

        // ================= TÍTULO =================
        JLabel titulo = new JLabel("🍇 AGREIMA");

        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 34));

        titulo.setForeground(new Color(220, 20, 60));

        // ================= TEXTO =================
        JTextPane info = new JTextPane();

        info.setText(
                "Sistema de gestión de granada fresca\n\n" +
                        "Empresa dedicada a la producción, innovación y exportación agrícola.\n\n" +
                        "Calidad, naturaleza y tecnología en un solo sistema."
        );

        info.setEditable(false);

        info.setOpaque(false);

        info.setForeground(Color.WHITE);

        info.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        StyledDocument doc = info.getStyledDocument();

        SimpleAttributeSet center = new SimpleAttributeSet();

        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        doc.setParagraphAttributes(
                0,
                doc.getLength(),
                center,
                false
        );

        // ================= BOTONES =================
        JPanel botones = new JPanel(
                new GridLayout(1, 3, 10, 10)
        );

        botones.setOpaque(false);

        style(btnEntrar, new Color(220, 20, 60));

        style(btnContactos, new Color(139, 0, 0));

        style(btnVisitas, new Color(80, 0, 0));

        botones.add(btnEntrar);

        botones.add(btnContactos);

        botones.add(btnVisitas);

        card.add(titulo, BorderLayout.NORTH);

        card.add(info, BorderLayout.CENTER);

        card.add(botones, BorderLayout.SOUTH);

        add(card);

        // ================= EVENTOS =================
        btnContactos.addActionListener(
                e -> new FrmContacto().setVisible(true)
        );

        btnVisitas.addActionListener(
                e -> new FrmVisita().setVisible(true)
        );

        btnEntrar.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Bienvenido a Agreima 🍇"
                )
        );

        // ================= ANIMACIÓN =================
        Timer timer = new Timer(30, e -> {

            if (up) {
                anim += 0.03;
            } else {
                anim -= 0.03;
            }

            if (anim > 1) {
                up = false;
            }

            if (anim < 0) {
                up = true;
            }

            repaint();
        });

        timer.start();
    }

    // ================= BOTONES =================
    private void style(JButton b, Color c) {

        b.setBackground(c);

        b.setForeground(Color.WHITE);

        b.setFont(new Font("Segoe UI", Font.BOLD, 13));

        b.setFocusPainted(false);

        b.setBorderPainted(false);

        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {

                b.setBackground(c.brighter());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {

                b.setBackground(c);
            }
        });
    }

    // ================= FONDO =================
    class FondoAgreima extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int w = getWidth();

            int h = getHeight();

            GradientPaint gp = new GradientPaint(
                    0,
                    0,
                    new Color(60, 0, 20),
                    w,
                    h,
                    new Color(0, 0, 0)
            );

            g2.setPaint(gp);

            g2.fillRect(0, 0, w, h);

            int glow = (int) (80 + anim * 120);

            g2.setColor(new Color(180, 0, 40, glow));

            g2.fillRect(0, 0, 120, h);

            g2.setColor(new Color(120, 0, 30, glow));

            g2.fillRect(w - 120, 0, 120, h);

            g2.setColor(new Color(255, 0, 60, 25));

            for (int i = 0; i < w; i += 25) {

                g2.drawLine(i, 0, i, h);
            }
        }
    }
}
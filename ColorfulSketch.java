import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// <applet code="ColorfulSketch" width=400 height=300> </applet>
public class ColorfulSketch extends Applet implements MouseMotionListener, ActionListener {
    int x1, y1, x2, y2;
    boolean flag = false;
    Button b1, b2, b3, b4;
    Color currentColor = Color.black;

    public void init() {
        x1 = 0;
        y1 = 0;
        setLayout(null);  // Use absolute positioning

        b1 = new Button("RED");
        b1.setBounds(50, 250, 80, 20);
        b2 = new Button("BLUE");
        b2.setBounds(150, 250, 80, 20);
        b3 = new Button("GREEN");
        b3.setBounds(250, 250, 80, 20);
        b4 = new Button("YELLOW");
        b4.setBounds(350, 250, 80, 20);

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        addMouseMotionListener(this);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent m) {
                x1 = m.getX();
                y1 = m.getY();
            }
        });
    }

    public void mouseMoved(MouseEvent ME) {
        // Optionally show the coordinates in the status bar or elsewhere
    }

    public void mouseDragged(MouseEvent m) {
        Graphics g = this.getGraphics();
        x2 = m.getX();
        y2 = m.getY();
        g.setColor(currentColor);
        g.drawLine(x1, y1, x2, y2);
        x1 = x2;
        y1 = y2;
    }

    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o == b1) {
            currentColor = Color.red;
        } else if (o == b2) {
            currentColor = Color.blue;
        } else if (o == b3) {
            currentColor = Color.green;
        } else if (o == b4) {
            currentColor = Color.yellow;
        }
    }
}




import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField textField;
    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    public static void main(String[] args) {
        frame = new JFrame("Calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Calculator c = new Calculator();

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        JButton beq1 = new JButton("=");
        JButton ba = new JButton("+");
        JButton bs = new JButton("-");
        JButton bd = new JButton("/");
        JButton bm = new JButton("*");
        JButton beq = new JButton("C");
        JButton be = new JButton(".");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.lightGray);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton[] buttons = {b7, b8, b9, ba, b4, b5, b6, bs, b1, b2, b3, bm, be, b0, beq, bd, beq1};
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(c);
            button.setBackground(Color.white);
            button.setFocusPainted(false);
            panel.add(button);
        }

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
            textField.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            textField.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {
            double te;
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
            textField.setText(s0 + s1 + s2 + "=" + te);
            s0 = Double.toString(te);
            s1 = s2 = "";
        } else {
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double te;
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                s0 = Double.toString(te);
                s1 = s;
                s2 = "";
            }
            textField.setText(s0 + s1 + s2);
        }
    }
}

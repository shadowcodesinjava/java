import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField screen;
    JButton nbtn[] = new JButton[10]; // Changed to 10 for 0-9
    JButton btnPlus, btnMinus, btnMult, btnDiv, btnRem, btnZero, btn2Zero, btnEq, btnDec, btnAC, btnDel;
    JPanel panel;
    Font ff1 = new Font("Ink.Free", Font.BOLD, 35);
    Font ff2 = new Font("Ink.Free", Font.BOLD, 20);

    // Calculation variables
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    calculator() {
        frame = new JFrame();
        frame.setSize(400, 520);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CALCULATOR");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50, 50, 50));

        screen = new JTextField("0");
        screen.setBounds(25, 25, 335, 60);
        screen.setFont(ff1);
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(screen);

        panel = new JPanel();
        panel.setBounds(25, 100, 335, 350);
        panel.setLayout(new GridLayout(5, 4, 10, 10)); // Added gaps
        panel.setBackground(new Color(50, 50, 50));

        // Initialize Number Buttons
        for (int i = 0; i < 10; i++) {
            nbtn[i] = new JButton(String.valueOf(i));
            nbtn[i].setFont(ff2);
            nbtn[i].setBackground(new Color(40, 40, 40));
            nbtn[i].setForeground(Color.WHITE);
            nbtn[i].addActionListener(this);
        }

        // Initialize Function Buttons
        btnPlus = createFuncBtn("+");
        btnMinus = createFuncBtn("-");
        btnMult = createFuncBtn("*");
        btnDiv = createFuncBtn("/");
        btnRem = createFuncBtn("%");
        btn2Zero = createFuncBtn("00");
        btnDec = createFuncBtn(".");
        btnDel = createFuncBtn("DL");
        btnAC = createFuncBtn("AC");
        btnEq = new JButton("=");
        btnEq.setFont(ff2);
        btnEq.setBackground(new Color(255, 215, 0));
        btnEq.addActionListener(this);

        // Add to Panel
        panel.add(btnAC); panel.add(btnDel); panel.add(btnRem); panel.add(btnDiv);
        panel.add(nbtn[7]); panel.add(nbtn[8]); panel.add(nbtn[9]); panel.add(btnMult);
        panel.add(nbtn[4]); panel.add(nbtn[5]); panel.add(nbtn[6]); panel.add(btnMinus);
        panel.add(nbtn[1]); panel.add(nbtn[2]); panel.add(nbtn[3]); panel.add(btnPlus);
        panel.add(btn2Zero); panel.add(nbtn[0]); panel.add(btnDec); panel.add(btnEq);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Helper to style function buttons quickly
    private JButton createFuncBtn(String text) {
        JButton b = new JButton(text);
        b.setFont(ff2);
        b.setBackground(new Color(40, 40, 40));
        b.setForeground(Color.GREEN);
        b.addActionListener(this);
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Number Buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == nbtn[i]) {
                if(screen.getText().equals("0")) screen.setText("");
                screen.setText(screen.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == btn2Zero) screen.setText(screen.getText().concat("00"));
        if (e.getSource() == btnDec) screen.setText(screen.getText().concat("."));

        // Clear and Delete
        if (e.getSource() == btnAC) screen.setText("0");
        if (e.getSource() == btnDel) {
            String str = screen.getText();
            screen.setText("");
            for(int i=0; i<str.length()-1; i++) screen.setText(screen.getText() + str.charAt(i));
        }

        // Operators
        if (e.getSource() == btnPlus) { num1 = Double.parseDouble(screen.getText()); operator = '+'; screen.setText(""); }
        if (e.getSource() == btnMinus) { num1 = Double.parseDouble(screen.getText()); operator = '-'; screen.setText(""); }
        if (e.getSource() == btnMult) { num1 = Double.parseDouble(screen.getText()); operator = '*'; screen.setText(""); }
        if (e.getSource() == btnDiv) { num1 = Double.parseDouble(screen.getText()); operator = '/'; screen.setText(""); }
        if (e.getSource() == btnRem) { num1 = Double.parseDouble(screen.getText()); operator = '%'; screen.setText(""); }

        // Equals
        if (e.getSource() == btnEq) {
            num2 = Double.parseDouble(screen.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
                case '%': result = num1 % num2; break;
            }
            screen.setText(String.valueOf(result));
            num1 = result;
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class CalculatorGroupProject {
    private static String firstnumber = "";
    private static String operand = "";
    private static String secondnumber = "";


    public static void CalculatorGUI() {
        // Create a frame with the title "Calculator"
        JFrame frame = new JFrame("Calculator");

        // Add a title in the Page Start section
        final JLabel title = new JLabel("Calculator", SwingConstants.CENTER);
        Font titleFont = new Font("Courier", Font.BOLD, 30);
        title.setPreferredSize(new Dimension(200, 50));
        title.setFont(titleFont);
        title.setOpaque(true);
        title.setBackground(Color.decode("#D3E8F9"));
        title.setBorder(BorderFactory.createLineBorder(Color.decode("#A9B7C6"), 2));
        title.setForeground(Color.decode("#051821"));
        title.setBackground(Color.decode("#E6F0F5"));
        title.setOpaque(true);
        frame.getContentPane().add(title, BorderLayout.PAGE_START);

        // Add a flow pane in the main center section
        final JPanel pane = new JPanel(new FlowLayout());
        pane.setPreferredSize(new Dimension(230, 250));
        frame.getContentPane().add(pane, BorderLayout.CENTER);

        JTextField operation = new JTextField(16);
        operation.setEditable(false);
        operation.setFont(new Font("Courier", Font.BOLD, 24));

        // Add number buttons
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");

        //Add the operation buttons
        JButton add = new JButton("+");
        JButton subtract = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        JButton clear = new JButton("C");
        JButton equal = new JButton("=");
        JButton delete = new JButton("Delete");

        //Change the equal and delete button sizes
        equal.setPreferredSize(new Dimension(90, 30));
        equal.setBackground(Color.decode("#3E97D1"));
        delete.setPreferredSize(new Dimension(90, 30));
        delete.setBackground(Color.decode("#f96f61"));

        operation.setPreferredSize(new Dimension(100,50));

        pane.add(operation, BorderLayout.CENTER);
        pane.add(one);
        pane.add(two);
        pane.add(three);
        pane.add(four);
        pane.add(five);
        pane.add(six);
        pane.add(seven);
        pane.add(eight);
        pane.add(nine);
        pane.add(zero);

        pane.add(add);
        pane.add(subtract);
        pane.add(multiply);
        pane.add(divide);
        pane.add(clear);
        pane.add(equal);
        pane.add(delete);


        //
        ActionListener numbercheck = new ActionListener() {
            public void actionPerformed(ActionEvent applesauce)
            {   String result = applesauce.getActionCommand();
                if (operand.isEmpty()) {
                    firstnumber += result;
                    operation.setText(firstnumber);
                } else {
                    secondnumber += result;
                    operation.setText(firstnumber + operand + secondnumber);
                }
            }
            }
        ;
        ActionListener operandcheck = new ActionListener() {
            public void actionPerformed(ActionEvent bananapudding)
            {
                operand = bananapudding.getActionCommand();
                operation.setText(firstnumber + operand);
            }
        };

        ActionListener clearcheck = new ActionListener() {
            public void actionPerformed(ActionEvent sourlemon)
            {
                firstnumber = secondnumber = operand = "";
                operation.setText("");
            }
        };

        ActionListener deletecheck = new ActionListener()
        {
            public void actionPerformed(ActionEvent pimpinggoose)
            {
                if (!secondnumber.isEmpty())
                {
                    secondnumber = secondnumber.substring(0,secondnumber.length() -1);
                    operation.setText(firstnumber + operand + secondnumber);
                }
                else if (!operand.isEmpty())
                {
                    operand = "";
                    operation.setText(firstnumber);
                }
                else if (!firstnumber.isEmpty())
                {
                    firstnumber = firstnumber.substring(0,firstnumber.length() -1 );
                    operation.setText(firstnumber);
                }
            }
        };

        ActionListener equalcheck = new ActionListener() 
        {
            public void actionPerformed(ActionEvent swarmingpenguin)
            {
                double result = 0;
                double doublevaluefirstnumber = Double.parseDouble(firstnumber);
                double doublevaluesecondnumber = Double.parseDouble(secondnumber);

                if (operand.equals("+"))
                {
                    result = doublevaluefirstnumber + doublevaluesecondnumber;
                }
                else if (operand.equals("-"))
                {
                    result = doublevaluefirstnumber - doublevaluesecondnumber;
                }
                else if (operand.equals("*"))
                {
                    result = doublevaluefirstnumber * doublevaluesecondnumber;
                }
                else if (operand.equals("/"))
                {
                    if (doublevaluesecondnumber !=0)
                    {
                        result = doublevaluefirstnumber / doublevaluesecondnumber;
                    }
                    else 
                    {
                        operation.setText("Dont do that bro");
                        return;
                    }
                }
                operation.setText(firstnumber + operand + secondnumber +"=" + result);

            }
        }; 
            
        one.addActionListener(numbercheck);
        two.addActionListener(numbercheck);
        three.addActionListener(numbercheck);
        four.addActionListener(numbercheck);
        five.addActionListener(numbercheck);
        six.addActionListener(numbercheck);
        seven.addActionListener(numbercheck);
        eight.addActionListener(numbercheck);
        nine.addActionListener(numbercheck);
        zero.addActionListener(numbercheck);
        add.addActionListener(numbercheck);
        subtract.addActionListener(operandcheck);
        multiply.addActionListener(operandcheck);
        divide.addActionListener(operandcheck);
        clear.addActionListener(clearcheck);
        equal.addActionListener(equalcheck);
        delete.addActionListener(deletecheck);


        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculatorGUI();
            }
        });
    }
}

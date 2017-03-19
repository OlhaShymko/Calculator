import javax.swing.*;
import java.awt.*;


/**
 ��������� BorderLayout ������ ������, ������� �����
 ��������, � � ������� ����� ����������� ��������� ������.
 �������� JTextField � �������� �����, ��� ���� �����
 ���������� �������� �����.
 ������� ������ p1 � GridLayout, �������� �� �� 20 ������
 � ����� ��������� ��� ������ � ����������� ������� ��������
 ������.
 ������� ������ p2 � GridLayout, �������� �� �� ������
 ������ � ����� ��������� ������ p2 � �������� �������
 �������� ������.

 1.������������� ����� Calculator.java ������ � ���� ������
 +, -, /, �	*. ��������� ��� ������ �� ������ p2, � ��������
 ��� ������ �� ��������� ������� �������� ������.
 2.���������� ��� ����� JFormattedTextField � ��������� � ��������
 �������� ��� ������������ ���, ����� ���� ����� �������������
 ������ JTextField. ����� �������� �������� ���� ����� �
 ������������� �� ������� ����, ��� � ��������� �������������.
 3.������������� ����� Calculator.java ���, ����� ��� ������ �
 ������� ��������� � ������� � ������� ����������, ������� ������
 ���� �������� ��� ���:
 Buttons[] numButtons= new Buttons[10];
 �������� 10 ����� ����, ������� ���������� �
 button0=new JButton("0"); ������, ������� ������ ������ �
 ���������	�� � ������. ���������:	��������� � �������� ��� ����
 ��������-������ � ����� 7.

 */


public class Calculator2 {

    // ���������� ���� ����������� ������������:
    JPanel windowContent;
    // JTextField displayField;
    JFormattedTextField displayFormattedField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonDivide;
    JButton buttonMultiply;
    JButton buttonMinus;
    JButton buttonPlus;
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonC;
    JButton buttonPercent;
    JButton buttonDelete;
    JPanel p1;
    JPanel p2;



    // � ������������ ��������� ��� ����������
    // � ����������� �� ������ � ������� ����������
    // BorderLayout � GridLayout


    public Calculator2() {
        windowContent = new JPanel();

        // ������ ����� ��� ���� ������:
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

        // ������� � ���������� ����
        // ��������� ��� � �������� ����� ����
        // displayField = new JTextField(30);
        // windowContent.add("North", displayField);
        //JFormattedTextField � ��������� � ��������
        //�������� �������� ��� ������������ ����� �����
        // JFormattedTextField ������������� ������ JTextField.

        displayFormattedField = new JFormattedTextField();
        displayFormattedField.setHorizontalAlignment(SwingConstants.RIGHT);
        windowContent.add("North",displayFormattedField);

        // ������� ������ � GridLayout
        // ������� �������� 12 ������ - 10 ������ � �������
        // � ������ � ������ � ������ �����

        p1 = new JPanel();
        GridLayout gl = new GridLayout(4,4,5,5);
        p1.setLayout(gl);

        // ������� ������, ��������� �����������
        // ������ JButton, ������� ��������� �����
        // ������ � �������� ���������

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonEqual = new JButton("=");
        buttonPoint = new JButton(".");

        // ��������� ������ �� ������ p1

        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(buttonPoint);
        p1.add(button0);
        p1.add(buttonEqual);


        // �������� ������ p1 � ����������� ������� ����
        windowContent.add("Center", p1);

        //������� ������ �2 � ���������� ������������ GridLayout
        //�� ������� ����� ������ ������: + - / * % C /u21d0
        p2 = new JPanel();
        GridLayout gl2 = new GridLayout(4,1,5,5);
        p2.setLayout(gl2);
        buttonPlus = new JButton("+");
        buttonPlus.setBackground(Color.green);
        buttonMinus = new JButton("-");
        buttonMinus.setBackground(Color.green);
        buttonDivide = new JButton("/");
        buttonDivide.setBackground(Color.green);
        buttonMultiply = new JButton("X");
        buttonMultiply.setBackground(Color.green);
        buttonC = new JButton("\u21d0");
        buttonC.setBackground(Color.CYAN);
        buttonDelete = new JButton("C");
        buttonDelete.setBackground(Color.CYAN);
        buttonPercent = new JButton("%");
        buttonPercent.setBackground(Color.green);

        //��������� ������ �� ������ �2

        p2.add(buttonDelete);
        p2.add(buttonC);
        p2.add(buttonDivide);
        p2.add(buttonMultiply);
        p2.add(buttonMinus);
        p2.add(buttonPlus);
        p2.add(buttonPercent);


        // �������� ������ �2 � ����� ������� ����
        windowContent.add("East", p2);

        //������� ����� � ������ ��� �������� ������
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);

        //������ ������ ���� �����������
        //��� ����, ����� �������� ��� ����������
        frame.pack();

        //���������� ����
        frame.setVisible(true);

        //������� ��������� ��������� ������� � ������������ ���
        //� ������ ������
        Calculator2Engine calcEngine = new Calculator2Engine(this);

        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);

        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        buttonDelete.addActionListener(calcEngine);
        buttonPercent.addActionListener(calcEngine);
        buttonC.addActionListener(calcEngine);


    }

    public static void main(String[] args) {
        Calculator2 calc = new Calculator2();

    }
}


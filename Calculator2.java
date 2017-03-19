import javax.swing.*;
import java.awt.*;


/**
 Назначить BorderLayout панели фрейма, которая будет
 основной, и в которой будут содержаться остальные панели.
 Добавить JTextField в северную часть, для того чтобы
 отображать введённые числа.
 Создать панель p1 с GridLayout, добавить на неё 20 кнопок
 и затем поместить эту панель в центральную область основной
 панели.
 Создать панель p2 с GridLayout, добавить на неё четыре
 кнопки и затем поместить панель p2 в западную область
 основной панели.

 1.Модифицируйте класс Calculator.java обавив в него кнопки
 +, -, /, и	*. Поместите эти кнопки на панель p2, и положите
 эту панель на Восточную область основной панели.
 2.Прочитайте про класс JFormattedTextField в интернете и измените
 исходный код калькулятора так, чтобы этот класс использовался
 вместо JTextField. Целью является создание поля ввода с
 выравниванием по правому краю, как в настоящих калькуляторах.
 3.Модифицируйте класс Calculator.java так, чтобы все кнопки с
 цифрами хранились в массиве с десятью элементами, который должен
 быть объявлен вот так:
 Buttons[] numButtons= new Buttons[10];
 Замените 10 строк кода, которые начинаются с
 button0=new JButton("0"); циклом, который создаёт кнопки и
 добавляет	их в массив. Подсказка:	загляните в исходный код игры
 Крестики-Нолики в главе 7.

 */


public class Calculator2 {

    // Объявление всех компонентов калькулятора:
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



    // В конструкторе создаются все компоненты
    // и добавляются на фреймы с помощью комбинации
    // BorderLayout и GridLayout


    public Calculator2() {
        windowContent = new JPanel();

        // Задаем схему для этой панели:
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

        // Создаем и отображаем поле
        // Добавляем его в северную часть окна
        // displayField = new JTextField(30);
        // windowContent.add("North", displayField);
        //JFormattedTextField в интернете и измените
        //заменяем исходный код калькулятора чтобы класс
        // JFormattedTextField использовался вместо JTextField.

        displayFormattedField = new JFormattedTextField();
        displayFormattedField.setHorizontalAlignment(SwingConstants.RIGHT);
        windowContent.add("North",displayFormattedField);

        // Создаем панель с GridLayout
        // которая содержит 12 кнопок - 10 кнопок с числами
        // и кнопки с точкой и знаком равно

        p1 = new JPanel();
        GridLayout gl = new GridLayout(4,4,5,5);
        p1.setLayout(gl);

        // Создаем кнопки, используя конструктор
        // класса JButton, который принимает текст
        // кнопки в качестве параметра

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

        // Добавляем кнопки на панель p1

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


        // Помещаем панель p1 в центральную область окна
        windowContent.add("Center", p1);

        //Создаем панель р2 с менеджером расположения GridLayout
        //на которой будет четыре кнопки: + - / * % C /u21d0
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

        //Добавляем кнопки на панель р2

        p2.add(buttonDelete);
        p2.add(buttonC);
        p2.add(buttonDivide);
        p2.add(buttonMultiply);
        p2.add(buttonMinus);
        p2.add(buttonPlus);
        p2.add(buttonPercent);


        // помещаем панель р2 в южную область окна
        windowContent.add("East", p2);

        //Создаем фрейм и задаем его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);

        //делаем размер окна достаточным
        //для того, чтобы вместить все компоненты
        frame.pack();

        //отображаем окно
        frame.setVisible(true);

        //Создаем экземпляр слушателя событий и регистриркем его
        //в каждой кнопке
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


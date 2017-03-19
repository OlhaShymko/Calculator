import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calculator2Engine implements ActionListener {

    Calculator2 parent; //Ссылка на калькулятор

    char selectedAction = ' '; // +, -, /, %, ??? X
    double currentResult = 0;
    int bool;
    int znak_index;
    int znak_index1;
    String clickedButtonLabel, dispFieldText1;

    //Конструктор сохраняет ссылку на окно калькулятора
    //в переменной класса "parent"

    Calculator2Engine(Calculator2 parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent event) {
        //Получить источник текущего действия
        JButton clickedButton = (JButton) event.getSource();
        String dispFieldText = parent.displayFormattedField.getText();
        double displayValue = 0;

        znak_index = -1;
        znak_index1 = -1;

        Object src = event.getSource();

        if ("Na nol' delit' nel'za!".equals(dispFieldText)) {
            String clickedButtonLabel = clickedButton.getText();
            parent.displayFormattedField.setText(clickedButtonLabel);
            selectedAction = '&';
            displayValue = 0;
        }

        //Полчить число из дисплея калькулятора, если он не пустой
        //! = оператор отрицания
        if (!"".equals(dispFieldText)) {
            displayValue = Double.parseDouble(dispFieldText);
        }

        //Для каждой кнопки арифметического действия запомнить его:
        //+,-,/, или X сохранить текущее число в переменной currentResult,
        // и очистить дисплей для ввода нового числа

        if (src == parent.buttonPlus) {
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonMinus) {
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonDivide) {
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonMultiply) {
            selectedAction = 'X';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonDelete) {
            selectedAction = 'C';
            currentResult = 0;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonC) {
            selectedAction = '\u21d0';
            String temp = parent.displayFormattedField.getText();
            parent.displayFormattedField.setText(temp.substring(0, temp.length() - 1));
        }


        else if (src == parent.buttonEqual) {

            ravno(displayValue);

        } else if (src == parent.buttonPercent) {

            procent(displayValue);  // дублируем расчет арифметических действий
            // в расчете на процент

        } else if (selectedAction == '^') {
            parent.displayFormattedField.setText(" ");
            String clicked = clickedButton.getText();
            parent.displayFormattedField.setText(clicked);
            selectedAction = '&';

        } else {
                //Для всех цифровых кнопок присоединить надпись на кнопке
                //к надписи на дисплее
                String clickedButtonLabel = clickedButton.getText();
                parent.displayFormattedField.setText(dispFieldText + clickedButtonLabel);

            dispFieldText1 = parent.displayFormattedField.getText();
            znak_index = dispFieldText1.indexOf(".", 0);

            if (znak_index !=(-1)){
                znak_index = znak_index+1;
                znak_index1 = dispFieldText1.indexOf(".", znak_index);
            }
            if (znak_index1 !=(-1)){
                dispFieldText1 = dispFieldText;
                parent.displayFormattedField.setText(dispFieldText1);
            }
            }
        dispFieldText = dispFieldText1;
        if (bool ==1){
            if (src == parent.button1 || src == parent.button2 || src == parent.button3 ||
                    src == parent.button4 || src == parent.button5 || src == parent.button6
                    || src == parent.button7 || src == parent.button8 || src == parent.button9 ||
                    src == parent.button0){
                bool = 0;
                parent.displayFormattedField.setText(""+ clickedButtonLabel);
            }
        }
        }

    private void procent(double displayValue) {
        if (selectedAction == '+') {
            currentResult = currentResult + currentResult * displayValue / 100;
            parent.displayFormattedField.setText("" + currentResult);
        } else if (selectedAction == '-') {
            currentResult = currentResult - currentResult * displayValue / 100;
            parent.displayFormattedField.setText("" + currentResult);
        } else if (selectedAction == '/') {

            //на ноль делить нельзя
            if (displayValue == 0) {
                parent.displayFormattedField.setText("The division by zero is impossible!");

            } else {
                currentResult = currentResult / currentResult * displayValue / 100;
                parent.displayFormattedField.setText("" + currentResult);
            }
        } else if (selectedAction == 'X') {
            currentResult = currentResult * currentResult * displayValue / 100;
            parent.displayFormattedField.setText("" + currentResult);
        }

        selectedAction = '^';
    }

    private void ravno(double displayValue) {
        if (selectedAction == '+') {

            //Совершить арифметическое действие, в зависимости от selectedAction,
            //обновить переменную currentResult и показать результат на дисплее
            currentResult += displayValue;
            //Сконвертировать результат в строку, добавляя его к пустой строке
            // и показать его:
            parent.displayFormattedField.setText("" + currentResult);
        } else if (selectedAction == '-') {
            currentResult -= displayValue;
            parent.displayFormattedField.setText("" + currentResult);
        } else if (selectedAction == '/') {
            //на ноль делить нельзя
            if (displayValue == 0) {
                parent.displayFormattedField.setText("The division by zero is impossible!");
            } else {
                currentResult /= displayValue;
                parent.displayFormattedField.setText("" + currentResult);
            }
        } else if (selectedAction == 'X') {
            currentResult *= displayValue;
            parent.displayFormattedField.setText("" + currentResult);

        }

        selectedAction = '^';
    }

    }




package com.example.integercal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML
    private Button delButton;

    @FXML
    private TextArea displayBox;

    @FXML
    private Button divButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button equalButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button mulButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button negate;

    @FXML
    private Button zeroButton;

    @FXML
    private Button clearButton;

    private Arithmetic arithmetic = new Arithmetic();

    @FXML
    void displayNum0(ActionEvent event) {
        arithmetic.add("0");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum1(ActionEvent event) {
        arithmetic.add("1");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum2(ActionEvent event) {
        arithmetic.add("2");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum3(ActionEvent event) {
        arithmetic.add("3");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum4(ActionEvent event) {
        arithmetic.add("4");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum5(ActionEvent event) {
        arithmetic.add("5");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum6(ActionEvent event) {
        arithmetic.add("6");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum7(ActionEvent event) {
        arithmetic.add("7");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum8(ActionEvent event) {
        arithmetic.add("8");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void displayNum9(ActionEvent event) {
        arithmetic.add("9");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void plus(ActionEvent event) {
        arithmetic.add("+");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void minus(ActionEvent event) {
        arithmetic.add("-");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void multiply(ActionEvent event) {
        arithmetic.add("×");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void divide(ActionEvent event) {
        arithmetic.add("÷");
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void backspace(ActionEvent event) {
        arithmetic.remove();
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void equalCal(ActionEvent event) {
        arithmetic.calculate();
        displayBox.setText(arithmetic.toString());
    }

    @FXML
    void clearAll(ActionEvent event) {
        arithmetic.clear();
        displayBox.setText("");
    }

    @FXML
    void negateNum(ActionEvent event) {
        arithmetic.negate();
        displayBox.setText(arithmetic.toString());
    }
}

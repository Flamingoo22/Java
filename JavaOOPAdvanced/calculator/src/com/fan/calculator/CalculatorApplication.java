package com.fan.calculator;

import com.fan.calculator.models.Calculator;
import java.util.Scanner;

public class CalculatorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("===============CALCULATOR==================");
		System.out.println("Please enter the first operand:");
		double op1 = s.nextDouble();
		cal.setAnswers(op1);
		System.out.println("Please enter the operator:");
		String operator1 = s.next();
		cal.setOperator(operator1);
		while(!operator1.equals("=")) {
		System.out.println("Please enter the operand:");
		double op2 = s.nextDouble();
		cal.setOperand(op2);
		cal.performOperation();
		System.out.println("Please enter the operator:");
		operator1 = s.next();
		cal.setOperator(operator1);
		}
		System.out.format("Answer is: %.2f", cal.getAnswers());

	}

}

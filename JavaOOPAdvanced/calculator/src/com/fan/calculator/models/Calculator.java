package com.fan.calculator.models;

public class Calculator {
	private double operand;
	private String operator;
	private double answers;
	
	public Calculator() {
		// TODO Auto-generated constructor stub
	this.operand = 0;
	this.operator = "";
	this.answers = 0;
	}
	
	
	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public double getAnswers() {
		return answers;
	}


	public void setAnswers(double answers) {
		this.answers = answers;
	}


	public double getOperand() {
		return operand;
	}


	public void setOperand(double op) {
		operand=(op);
	}
	
	
	public void performOperation() {
		if(operator.equals("+")){
			answers += operand;
		}
		else if (operator.equals("-")) {
			answers -= operand;
		}
		else if (operator.equals("*")) {
			answers *= operand;
		}
		else if (operator.equals("/")) {
			answers /= operand;
		}
		else if (operator.equals("=")) {
		}
		else {
			System.out.println("Please enter a valid operator");
		}
	}
	


}

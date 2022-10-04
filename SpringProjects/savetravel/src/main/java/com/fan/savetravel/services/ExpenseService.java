package com.fan.savetravel.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fan.savetravel.models.Expense;
import com.fan.savetravel.repositories.ExpenseRepo;
@Service
public class ExpenseService {
	private final ExpenseRepo expenseRepo;
	
	
	public ExpenseService(ExpenseRepo expenseRepo) {
		// TODO Auto-generated constructor stub
		this.expenseRepo = expenseRepo;
	}
	
	public ArrayList<Expense> allExpense(){
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		expenses.addAll(this.expenseRepo.findAll());
		return expenses;
	}
	
	public Expense saveExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
	public Expense findExpenseById(Long Id) {
		Optional<Expense> optionalExpense = this.expenseRepo.findById(Id); //What exactly is optional?
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
		
	public void deleteExpenseById(Long Id) {
		this.expenseRepo.deleteById(Id);
	}
	

}

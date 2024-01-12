package com.codingdojo.spring.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.spring.safetravels.models.Expense;
import com.codingdojo.spring.safetravels.repositories.ExpenseRepo;

@Service
public class ExpenseService {
	private final ExpenseRepo expenseRepo;
	
	public ExpenseService (ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public void deleteExpense(Expense expense) {
		expenseRepo.delete(expense);
	}
}

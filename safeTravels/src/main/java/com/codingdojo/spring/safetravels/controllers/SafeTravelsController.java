package com.codingdojo.spring.safetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.spring.safetravels.models.Expense;
import com.codingdojo.spring.safetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class SafeTravelsController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String expensesRedirect() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String expenses(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
		
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "edit.jsp";
	}
	
	@PostMapping("/expenses/edit/{id}")
	public String edit(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			model.addAttribute("expenses", expenseService.findExpense(id));
			return "redirect:/edit/{id}";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		Expense expense = expenseService.findExpense(id);
		expenseService.deleteExpense(expense);
		return "redirect:/expenses"; 
	}
}

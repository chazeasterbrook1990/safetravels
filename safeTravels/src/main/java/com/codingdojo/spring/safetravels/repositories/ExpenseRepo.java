package com.codingdojo.spring.safetravels.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.spring.safetravels.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense,Long>{
	List<Expense> findAll();
}

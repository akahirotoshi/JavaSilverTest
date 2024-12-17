package com.example.app.service;

import java.util.List;

import com.example.app.domain.Problem;

public interface ProblemService {
	
	List<Problem> getProblemList() throws Exception;
	Problem getProblemById(Integer id) throws Exception;
	void addProblem(Problem problem) throws Exception;
	void editProblem(Problem problem) throws Exception;
	void deleteProblem(Integer id) throws Exception;


}

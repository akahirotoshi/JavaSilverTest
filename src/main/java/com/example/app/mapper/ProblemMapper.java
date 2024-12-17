package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Problem;

public interface ProblemMapper {
	
	List<Problem> selectAll() throws Exception;
	Problem selectById(Integer id) throws Exception;
	void insert(Problem problem) throws Exception;
	void update(Problem problem) throws Exception;
	void delete(Integer id) throws Exception;

}

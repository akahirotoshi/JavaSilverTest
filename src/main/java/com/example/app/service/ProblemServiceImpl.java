package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Problem;
import com.example.app.mapper.ProblemMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {
	
	private final ProblemMapper problemMapper;
	
	
	@Override
	public List<Problem> getProblemList() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return problemMapper.selectAll();
	}

	@Override
	public Problem getProblemById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return problemMapper.selectById(id);
	}

	@Override
	public void addProblem(Problem problem) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		problemMapper.insert(problem);
	}

	@Override
	public void editProblem(Problem problem) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		problemMapper.update(problem);
	}

	@Override
	public void deleteProblem(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		problemMapper.delete(id);
	}

}

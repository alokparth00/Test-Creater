package com.example.demo.test.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.question.model.Question;
import com.example.demo.question.repository.QuestionRepository;
import com.example.demo.test.model.Test;
import com.example.demo.test.model.TestDetails;
import com.example.demo.test.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	
	private final TestRepository testRepository;
	private final QuestionRepository questionRepository;
	
	public void insertTest(TestDetails details) {
		insertQuestion(details.getQuestions());
		testRepository.save(Test.builder().category(details.getCategory())
				.description(details.getDescription()).difficultyLevel(details.getDifficultyLevel())
				.passingScore(details.getPassingScore())
				.duration(details.getDuration()).startTime(details.getStartTime())
				.endTime(details.getEndTime()).questions(details.getQuestions()).build());
	}
	
	private void insertQuestion(Set<Question> questions) {
		for(Question q:questions) {
			questionRepository.save(q);
		}
	}
	
	public List<Test> getAllTest() {
		return testRepository.findAll();
	}

}

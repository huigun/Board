package com.gyojincompany.gyojinboard.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gyojincompany.gyojinboard.entity.Answer;
import com.gyojincompany.gyojinboard.entity.Question;
import com.gyojincompany.gyojinboard.entity.SiteMember;
import com.gyojincompany.gyojinboard.exception.DataNotFoundException;
import com.gyojincompany.gyojinboard.repository.AnswerRepository;
import com.gyojincompany.gyojinboard.repository.MemberRepository;
import com.gyojincompany.gyojinboard.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final MemberService memberService;
	
	public void answerCreate(String content, Integer id, String username) {
		
		Optional<Question> optQuestion = questionRepository.findById(id);
		Question question = optQuestion.get();
		
		SiteMember siteMember = memberService.getMemberInfo(username);
		
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateTime(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setWriter(siteMember);
		
		answerRepository.save(answer);		
	}
	
	public Answer getAnswer(Integer id) {
		Optional<Answer> optAnswer = answerRepository.findById(id);
		
		if(optAnswer.isPresent()) {
			return optAnswer.get();
		} else {
			throw new DataNotFoundException("해당 답변이 없습니다.");
		}
	}
	
	public void answerModify(String content, Answer answer) {
		
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		answerRepository.save(answer);
	}
	
	public void answerDelete(Integer id) {
		
		answerRepository.deleteById(id);
	}
	
	public void answerLike(Answer answer, SiteMember siteMember) {
		answer.getLiker().add(siteMember);
		//현재 답변글이 가지고 있는 좋아요를 누른 회원의 집합을 가져와서 새로운 좋아요 회원 객체를 추가
		answerRepository.save(answer);
	}
}

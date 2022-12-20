package com.gyojincompany.gyojinboard.question;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.gyojincompany.gyojinboard.dto.QuestionDto;
import com.gyojincompany.gyojinboard.entity.Question;
import com.gyojincompany.gyojinboard.repository.QuestionRepository;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class MappingTest {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	public void mappingTest1() {
		//QuestionDto questionDto = new QuestionDto();
		Optional<Question> question1 = questionRepository.findById(2);		
		
		Question question = question1.get();
		
		PropertyMap<Question, QuestionDto> entityDto = new PropertyMap<Question,QuestionDto>() {

			@Override
			protected void configure() {
				// TODO Auto-generated method stub
				map().setAnswers(source.getAnswerList());
			}			
		};
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(entityDto);
		
		QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
		
		System.out.println(questionDto.getId());
		System.out.println(questionDto.getSubject());
		
	}
	
}

package com.gyojincompany.gyojinboard.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.gyojincompany.gyojinboard.entity.Answer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDto {
	
	private Integer id;
	private String subject;
	private String content;
	private LocalDateTime createDate;
	
	private List<Answer> answers;
	
}

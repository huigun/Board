package com.gyojincompany.gyojinboard.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class QuestionForm {
	
	@NotEmpty(message = "제목은 필수입력사항입니다!")
	@Size(max = 100, message = "제목은 100자 이하만 가능합니다.")//100byte를 넘기면 에러	
	private String subject;
	
	@NotEmpty(message = "내용은 필수입력사항입니다!")
	@Size(min = 10, message = "내용은 10자 이상 입력하셔야 합니다.")//10byte가 안되면 에러
	private String content;
}

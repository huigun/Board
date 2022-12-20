package com.gyojincompany.gyojinboard.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;//질문게시판 번호
	
	@Column(length = 100)
	private String subject;//질문게시판 제목
	
	@Column(length = 1000)
	private String content;//질문게시판 내용
	
	private LocalDateTime createDate;//글 등록일시
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;//1:n 구조
	
	@ManyToOne
	private SiteMember writer;//글쓴이
	
	private LocalDateTime modifyDate;//글 수정일시
	
	@ManyToMany
	//다대다 관계 일때 새로운 question_liker 테이블이 생성되고, 필드값은 각 테이블의 기본키가 된다. 
	private Set<SiteMember> liker;//좋아요 누른 아이디(중복 방지를 위해 set 자료구조로 설정)
	//set의 원소의 개수가 곧 좋아요의 수가 됨
	
}

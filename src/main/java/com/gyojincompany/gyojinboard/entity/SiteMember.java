package com.gyojincompany.gyojinboard.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class SiteMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer id;
	
	@Column(unique = true)//유저네임 칼럼에 유니크 속성 부여->중복된 값 저장 불허용
	private String username;//아이디
	
	private String password;
	
	private String email;

}

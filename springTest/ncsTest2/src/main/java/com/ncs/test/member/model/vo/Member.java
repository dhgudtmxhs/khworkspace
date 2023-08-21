package com.ncs.test.member.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Member {

	private String memberId;

	private String memberPwd;

	private String memberName;

	private Date memberEnrollDate; // (import : java.sql.Date)
	
}

package edu.kh.project.member.model.dto;
// vo 	: value object -> 값 자체를 나타냄
// dto 	: data transfer object -> 객체간 계층간의 값 교환? 데이터를 전달할때 사용하는용도?

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {

	private int memberNo;
    private String memberEmail;
    private String memberPw;
    private String memberNickname;
    private String memberTel;
    private String memberAddress;
    private String profileImage;
    private String enrollDate;
    private String memberDeleteFlag;
    private int authority;
	
}

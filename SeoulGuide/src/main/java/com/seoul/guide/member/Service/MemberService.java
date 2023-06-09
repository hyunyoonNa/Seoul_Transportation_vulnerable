package com.seoul.guide.member.Service;

import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.seoul.guide.member.DTO.MemberDTO;

public interface MemberService {
	void join(MemberDTO member, MultipartFile file) throws Exception;
	void login(String email, String password) throws Exception;
	public int nicknameCheck(String nickname) throws Exception;
	public Integer selectuserid(String email) throws Exception;
	
	public void fileView(Integer id, OutputStream out) throws Exception;
}

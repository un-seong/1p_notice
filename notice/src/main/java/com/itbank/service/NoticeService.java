package com.itbank.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.exception.categoryNull;
import com.itbank.exception.notUserPhoneException;
import com.itbank.model.NoticeTableDTO;
import com.itbank.model.NoticeUserDTO;
import com.itbank.repository.NoticeTableDAO;
import com.itbank.repository.NoticeUserDAO;

@Service
public class NoticeService {

	// 유저 비밀번호 해쉬코드화
	public String getHash(String userpw) {
		String hash = null;
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(userpw.getBytes());
			hash = String.format("%0128x", new BigInteger(1, md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		return hash;
	}	
	
	// 회원가입 시 전화번호 번호 말고 다른거 입력 시 예외 발생
	public boolean notNumber(String phone) {
		String filter = "0123456789";
		for(char ch : phone.toCharArray()) {
			if(filter.contains(ch+"") == false) {
				return true;
			}
		}
		return false;
	}
	
	
	@Autowired NoticeUserDAO userDAO;
	
	@Autowired NoticeTableDAO tableDAO;
	
	// 회원가입
	public int signup(NoticeUserDTO dto) throws notUserPhoneException {
		if(notNumber(dto.getPhone())) {
			throw new notUserPhoneException();
		}
		dto.setUserpw(getHash(dto.getUserpw()));
		return userDAO.userInsert(dto);
	}

	// 로그인
	public NoticeUserDTO login(NoticeUserDTO dto) {
		dto.setUserpw(getHash(dto.getUserpw()));
		return userDAO.userLogin(dto);
	}
	
	// 글 등록
	public int write(NoticeTableDTO tabledto) {
		return tableDAO.insertTable(tabledto);
	}
	
	// 등록 글 리스트
	public List<NoticeTableDTO> getList() {
		return tableDAO.selectTable();
	}
	
	// 등록 글 상세보기
	public NoticeTableDTO getOneList(int idx) {
		return tableDAO.selectOneTable(idx);
	}

	// 카테고리 별 글 보기
	public List<NoticeTableDTO> getSelectList(String category) throws categoryNull {
		if(category == "") {
			throw new categoryNull();
		}
		return tableDAO.selectCategoryList(category);
	}

	public int tableDelete(String userpw1) {
		return tableDAO.deleteCheck(getHash(userpw1));
	}




	
	

	

	







}

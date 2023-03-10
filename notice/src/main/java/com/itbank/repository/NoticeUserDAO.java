package com.itbank.repository;

import org.springframework.stereotype.Repository;

import com.itbank.model.NoticeUserDTO;

@Repository
public interface NoticeUserDAO {

	int userInsert(NoticeUserDTO dto);

	NoticeUserDTO userLogin(NoticeUserDTO dto);

	

}

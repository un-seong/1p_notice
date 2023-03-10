package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.NoticeTableDTO;

@Repository
public interface NoticeTableDAO {

	int insertTable(NoticeTableDTO tabledto);

	List<NoticeTableDTO> selectTable();

	NoticeTableDTO selectOneTable(int idx);

	List<NoticeTableDTO> selectCategoryList(String category);

	int deleteCheck(String userpw);







}

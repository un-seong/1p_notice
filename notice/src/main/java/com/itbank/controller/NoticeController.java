package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.exception.categoryNull;
import com.itbank.exception.notUserPhoneException;
import com.itbank.model.NoticeTableDTO;
import com.itbank.model.NoticeUserDTO;
import com.itbank.service.NoticeService;

@Controller
@SessionAttributes("loginComplete")
public class NoticeController {
	
	@Autowired NoticeService noticeService;
	
	@GetMapping("/home")
	public ModelAndView getlist() {
		ModelAndView mav = new ModelAndView();
		List<NoticeTableDTO> list = noticeService.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/home")
	public ModelAndView getSelectList(String category) throws categoryNull {
		ModelAndView mav = new ModelAndView("home");
		List<NoticeTableDTO> list = noticeService.getSelectList(category);
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/login") 
		public void login() {}
	
	@PostMapping("/login")
		public ModelAndView login(NoticeUserDTO dto) {
			ModelAndView mav = new ModelAndView("redirect:/home");
			NoticeUserDTO loginComplete = noticeService.login(dto);
			mav.addObject("loginComplete", loginComplete);
			return mav;
	}
	
	@GetMapping("/logout")
		public String logout(SessionStatus loginComplete) {
			loginComplete.setComplete();
		return "redirect:/";
	}
		
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public ModelAndView signup(NoticeUserDTO dto) throws notUserPhoneException {
		ModelAndView mav = new ModelAndView("home");
		int row = noticeService.signup(dto);
		System.out.println(row != 0 ? "가입성공" : "가입실패");
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(NoticeTableDTO tabledto) {
		int row = noticeService.write(tabledto);
		System.out.println(row != 0 ? "글 등록 성공" : "글등록 실패");		
		return "redirect:/";
	}
	
	@GetMapping("/title/{idx}")
	public ModelAndView title(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("title");
		NoticeTableDTO dto = noticeService.getOneList(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete")
	public void delete() {}
	
	@PostMapping("/delete")
	public String delete(String userpw) {
		int row = noticeService.tableDelete(userpw);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		System.out.println(userpw);
		return "redirect:/home";		
	}
	
		
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView notCorrectIdPw(IllegalArgumentException e) {
		System.out.println("예외 발생 : " + e);
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("msg", "ID와 비밀번호를 확인하세요");
		return mav;
	}
	
	@ExceptionHandler(notUserPhoneException.class)
	public ModelAndView notUserPassword(notUserPhoneException e) {
		System.out.println("예외 발생 : " + e);
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("msg", "숫자만 입력하세요");
		return mav;
	}
	
	@ExceptionHandler(categoryNull.class)
	public ModelAndView categoryNull(categoryNull e) {
		System.out.println("예외 발생 : " + e);
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("msg", "카테고리를 입력하세요");
		return mav;
	}
	
}

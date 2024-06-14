package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

@Controller
public class BoardController {
	//외부의 요청을 받아들이기 위한 클래스
	//jsp로 치면 Servlet과 유사한 클래스
	BoardService service;
	
	public BoardController() {
		System.out.println("--BoardController의 기본생성자--");
	}
	
	public BoardController(BoardService service) {
		this.service = service;
		System.out.println("--service객체를 인자로 받는 BoardController의 생성자--");
	}
	
	//사용자가 요청한 url을 접수
	@RequestMapping("/list.do")
	public String list( Model model ) {
		//Model : Servlet과 Controller의 중간 매개체
		//오로지 바인딩만을 목적으로 사용하는 객체
		
		List<String> list = service.selectList();
		
		//DB에서 가져온 결과를 담고 있는 list를 바인딩
		model.addAttribute("list", list);
		
		//포워딩
		return "fruit_list";
		
	}
	
}

























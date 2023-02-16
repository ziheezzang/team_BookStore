package com.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController { //컨트롤러를 통해 화면을 출력하게 된다. ( 달력 페이지 )
	
		@GetMapping("getCheck")
		public String getCheck() {
			return "event/getCheck";
		}
}

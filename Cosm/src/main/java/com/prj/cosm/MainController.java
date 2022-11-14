package com.prj.cosm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.plan.service.PlanVO;

@Controller
@CrossOrigin("*")
public class MainController {
	
	@Autowired
	PlanService service;
	
	@RequestMapping("/")
	public String main(Model model) {
		return "index";
	}

	@GetMapping("/plan")
	@ResponseBody
	public List<PlanVO> plan() {
		
		return service.selectPlanList();
	}
	
	@GetMapping("/planList")
	public String planList() {
		return "layout/planList";
	}
}

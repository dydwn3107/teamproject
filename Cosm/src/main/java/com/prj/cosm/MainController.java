package com.prj.cosm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prj.cosm.produce.plan.service.PlanService;

@Controller
public class MainController {
	
	@Autowired
	PlanService service;
	
	@RequestMapping("/")
	public String main(Model model) {
		return "index";
	}

	@RequestMapping("/plaList")
	public String plan(Model model) {
		model.addAttribute("list", service.selectPlanList());
		return "layout/planList";
	}
}

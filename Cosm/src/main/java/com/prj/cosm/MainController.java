package com.prj.cosm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.plan.service.PlanVO;

@Controller
@CrossOrigin("*")
public class MainController {

	@Autowired
	PlanService service;

	// 홈
	@RequestMapping("/")
	public String main(Model model) {
		return "index";
	}

	// 생산계획 list에 ajax주는 것
	@GetMapping("/plan")
	@ResponseBody
	public List<PlanVO> plan() {
		return service.selectPlanList();
	}

	// 생산계획 list 화면페이지 plan_no값 넘겨줌
	@GetMapping("/planList")
	public String planList(Model model) {
		model.addAttribute("info", service.selectPlanNo());
		return "layout/planList";
	}

	// 생산계획 등록
	@PostMapping("planInsert")
	public String insertPlanInfo(PlanVO planVO) {
		service.insertPlanInfo(planVO);
		return "redirect:planList";
	}

	// 생산계획 수정
	@PostMapping("planUpdate")
	public String updatePlanInfo(PlanVO planVO, RedirectAttributes ratt) {
		int result = service.updatePlanInfo(planVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:planList";
	}

	// 생산계획 삭제
	@GetMapping("planDelete")
	public String deletePlanInfo(int planNo, RedirectAttributes ratt) {
		int result = service.deletePlanInfo(planNo);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 삭제되지 않았습니다.");
		}
		return "redirect:planList";
	}

}

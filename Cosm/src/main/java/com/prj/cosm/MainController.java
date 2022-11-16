package com.prj.cosm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.produce.instruct.service.InsService;
import com.prj.cosm.produce.instruct.service.InsVO;
import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.plan.service.PlanVO;

@Controller
@CrossOrigin("*")
public class MainController {

	@Autowired
	PlanService service;
	@Autowired
	InsService insService;

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

	// 생산지시 list에 ajax주는 것
	@GetMapping("/instruct")
	@ResponseBody
	public List<Map<String, Object>> instruct() {
		return insService.selectInsList();
	}

	// 생산지시 페이지이동
	@GetMapping("/instructList")
	public String instructList(Model model) {
		model.addAttribute("info", insService.selectInsNo());
		return "layout/instructList";
	}

	// 생산지시 등록
	@PostMapping("insInsert")
	public String insertInsInfo(InsVO insVO) {
		insService.insertInsInfo(insVO);
		return "redirect:instructList";
	}

	// 생산지시 수정
	@PostMapping("insUpdate")
	public String updateInsInfo(InsVO insVO, RedirectAttributes ratt) {
		int result = insService.updateInsInfo(insVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:instructList";
	}

	// 생산지시 삭제
	@GetMapping("insDelete")
	public String deleteInsInfo(int instructNo, RedirectAttributes ratt) {
		int result = insService.deleteInsInfo(instructNo);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 삭제되지 않았습니다.");
		}
		return "redirect:instructList";
	}

	// 완제품 페이지 이동
	@GetMapping("/regist")
	public String regist(Model model) {

		return "layout/regist";
	}

	// BOM 페이지 이동
	@GetMapping("/bom")
	public String bom(Model model) {

		return "layout/bom";
	}

	// 제품 페이지 이동
	@GetMapping("/product")
	public String product(Model model) {

		return "layout/product";
	}

	// 불량관리 페이지 이동
	@GetMapping("/proError")
	public String proError(Model model) {

		return "layout/proError";
	}

}

package com.prj.cosm.produce.plan.mapper;

import java.util.List;

import com.prj.cosm.produce.plan.service.PlanVO;

public interface PlanMapper {
	
	//전체조회 
		public List<PlanVO> getPlanList();
		
		//상세조회
		public PlanVO getPlanNo();
		
		//등록
		public int insertPlan(PlanVO planVO);
		
		//수정
		public int updatePlan(PlanVO planVO);
}

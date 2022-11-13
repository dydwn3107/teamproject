package com.prj.cosm.produce.plan.service;

import java.util.List;

public interface PlanService {
	//전체조회 
	public List<PlanVO> selectPlanList();
	
	//상세조회
	public PlanVO selectPlanNo();
	
	//등록
	public int insertPlanInfo(PlanVO planVO);
	
	//수정
	public int updatePlanInfo(PlanVO planVO);
	

}

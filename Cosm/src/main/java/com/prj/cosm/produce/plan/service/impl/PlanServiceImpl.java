package com.prj.cosm.produce.plan.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.plan.mapper.PlanMapper;
import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.plan.service.PlanVO;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanMapper mapper;

	@Override
	public List<PlanVO> selectPlanList() {
		return mapper.getPlanList();
	}

	@Override
	public PlanVO selectPlanNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertPlanInfo(PlanVO planVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePlanInfo(PlanVO planVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}

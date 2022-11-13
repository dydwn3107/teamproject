package com.prj.cosm.produce.plan.service;

import java.util.Date;

import lombok.Data;

@Data
public class PlanVO {
	private int planNo;
	private int planQuantity;
	private Date planStart;
	private Date planEnd;
	private String planEx;
	private int planProductNo;
	private int planBomNo;
	private int planOrderNo;
}

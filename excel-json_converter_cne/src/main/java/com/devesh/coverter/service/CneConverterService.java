package com.devesh.coverter.service;

import java.util.List;

import com.devesh.coverter.domain.PlanType;

public interface CneConverterService {

	public List<PlanType> getCneJson(String excelPath);
}

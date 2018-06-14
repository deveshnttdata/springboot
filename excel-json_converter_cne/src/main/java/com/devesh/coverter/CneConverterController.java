package com.devesh.coverter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.coverter.domain.PlanType;
import com.devesh.coverter.service.CneConverterService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CneConverterController {

	@Autowired
	CneConverterService service;
	
	@Autowired
	CneConverterConstants constants;
	
	@RequestMapping("/cne")
	public List<PlanType> getPlanTypejson(@RequestParam(name="excelPath") String excelPath){
		
		List<PlanType> listPlanType = service.getCneJson(excelPath);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(constants.getJsonPath()+"cne.json"),listPlanType);
		} catch (JsonGenerationException | JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPlanType;
	}
	
}

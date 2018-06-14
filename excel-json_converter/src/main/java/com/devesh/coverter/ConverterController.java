package com.devesh.coverter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.coverter.domain.Provider;
import com.devesh.coverter.service.ConverterService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ConverterController {

	@Autowired
	ConverterService service;
	
	@Autowired
	ConverterConstants constants;
	
	@RequestMapping("/pnd")
	public List<Provider> getProviderNetworkJson(@RequestParam(name="excelPath")String excelPath){
		
		
		//List<Provider> listProvider = service.getProviderNetworkJson("pnd.xlsx");
		List<Provider> listProvider = service.getProviderNetworkJson(excelPath);
		for(Provider provider : listProvider){
			System.out.println(provider.getCorpEntCd());
			System.out.println(provider.getPfin());
		}
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(constants.getJSON_PATH()+"pnd1.json"), listProvider);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
		System.out.println(df.format(date));
		
		return listProvider;
	}
}

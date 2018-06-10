package com.devesh.coverter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.coverter.domain.Provider;
import com.devesh.coverter.service.ConverterService;

@RestController
public class ConverterController {

	@Autowired
	ConverterService service;
	
	@RequestMapping("/pnd")
	public List<Provider> getProviderNetworkJson(@RequestParam(name="excelPath")String excelPath){
		
		List<Provider> listProvider = service.getProviderNetworkJson("pnd.xlsx");
		for(Provider provider : listProvider){
			System.out.println(provider.getCorpEntCd());
			System.out.println(provider.getPfin());
		}
		return listProvider;
	}
}

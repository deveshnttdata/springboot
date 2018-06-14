package com.devesh.coverter.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.devesh.coverter.domain.ContractNwExInfo;
import com.devesh.coverter.domain.NetworkEx;
import com.devesh.coverter.domain.PlanType;

@Service
public class CneConverterServiceImpl  implements CneConverterService{

	@Override
	public List<PlanType> getCneJson(String excelPath) {
		
		List<PlanType> listPlanType = new ArrayList<>();
		try( InputStream inputStream = new FileInputStream(excelPath);
				Workbook workBook = new XSSFWorkbook(inputStream);){
			
			List<Sheet> listSheet = IteratorUtils.toList(workBook.sheetIterator());
				
			listSheet.stream()
			.forEach(s -> {
				listPlanType.add(getPlanType(s));
				Map<String,List<NetworkEx>> mapNwEx = new LinkedHashMap<>();
				
				List<Row> listRow = IteratorUtils.toList(s.rowIterator());
				listRow.stream().skip(1)
				.forEach(i -> {
					String overrideTierLevel = i.getCell(0).getStringCellValue().substring(1);
					if(!(mapNwEx.containsKey(overrideTierLevel))){
						List<NetworkEx> listNwEx = new ArrayList<>();
						mapNwEx.put(overrideTierLevel, getListNwEx(i, listNwEx));
					}else{
						getListNwEx(i, mapNwEx.get(overrideTierLevel));
					}
				});
				List<ContractNwExInfo> listConNwExInfo = new ArrayList<>();
				for(String tierLevel : mapNwEx.keySet()){
					listConNwExInfo.add(getConNwExInfo(tierLevel, mapNwEx.get(tierLevel)));
				}
				listPlanType.get(listPlanType.size()-1).setListConNwExInfo(listConNwExInfo);
			});
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listPlanType;
	}
	
	private PlanType getPlanType(Sheet sheet){
		
		PlanType planType = new PlanType();
		planType.setPlanId(sheet.getSheetName().split("_")[1]);
		
		return planType;	
	}
	
	private List<NetworkEx> getListNwEx(Row row, List<NetworkEx> listNwEx){
		
		NetworkEx nwEx = new NetworkEx();
		
		nwEx.setPolicyId(row.getCell(2).getStringCellValue());
		nwEx.setNwExType(row.getCell(1).getStringCellValue());
		
		listNwEx.add(nwEx);
		
		return listNwEx;
	}
	
	private ContractNwExInfo getConNwExInfo(String tierLevel, List<NetworkEx> listNwEx){
		
		ContractNwExInfo conNwExInfo = new ContractNwExInfo();
		conNwExInfo.setOverrideTierLevel(tierLevel);
		conNwExInfo.setListNwEx(listNwEx);
		
		return conNwExInfo;
	}
}

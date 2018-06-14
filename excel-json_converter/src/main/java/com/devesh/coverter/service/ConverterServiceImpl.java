package com.devesh.coverter.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.devesh.coverter.domain.Provider;
import com.devesh.coverter.domain.ProviderNetworkInformation;

@Service
public class ConverterServiceImpl implements ConverterService{

	@Override
	public List<Provider> getProviderNetworkJson(String excelPath) {
		
		List<Provider> listProvider = new ArrayList<>();
		
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource(excelPath).toString());
		//ClassPathResource resource = new ClassPathResource(excelPath);
		
		try( //InputStream inputStream = new FileInputStream(file);
				InputStream inputStream = ConverterServiceImpl.class.getClassLoader().getResourceAsStream(excelPath);
				Workbook workbook = new XSSFWorkbook(inputStream)){
			
			Sheet sheet = workbook.getSheetAt(0);

			List<Row> listRow = IteratorUtils.toList(sheet.iterator());
			
			listRow.stream()
			.filter(s->(s.getCell(4)!=null && s.getCell(4).getCellType()==XSSFCell.CELL_TYPE_NUMERIC)||
					(s.getCell(4)==null && s.getCell(5).getCellType()!=XSSFCell.CELL_TYPE_STRING))
			//.filter(s->s.getCell(4)==null && s.getCell(5).getCellType()!=XSSFCell.CELL_TYPE_STRING)
			.forEach(s->{
				if(s.getCell(4)!=null){
					Provider provider = new Provider();
					provider.setCorpEntCd(s.getCell(3)!=null?s.getCell(3).getStringCellValue():"");
					provider.setPfin(s.getCell(4)!=null?s.getCell(4).getNumericCellValue():0.0);
					provider.setPfinStartDate(s.getCell(5)!=null?s.getCell(5).getDateCellValue():null);
					provider.setPfinEndDate(s.getCell(6)!=null?s.getCell(6).getDateCellValue():null);
					//provider.setPfinStartDate(pfinStartDate);
					listProvider.add(provider);
				}
				if(s.getCell(4)==null && s.getCell(5).getCellType()!=XSSFCell.CELL_TYPE_STRING){
					ProviderNetworkInformation providerNetworkInfo = new ProviderNetworkInformation();
					providerNetworkInfo.setNetworkEffDate(s.getCell(5)!=null?s.getCell(5).getDateCellValue():null);
					providerNetworkInfo.setNetworkEndDate(s.getCell(6)!=null?s.getCell(6).getDateCellValue():null);
					providerNetworkInfo.setPnc(s.getCell(7)!=null?s.getCell(7).getStringCellValue():"");
					if(listProvider.get(listProvider.size()-1).getListProviderNetworkInfo()==null){
						List<ProviderNetworkInformation> listProviderNetworkInfo = new ArrayList<>();
						listProviderNetworkInfo.add(providerNetworkInfo);
						listProvider.get(listProvider.size()-1).setListProviderNetworkInfo(listProviderNetworkInfo);
					}else{
						listProvider.get(listProvider.size()-1).getListProviderNetworkInfo().add(providerNetworkInfo);
					}
				}
			});;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listProvider;
	}

}

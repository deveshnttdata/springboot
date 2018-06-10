package com.devesh.coverter.service;

import java.util.List;

import com.devesh.coverter.domain.Provider;

public interface ConverterService {

	public List<Provider> getProviderNetworkJson(String excelPath);
}

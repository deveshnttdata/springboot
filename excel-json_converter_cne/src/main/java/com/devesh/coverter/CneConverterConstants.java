package com.devesh.coverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:cne.properties")
public class CneConverterConstants {

	@Value("${cne.json.url}")
	private String jsonPath;

	public String getJsonPath() {
		return jsonPath;
	}

	public void setJsonPath(String jsonPath) {
		this.jsonPath = jsonPath;
	}
	
	
}

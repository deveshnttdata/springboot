package com.devesh.coverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ConverterConstants {

	@Value("${converter.json.path}")
	public String JSON_PATH;

	public String getJSON_PATH() {
		return JSON_PATH;
	}

	public void setJSON_PATH(String jSON_PATH) {
		JSON_PATH = jSON_PATH;
	}
}

package com.atom.configservergit;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApacheHttpClientUnitTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String DUMMY_URL = "https://postman-echo.com/get";

	@Test
	public void whenUseApacheHttpClient_thenCorrect() throws IOException {
		logger.warn("=========START=============");
		HttpGet request = new HttpGet(DUMMY_URL);

		try (CloseableHttpClient client = HttpClients.createDefault();
				CloseableHttpResponse response = client.execute(request)) {
			HttpEntity entity = response.getEntity();
			logger.debug("======================");
			logger.debug("Response -> {}", EntityUtils.toString(entity));
		}
		logger.warn("=========END=============");
		
	}
}

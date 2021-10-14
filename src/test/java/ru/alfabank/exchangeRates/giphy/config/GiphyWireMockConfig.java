package ru.alfabank.exchangeRates.giphy.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import com.github.tomakehurst.wiremock.WireMockServer;

@TestConfiguration
public class GiphyWireMockConfig {
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public WireMockServer mockGiphyService() {
		return new WireMockServer(9561);
	}
}

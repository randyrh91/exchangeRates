package ru.alfabank.exchangeRates.openexchangeates.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import com.github.tomakehurst.wiremock.WireMockServer;

@TestConfiguration
public class OpenExchangeRatesWireMockConfig {
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public WireMockServer mockOpenExchangeRatesService() {
		return new WireMockServer(9562);
	}
}

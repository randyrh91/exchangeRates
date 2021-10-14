package ru.alfabank.exchangeRates.openexchangerates.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.github.tomakehurst.wiremock.WireMockServer;
import ru.alfabank.exchangeRates.openexchangeates.config.OpenExchangeRatesMock;
import ru.alfabank.exchangeRates.openexchangeates.config.OpenExchangeRatesWireMockConfig;
import ru.alfabank.exchangeRates.openexchangerates.model.CurrenciesModel;
import ru.alfabank.exchangeRates.openexchangerates.services.OpenExchangeRatesClient;

@SpringBootTest
@ActiveProfiles("test-openexchangerates")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { OpenExchangeRatesWireMockConfig.class })
public class OpenExchangeRatesClientTest {

	@Value("${openexchangerates.api.key}")
	private String appId;
	
	@Autowired
    private WireMockServer mockService;

    @Autowired
    private OpenExchangeRatesClient openexchangeratesclient;
    
    @BeforeEach
    void setUp() throws IOException {
    	OpenExchangeRatesMock.setupMockOpenExchangeRatesResponse(mockService);
    }
    
    @Test
    public void whenGetCurrenciesRates_thenDataCurrenciesRatesShouldBeReturned() {
        
    	CurrenciesModel model = openexchangeratesclient.getDataCurrencies("2021-10-14.json",appId, "USD", "RUB" , true, true);
        Boolean is_empty = model.isEmpty();
    	assertThat(!is_empty);
    }
}

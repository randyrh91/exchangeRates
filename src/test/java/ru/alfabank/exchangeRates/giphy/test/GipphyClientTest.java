package ru.alfabank.exchangeRates.giphy.test;

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
import ru.alfabank.exchangeRates.giphy.config.GiphyMock;
import ru.alfabank.exchangeRates.giphy.config.GiphyWireMockConfig;
import ru.alfabank.exchangeRates.giphy.model.DataModel;
import ru.alfabank.exchangeRates.giphy.services.GiphyClient;

@SpringBootTest
@ActiveProfiles("test_gipphy")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { GiphyWireMockConfig.class })
public class GipphyClientTest {

	@Value("${giphy.api.key}")
	private String apiKey;
	
	@Autowired
    private WireMockServer mockService;

    @Autowired
    private GiphyClient giphyclient;
    
    @BeforeEach
    void setUp() throws IOException {
    	GiphyMock.setupMockGipphyResponse(mockService);
    }
    
    @Test
    public void whenGetGif_thenDataGifShouldBeReturned() {
        DataModel model = giphyclient.getDataGif(apiKey, "rich", "g");
        Boolean is_empty = model.isEmpty();
    	assertThat(!is_empty);
    }
}

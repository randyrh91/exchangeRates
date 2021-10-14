package ru.alfabank.exchangeRates.openexchangeates.config;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class OpenExchangeRatesMock {

	public static void setupMockOpenExchangeRatesResponse(WireMockServer mockService) throws IOException {
		String body = StreamUtils.copyToString(Thread.currentThread().getContextClassLoader().getResourceAsStream("playload/openexchangerates_response.json"), Charset.defaultCharset());
		mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/2021-10-14.json?app_id=API_KEY&base=USD&symbols=RUB&show_alternative=true&prettyprint=true"))
				.willReturn(WireMock.aResponse().withStatus(HttpStatus.OK.value())
						.withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
						.withBody(body)));
	}
}

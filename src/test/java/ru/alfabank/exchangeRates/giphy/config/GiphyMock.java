package ru.alfabank.exchangeRates.giphy.config;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class GiphyMock {

	public static void setupMockGipphyResponse(WireMockServer mockService) throws IOException {
		String body = StreamUtils.copyToString(Thread.currentThread().getContextClassLoader().getResourceAsStream("playload/giphy_response.json"), Charset.defaultCharset());
		mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/random?api_key=API_KEY&tag=rich&rating=g"))
				.willReturn(WireMock.aResponse().withStatus(HttpStatus.OK.value())
						.withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
						.withBody(body)));
	}
}

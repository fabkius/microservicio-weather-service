package cl.app.conversor.client;

import cl.app.conversor.dto.WeatherResponseDto;
import cl.app.conversor.fixtures.Fixtures;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class WeatherClientTest {

    @Value("${weather.token}")
    private String tokenValue;

    @Value("${weather.url}")
    private String urlValue;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherClientImpl weatherClient;

    @Test
    public void obtieneClimaClientOK() throws IOException {

        ReflectionTestUtils.setField(weatherClient, "urlValue", "https://samples.openweathermap.org/data/2.5/weather?q=");
        ReflectionTestUtils.setField(weatherClient, "tokenValue", "b6907d289e10d714a6e88b30761fae22");

        Mockito.when(restTemplate.getForObject(
                Mockito.any(String.class),
                Mockito.any(Class.class)
        )).thenReturn(Fixtures.RESPUESTA_WEATHER_CLIENT());

        WeatherResponseDto respuesta = weatherClient.obtieneClima("London,uk", "metric");

        Assert.assertThat(respuesta.getCod(),is("12"));
        Assert.assertThat(respuesta.getCount(),is("100"));
        Assert.assertThat(respuesta.getMessage(),is("messaje"));
        Assert.assertThat(respuesta.getList().get(0).getDt(),is(1233));
        Assert.assertThat(respuesta.getList().get(0).getName(),is("London"));
    }
}

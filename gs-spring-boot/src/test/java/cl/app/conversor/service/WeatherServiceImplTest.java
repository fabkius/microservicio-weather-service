package cl.app.conversor.service;

import cl.app.conversor.client.WeatherClientImpl;
import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.dto.WeatherResponseDto;
import cl.app.conversor.exception.ServiceException;
import cl.app.conversor.fixtures.Fixtures;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class WeatherServiceImplTest {

    @Mock
    private WeatherClientImpl weatherClient;

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Test
    public void deberiaRetornarClimaServiceOK() throws IOException {
        Mockito.when(weatherClient.obtieneClima(any(String.class), any(String.class))).thenReturn(Fixtures.RESPUESTA_WEATHER_CLIENT());

        DetalleClimaDto respuesta = weatherService.obtieneClima("London,uk", "metric");

        Assert.assertThat(respuesta.getCiudad(),is("London"));
        Assert.assertThat(respuesta.getLatitud(),is("-0.13"));
        Assert.assertThat(respuesta.getLongitud(),is("51.51"));
        Assert.assertThat(respuesta.getPais(),is("GB"));
        Assert.assertThat(respuesta.getViento(),is("4.1"));
    }


    @Test(expected = ServiceException.class)
    public void deberiaRetornarClimaServiceFail() throws IOException {
        Mockito.when(weatherClient.obtieneClima(any(String.class), any(String.class))).thenReturn(null);
         weatherService.obtieneClima("London,uk", "metric");
    }
}

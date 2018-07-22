package cl.app.conversor.controller;

import cl.app.conversor.dto.CityDto;
import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.dto.WeatherResponseDto;
import cl.app.conversor.fixtures.Fixtures;
import cl.app.conversor.service.CityService;
import cl.app.conversor.service.WeatherServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class WeatherControllerTest {

    @Mock
    private WeatherServiceImpl weatherService;

    @Mock
    private CityService cityService;

    @InjectMocks
    private WeatherController weatherController;

    @Test
    public void deberiaRetornarClimaOK() throws Exception {

        Mockito.when(weatherService.obtieneClima(any(String.class), any(String.class))).thenReturn(Fixtures.RESPUESTA_WEATHER());

        DetalleClimaDto respuesta = weatherController.obtenerClima("London,uk","metric");

        Assert.assertThat(respuesta.getCiudad(),is("Santiago"));
        Assert.assertThat(respuesta.getLatitud(),is("-1.23"));
        Assert.assertThat(respuesta.getLongitud(),is("1.456"));
        Assert.assertThat(respuesta.getPais(),is("CL"));
        Assert.assertThat(respuesta.getViento(),is("1.45"));

    }


    @Test
    public void deberiaRetornarListaCiudades() throws Exception {

        Mockito.when(cityService.obtieneCiudades()).thenReturn(Fixtures.RESPUESTA_CIUDADES());

        List<CityDto> respuesta = weatherController.obtenerListaCiudades();

        Assert.assertThat(respuesta.get(0).getGlosa(),is("Santiago"));
        Assert.assertThat(respuesta.get(0).getId(),is("12343343"));
    }

}

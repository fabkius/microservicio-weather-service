package cl.app.conversor.service;

import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.dto.WeatherResponseDto;

public interface WeatherService {

    DetalleClimaDto obtieneClima(String idCity, String units);
}

package cl.app.conversor.service;

import cl.app.conversor.client.WeatherClient;
import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.dto.WeatherResponseDto;
import cl.app.conversor.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherClient weatherClient;

    public WeatherServiceImpl(WeatherClient weatherClient){
        this.weatherClient = weatherClient;
    }

    @Override
    public DetalleClimaDto obtieneClima(String idCity, String units) {
        return convertData(weatherClient.obtieneClima(idCity,units));
    }

    private DetalleClimaDto convertData(WeatherResponseDto weatherResponseDto) {
        WeatherResponseDto data = Optional.ofNullable(weatherResponseDto)
                .orElseThrow(() -> new ServiceException("valor nulo"));

        DetalleClimaDto detalleClimaDto = new DetalleClimaDto();
        detalleClimaDto.setCiudad(data.getList().get(0).getName());
        detalleClimaDto.setDetalle(data.getList().get(0).getWeather().get(0).getDescription());
        detalleClimaDto.setLatitud(data.getList().get(0).getCoord().getLat());
        detalleClimaDto.setLongitud(data.getList().get(0).getCoord().getLon());
        detalleClimaDto.setPais(data.getList().get(0).getSys().getCountry());
        detalleClimaDto.setViento(data.getList().get(0).getWind().getSpeed());
        return detalleClimaDto;
    }
}

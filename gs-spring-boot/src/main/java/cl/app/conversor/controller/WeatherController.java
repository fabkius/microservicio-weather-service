package cl.app.conversor.controller;

import cl.app.conversor.dto.CityDto;
import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.service.CityService;
import org.springframework.web.bind.annotation.*;
import cl.app.conversor.service.WeatherService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class WeatherController {

    private WeatherService weatherService;
    private CityService cityService;

    public WeatherController(WeatherService weatherService,CityService cityService){
        this.weatherService=weatherService;
        this.cityService=cityService;
    }


    @RequestMapping(value="/weather",method = RequestMethod.GET)
    public DetalleClimaDto obtenerClima(@RequestParam("idCity") String idCity,
                                                    @RequestParam("units") String units) throws IOException {
        return weatherService.obtieneClima(idCity,units);
    }

    @RequestMapping(value="/list-city",method = RequestMethod.GET)
    public List<CityDto> obtenerListaCiudades() throws IOException {
        return cityService.obtieneCiudades();
    }
}

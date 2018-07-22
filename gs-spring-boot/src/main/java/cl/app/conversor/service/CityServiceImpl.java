package cl.app.conversor.service;

import cl.app.conversor.dto.CityDto;
import cl.app.conversor.util.JsonBDUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService{

    private JsonBDUtil jsonBDUtil;

    public CityServiceImpl(JsonBDUtil jsonBDUtil){
        this.jsonBDUtil=jsonBDUtil;
    }

    @Override
    public List<CityDto> obtieneCiudades() {
       return jsonBDUtil.obtieneDatosCiudad();
    }
}

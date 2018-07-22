package cl.app.conversor.util;

import cl.app.conversor.dto.CityDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonBDUtil {

    public List<CityDto>  obtieneDatosCiudad(){
        ObjectMapper mapper = new ObjectMapper();
        List<CityDto> ciudadesResponseDto=null;
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:list-city.json");
            ciudadesResponseDto =
                    mapper.readValue(file, new TypeReference<List<CityDto>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ciudadesResponseDto;

    }
}

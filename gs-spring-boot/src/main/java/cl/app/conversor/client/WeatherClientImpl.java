package cl.app.conversor.client;

import cl.app.conversor.dto.WeatherResponseDto;
import cl.app.conversor.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherClientImpl implements WeatherClient {

    @Value("${weather.token}")
    private String tokenValue;

    @Value("${weather.url}")
    private String urlValue;

    private RestTemplate restTemplate;

    public WeatherClientImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public WeatherResponseDto obtieneClima(String idCity, String units) {
        WeatherResponseDto response=null;

        try{
            System.out.println("url: "+urlValue+"?q="+idCity+"&units="+units+"&appid="+tokenValue);
            response =
                    restTemplate.getForObject(urlValue+"?q="+idCity+"&units="+units+"&appid="+tokenValue, WeatherResponseDto.class);
        }catch(RestClientException e){
            throw new ServiceException("Error al consulta servicio de clima: "+e.getMessage());
        }
        return response;
    }

}

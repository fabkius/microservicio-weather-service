package cl.app.conversor.fixtures;

import cl.app.conversor.dto.*;

import java.util.ArrayList;
import java.util.List;

public class Fixtures {

    public static DetalleClimaDto RESPUESTA_WEATHER() {
        DetalleClimaDto detalleClimaDto = new DetalleClimaDto();
        detalleClimaDto.setViento("1.45");
        detalleClimaDto.setCiudad("Santiago");
        detalleClimaDto.setPais("CL");
        detalleClimaDto.setLongitud("1.456");
        detalleClimaDto.setLatitud("-1.23");
        detalleClimaDto.setDetalle("despejado");
        return detalleClimaDto;
    }

    private static List<WeatherDto> CREA_WEATHER() {
        List<WeatherDto> lista = new ArrayList<>();
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setDescription("light intensity drizzle");
        weatherDto.setIcon("09d");
        weatherDto.setId("300");
        weatherDto.setMain("Drizzle");
        lista.add(weatherDto);
        return lista;
    }

    private static WindDto CREA_WIND() {
        WindDto windDto= new WindDto();
        windDto.setDeg("80");
        windDto.setSpeed("4.1");
        return windDto;
    }

    private static SysDto CREA_SYS() {
        SysDto sysDto = new SysDto();
        sysDto.setCountry("GB");
        return sysDto;
    }

    private static MainDto CREA_MAIN() {
        MainDto mainDto = new MainDto();
        mainDto.setHumidity("81");
        mainDto.setPressure("1012");
        mainDto.setTemp("280.32");
        mainDto.setTemp_max("281.15");
        mainDto.setTemp_min("279.15");
        return mainDto;
    }

    private static CoordDto CREA_COORDS() {
        CoordDto coordDto = new CoordDto();
        coordDto.setLat("-0.13");
        coordDto.setLon("51.51");
        return coordDto;
    }

    private static CloudsDto CREA_CLOUDS() {
        CloudsDto cloudsDto = new CloudsDto();
        cloudsDto.setAll("90");
        return cloudsDto;
    }

    public static WeatherResponseDto RESPUESTA_WEATHER_CLIENT() {
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();
        weatherResponseDto.setCod("12");
        weatherResponseDto.setCount("100");
        weatherResponseDto.setMessage("messaje");
        weatherResponseDto.setList(CREA_LISTA());
        return weatherResponseDto;
    }

    private static List<ListDto> CREA_LISTA() {
        List<ListDto> lista = new ArrayList<>();
        ListDto listadto = new ListDto();
        listadto.setClouds(CREA_CLOUDS());
        listadto.setCoord(CREA_COORDS());
        listadto.setDt(1233);
        listadto.setId(1);
        listadto.setMain(CREA_MAIN());
        listadto.setRain(null);
        listadto.setSnow(null);
        listadto.setSys(CREA_SYS());
        listadto.setWeather(CREA_WEATHER());
        listadto.setWind(CREA_WIND());
        listadto.setName("London");
        lista.add(listadto);
        return lista;
    }

    public static List<CityDto> RESPUESTA_CIUDADES() {
        List<CityDto> listaCiudades = new ArrayList<>();
        CityDto cityDto = new CityDto();
        cityDto.setId("12343343");
        cityDto.setGlosa("Santiago");
        listaCiudades.add(cityDto);
        return listaCiudades;
    }
}

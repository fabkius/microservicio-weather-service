package cl.app.conversor.dto;

import java.util.List;

public class WeatherResponseDto {

    private String message;

    private String count;

    private String cod;

    private List<ListDto> list;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<ListDto> getList() {
        return list;
    }

    public void setList(List<ListDto> list) {
        this.list = list;
    }
}

package cl.app.conversor.dto;

public class SysDto {

    private String country;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [country = "+country+"]";
    }
}

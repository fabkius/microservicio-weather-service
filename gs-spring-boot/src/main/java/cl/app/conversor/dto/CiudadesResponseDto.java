package cl.app.conversor.dto;

public class CiudadesResponseDto {
    private CoordDto coord;

    private String id;

    private String name;

    private String country;

    public CoordDto getCoord ()
    {
        return coord;
    }

    public void setCoord (CoordDto coord)
    {
        this.coord = coord;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

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
        return "ClassPojo [coord = "+coord+", id = "+id+", name = "+name+", country = "+country+"]";
    }
}

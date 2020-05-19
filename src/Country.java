import java.util.ArrayList;

public class Country {

    public String name;
    public ArrayList<TransportMode> transportModes;
    public Climate climate;

    public Country(String name, Climate climate, ArrayList<TransportMode> transportModes) {
        this.name = name;
        this.climate = climate;
        this.transportModes = transportModes;
    }
}

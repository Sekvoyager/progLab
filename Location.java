public class Location {
    static Location[] Houses = new Location[0];
    String name;
    Citizen owner;
    Location(String name, Citizen owner) {
        this.name = name;
        this.owner = owner;

    }
}

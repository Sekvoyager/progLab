public class Honestpoliceman extends Policeman{
    public Honestpoliceman(String name, boolean hairless, Location Current_Location, Location CrimetimeLocation, Location HomeLocation, Feeling CurrentFeeling, Rank rank) {
        super(name, hairless, Current_Location, CrimetimeLocation, HomeLocation, CurrentFeeling, rank);
    }

    @Override
    public String toString() {
        return "Honest policeman can't convert smth to string";
    }

    @Override
    public boolean equals(Object obj) {
        System.out.print("Honest policeman isn't equal to a simple cop!");
        return true;
    }

    @Override
    public int hashCode() {
        System.out.print("Returns number of honest cops in this town");
        return 0;
    }
}

import java.util.Set;

public class Policeman extends Citizen {
    Rank rank;
    public enum Rank{
        commissar, assistant
    }
    public Policeman(String name, boolean hairless, Location Current_Location, Location CrimetimeLocation, Location HomeLocation, Feeling CurrentFeeling, Rank rank) {
        super(name, hairless, Current_Location, CrimetimeLocation, HomeLocation, CurrentFeeling);
        this.rank = rank;
    }

    public boolean interrogate(Citizen cur){
        if (cur.hairless) {
            cur.beInterrogated();
            System.out.println(this.rank + " " + this.name + " interrogates " + cur.name);
            if (cur.proveAlibi()) {
                leave(cur);
                return false;
            }
            else {
                arrest(cur);
                return true;
            }
        }
        else {
            System.out.print("Ir was easy to mistake, so ");
            leave(cur);
            return false;
        }
    }
    public void arrest(Citizen jai){
        jai.Current_Location = Location.Jail;
        jai.Current_Feeling = Feeling.Terrible;
        System.out.println(this.rank + " " + this.name + " arrested " + jai.name);
    }
    public void leave(Citizen amn){
        amn.Current_Location = amn.HomeLocation;
        amn.Current_Feeling = Feeling.Happy;
        System.out.println(amn.name + " may go home");
    }
}

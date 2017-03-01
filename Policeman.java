public class Policeman extends Citizen {
    Rank rank;
    public enum Rank{
        commissar, assistant
    }
    public Policeman(String name, boolean hairless, Location Current_Location, Location CrimetimeLocation, Location HomeLocation, Feeling CurrentFeeling, Rank rank) {
        super(name, hairless, Current_Location, CrimetimeLocation, HomeLocation, CurrentFeeling, true);
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
    void arrest(Citizen jai){
        jai.Current_Location = Location.Jail;
        jai.Current_Feeling = Feeling.Terrible;
        System.out.println(this.rank + " " + this.name + " arrested " + jai.name);
    }
    public void leave(Citizen amn){
        amn.Current_Location = amn.HomeLocation;
        amn.Current_Feeling = Feeling.Happy;
        System.out.println(amn.name + " may go home");
    }

    public void orderToTakeOff(Citizen man){
        System.out.println(this.name + " ordered to " + man.name + " to take off his hat");
        man.takeOffHat();
    }

    public boolean tearOffHair(Citizen man) {
        if (!man.Patience) {
            System.out.println(this.name + " believes " + man.name);
            return false;
        }
        else {
//            bringToInterrogation(man);
            System.out.println(this.name + " brings " + man.name + " to the Police Office");
            return true;
        }
    }

    public void writeFilthMessage(){
        Current_Feeling = Feeling.Wary;
        System.out.println(this.name + " is a rascal fuzz");
    }

    public void robTheBank(){
        CrimetimeLocation = Location.Bank;
        Current_Feeling = Feeling.Wary;
        System.out.println(this.name + " absolutely unlaw!");
    }

    public void bringToInterrogation(Citizen man) {
        man.Current_Location = Location.PoliceOffice;
        man.Current_Feeling = Feeling.Unhappy;
//        interrogate(man);
    }
}

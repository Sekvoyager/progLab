interface Letter{
    void writeFilthMessage();
}

interface Rob{
    void robTheBank();
}

public class Citizen implements Letter, Rob{
    static Citizen[] Ctz = new Citizen[6];
    static Policeman[] allPlc = new Policeman[5];
    boolean hairless;
    String name;
    boolean Patience; //терпение жителя при проверке
    Location Current_Location, CrimetimeLocation, HomeLocation;
    Feeling Current_Feeling;
    public enum Location{
        Home1, Home2, Home3, Home4, Home5, Home6, Pshhouse, Dighouse, Gighouse, Spighouse, Psihouse, Jail,
        PoliceOffice, Bank
    }
    public enum Feeling{
        Happy, Unhappy, Wary, Terrible, Tired
    }

    Citizen(String name, boolean hairless, Location Current_Location, Location CrimetimeLocation,
            Location HomeLocation, Feeling CurrentFeeling, boolean Patience) {
        this.name = name;
        this.hairless = hairless;
        this.Current_Location = Current_Location;
        this.CrimetimeLocation = CrimetimeLocation;
        this.HomeLocation = HomeLocation;
        this.Current_Feeling = CurrentFeeling;
        this.Patience = Patience;
    }

    public void robTheBank(){
        CrimetimeLocation = Location.Bank;
        Current_Feeling = Feeling.Wary;
        System.out.println(this.name + " has robbed a bank!O_O");
    }
    public void writeFilthMessage(){
        Current_Feeling = Feeling.Wary;
        System.out.println(this.name + " has wrote a filth message");
    }
    public void beInterrogated(){
        this.Current_Feeling = Feeling.Unhappy;
        this.Current_Location = Location.PoliceOffice;
    }
    public boolean proveAlibi(){
        for (int i = 0; i < 6; i++) {
            if (!(Ctz[i].name.equals(this.name)) && (Ctz[i].CrimetimeLocation.equals(this.CrimetimeLocation))){
                System.out.println(Ctz[i].name + " proved that " + this.name + " was at " + this.CrimetimeLocation);
                return true;
            }
        }
        System.out.println(this.name + " hasn't able to prove his alibi");
        return false;
    }
    public void takeOffHat(){
        System.out.println(this.name + " took off his hat.");
    }
    public static void main(String args[]){
        allPlc[0] = new Policeman("Pshiggle", false, Location.PoliceOffice,
                Location.PoliceOffice, Location.Pshhouse, Feeling.Tired, Policeman.Rank.commissar);
        allPlc[1] = new Policeman("Diggle", true, Location.PoliceOffice,
                Location.PoliceOffice, Location.Dighouse, Feeling.Tired, Policeman.Rank.assistant);
        allPlc[2] = new Policeman("Giggle", false, Location.PoliceOffice,
                Location.PoliceOffice, Location.Gighouse, Feeling.Tired, Policeman.Rank.assistant);
        allPlc[3] = new Policeman("Spiggle", true, Location.PoliceOffice,
                Location.PoliceOffice, Location.Spighouse, Feeling.Tired, Policeman.Rank.assistant);
        allPlc[4] = new Policeman("Psiggle", false, Location.PoliceOffice,
                Location.PoliceOffice, Location.Psihouse, Feeling.Tired, Policeman.Rank.assistant);
        Ctz[0] = new Citizen("Francis", true, Location.Home1, Location.Home2, Location.Home1, Feeling.Happy, true);
        Ctz[1] = new Citizen("Muhammad", false, Location.Home2, Location.Home1, Location.Home2, Feeling.Happy, false);
        Ctz[2] = new Citizen("Andrew", true, Location.Home3, Location.Home1, Location.Home3, Feeling.Happy, true);
        Ctz[3] = new Citizen("Donald", true, Location.Home2, Location.Home3, Location.Home4, Feeling.Happy, false);
        Ctz[4] = new Citizen("Kim", true, Location.Home6, Location.Home3, Location.Home5, Feeling.Happy, false);
        Ctz[5] = new Citizen("Felix", true, Location.Home6, Location.Home5, Location.Home6, Feeling.Happy, true);
        allPlc[2].writeFilthMessage();
        Ctz[5].robTheBank();
        int cop = 0, cz = 0;
        while (cz < 6) {
            allPlc[cop].orderToTakeOff(Ctz[cz]);
            if (allPlc[cop].tearOffHair(Ctz[cz])) {
                allPlc[cop].bringToInterrogation(Ctz[cz]);
                allPlc[cop].interrogate(Ctz[cz]);
                if (cop == 4) {
                    cop = 0;
                }
                else {
                    cop++;
                }
            }
            cz++;
        }
    }
}

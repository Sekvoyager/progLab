public class Letter {
    String mark;
    Citizen autor;
    String text;

    public Letter(String mark, Citizen autor, String text){
        this.mark = mark;
        this.text = text;
        this.autor = autor;
    }

    public class locale{
        boolean pyanys;
        boolean zhirchik;
        boolean vzdryzhni(boolean zhrachni, boolean pitni){
            if (zhrachni && pitni){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void beSent(){
        System.out.print("The letter was sent by " + this.autor.name);
    }
}

public class Bank  {

    private double iloscGotowkiWSejfie; // przykładowa ilość gotówki w sejfie


    public Bank(int iloscGotowkiWSejfie) {
        this.iloscGotowkiWSejfie = iloscGotowkiWSejfie;
    }

    public double getIloscGotowkiWSejfie() {
        return iloscGotowkiWSejfie;
    }
    public boolean czyMoznaWyplacic(double kwota) {
        if(kwota<(iloscGotowkiWSejfie)){
            return true;
        }
        else{
            return false;
        }
    }
    public void Wyplata(double kwota) {
        iloscGotowkiWSejfie= iloscGotowkiWSejfie-kwota;
    }
}
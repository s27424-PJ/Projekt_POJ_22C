public class Bankomat{
    private KartaPlatnicza karta;
    private int liczbaNieudanychProb;
    private double IloscGotowkiKarta;




    public int getLiczbaNieudanychProb() {
        return liczbaNieudanychProb;
    }

    public void uzyjKarty(KartaPlatnicza karta) {
        this.karta = karta;
        this.liczbaNieudanychProb = 0;
        this.IloscGotowkiKarta = karta.sprawdzSaldo();
    }
    public boolean sprawdzPin(String pin) {
        if (karta == null) {
            return false;
        }
        if (karta.sprawdzPin(pin)) {
            liczbaNieudanychProb = 0;
            return true;
        } else {
            liczbaNieudanychProb++;
            return false;
        }
    }
    public boolean czyKartaZablokowana() {
        return liczbaNieudanychProb >= 3;
    }
    public boolean czyMoznaWyplacic(double kwota) {
        if(kwota<=(karta.sprawdzSaldo())){
            return true;
        }
        else{
            return false;
        }
    }
    public void Wyplata(double kwota) {
        IloscGotowkiKarta=IloscGotowkiKarta-kwota;
    }
    public double getIloscGotowkiKarta() {
        return  IloscGotowkiKarta;
    }


}

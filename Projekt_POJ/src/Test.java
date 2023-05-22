import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sprawdz=true;
        Bank bank = new Bank(10000);

        Bankomat bankomat = new Bankomat();

        KartaPlatnicza karta = new KartaPlatnicza("1234567890123456", "1234", 1000);
        KartaPlatnicza karta2 = new KartaPlatnicza("1234567890123456", "1334", 112221);
        bankomat.uzyjKarty(karta2);
        if (bankomat.getIloscGotowkiKarta() <= 0) {
            System.out.println("Brak gotówki na koncie");
            return;
        }
        System.out.println("Witaj w banku  Szmalenium");
        System.out.print("Wprowadź PIN: ");
        String pin = scanner.nextLine();
        while (!bankomat.sprawdzPin(pin) && !bankomat.czyKartaZablokowana()) {
            System.out.println("Niepoprawny PIN");
            System.out.print("Wprowadź PIN: ");
            pin = scanner.nextLine();
        }
        if (bankomat.czyKartaZablokowana()) {
            System.out.println("Karta zablokowana.");
            return ;
        }
        while(sprawdz==true) {
            if(bankomat.getIloscGotowkiKarta()<=0){
                System.out.println("Brak więcej środków na koncie");
                return;
            } else if (bank.getIloscGotowkiWSejfie()<=0) {
                System.out.println("Bank już nie ma pieniędzy");
                return;
            }
            System.out.print("Podaj kwotę do wypłaty: ");
            double kwota = scanner.nextDouble();
            if (kwota <= 0) {
                System.out.println("Niepoprawna kwota");
                return;
            }
            if (bank.czyMoznaWyplacic(kwota) == true && bankomat.czyMoznaWyplacic(kwota) == true) {
                bankomat.Wyplata(kwota);
                bank.Wyplata(kwota);
                System.out.println("Pieniądze wypłacone");
                System.out.println("Twoje saldo po Wypłacie: "+ bankomat.getIloscGotowkiKarta());

            } else if (bank.czyMoznaWyplacic(kwota) == false && bankomat.czyMoznaWyplacic(kwota) == true) {
                System.out.println("Bank nie ma takich środków");
                System.out.println("Saldo Bank: "+ bank.getIloscGotowkiWSejfie());
                System.out.println("Prośba o zmniejszenie kwoty");
            } else if (bank.czyMoznaWyplacic(kwota) == false && bankomat.czyMoznaWyplacic(kwota) == true)
            {
                System.out.println("Bank nie ma takich środków");
                System.out.println("Saldo Bank: "+ bank.getIloscGotowkiWSejfie());
            }
            else{
                System.out.println("Nie masz takich środków na koncie");
                System.out.println("Twoje saldo: "+ bankomat.getIloscGotowkiKarta());
            }
            scanner.nextLine();
            System.out.println("Chcesz kontynuować? tak/nie");
            String decyzja = scanner.nextLine();
            if(decyzja.equals("tak")){
                sprawdz=true;
            }
            else if(decyzja.equals("nie")){
                sprawdz=false;
            }
            else{
                System.out.println("Błąd zamykam sesje");
                return;
            }
        }
    }

}
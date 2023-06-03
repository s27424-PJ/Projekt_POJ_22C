class KartaPlatnicza {
    private String numerKarty;
    private String pin;
    private double saldo;

    public KartaPlatnicza(String numerKarty, String pin, double saldo) {
        this.numerKarty = numerKarty;
        this.pin = pin;
        this.saldo = saldo;
    }
    public KartaPlatnicza(String numerKarty, String pin) {

        this.numerKarty = numerKarty;

        this.pin = pin;

        this.saldo = 2000;

    }
    public KartaPlatnicza(String numerKarty) {

        this.numerKarty = numerKarty;

        this.pin = 5455;

        this.saldo = 2000;

    }
    
    public KartaPlatnicza() {
        this.numerKarty = 5776622;

        this.pin = 7883;

        this.saldo = 2000;

    }
    public boolean sprawdzPin(String pin) {
        return this.pin.equals(pin);
    }

    public double sprawdzSaldo() {
        return saldo;
    }
    public boolean wyplacPieniadze(double kwota) {
        if ( kwota > saldo) {
            return false;
        }
        saldo -= kwota;
        return true;
    }
}

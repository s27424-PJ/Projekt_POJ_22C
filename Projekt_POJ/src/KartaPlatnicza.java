class KartaPlatnicza {
    private String numerKarty;
    private String pin;
    private double saldo;

    public KartaPlatnicza(String numerKarty, String pin, double saldo) {
        this.numerKarty = numerKarty;
        this.pin = pin;
        this.saldo = saldo;
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
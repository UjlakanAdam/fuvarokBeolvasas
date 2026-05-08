package app;

public class Fuvar {
    private String rsz;
    private int ido_mp;
    private double osszeg;
    private String fizetes;
    
    public static void main(String[] args) {
        
    }

    public Fuvar(String rsz, int ido_mp, double osszeg, String fizetes) {
        this.rsz = rsz;
        this.ido_mp = ido_mp;
        this.osszeg = osszeg;
        this.fizetes = fizetes;
    }

    public String getRsz() {
        return rsz;
    }

    public int getIdo_mp() {
        return ido_mp;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public String getFizetes() {
        return fizetes;
    }
    
}

package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Beolvas { 
    private static List<Fuvar> fuvarok = new ArrayList<>(); 
    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarok.csv");    
        String szoveg = Files.readString(path);
        System.out.println(szoveg);
        
        List<String> sorok = Files.readAllLines(path);
        for (String sor : sorok) {
            System.out.println(sor);
            String s[]=sor.split(";");
            String rsz = s[0];
            int ido_mp = Integer.parseInt(s[1]);
            double osszeg = Integer.parseInt(s[2]);
            String fizetes = s[3];
            Fuvar fuvar = new Fuvar(rsz, ido_mp, osszeg, fizetes);
            fuvarok.add(fuvar);
        }
        
    }
    public void osszFuvar(){
        System.out.println("1.: Összes fuvar értéke: ");
        int osszeg = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            osszeg+=fuvarok.get(i).getOsszeg();
        }
        System.out.println(osszeg);
    }
}

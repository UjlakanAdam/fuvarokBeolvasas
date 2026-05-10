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
        //System.out.println(szoveg);
        
        List<String> sorok = Files.readAllLines(path);
        for (String sor : sorok) {
            
            String s[]=sor.split(";");
            String rsz = s[0];
            int ido_mp = Integer.parseInt(s[1]);
            double osszeg = Double.parseDouble(s[2]);
            String fizetes = s[3];
            Fuvar fuvar = new Fuvar(rsz, ido_mp, osszeg, fizetes);
            //System.out.println(sor);
            fuvarok.add(fuvar);
            
            
        }
        feladatok();
    }
    
    public static void feladatok(){
        osszesFuvarErteke();
        legdragabbRendszam();
        legolcsobbForintban();
        kartyasFizetes();
        osszesFizetesMod();
        hanyDbAuto();
        hanyFizetesiMod();
        }
    
    public static void osszesFuvarErteke(){
        double osszeg = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            osszeg+=fuvarok.get(i).getOsszeg();
        }
        System.out.println("1.: Összes fuvar értéke: "+osszeg);
        }
    public static void legdragabbRendszam(){
        double legdragabb=0;
        String rendszam="";
        for (int i = 0; i < fuvarok.size(); i++) {
            if(legdragabb<fuvarok.get(i).getOsszeg()){
                legdragabb=fuvarok.get(i).getOsszeg();
                rendszam=fuvarok.get(i).getRsz();
            }
        }
        System.out.println("2.: Legdrágább fuvar rendszáma: "+rendszam);
    }
    public static void legolcsobbForintban(){
        double legolcsobb=fuvarok.get(0).getOsszeg();
        for (int i = 0; i < fuvarok.size(); i++) {
            if(legolcsobb>fuvarok.get(i).getOsszeg()){
                legolcsobb=fuvarok.get(i).getOsszeg();
            }
        }
        int forint = (int)legolcsobb*350;
        System.out.println("3.: legolcsobb fuvar forintban: "+forint);
    }
    public static void kartyasFizetes(){
        int kartyasFizetes=0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if(fuvarok.get(i).getFizetes().equals("kártya")){
            kartyasFizetes+=1;
            }
        }
        System.out.println("4.: hány kártyás fizetés volt: "+kartyasFizetes);
    }
    public static void osszesFizetesMod(){
        List<String> fizetesiModok = new ArrayList<>();
        for (int i = 0; i < fuvarok.size(); i++) {
            String fizetesiMod=fuvarok.get(i).getFizetes();
            int a=0;
            while (a<fizetesiModok.size() && !fizetesiModok.get(a).equals(fizetesiMod)) {
            a++;
            }
            if (a>=fizetesiModok.size()) {
                fizetesiModok.add(fizetesiMod);
            }     
        }
        System.out.println("5.: minden fizetési mód: "+fizetesiModok);
    }
    public static void hanyDbAuto(){
        List<String> autok = new ArrayList<>();
        for (int i = 0; i < fuvarok.size(); i++) {
            String auto=fuvarok.get(i).getRsz();
            int a=0;
            while (a<autok.size() && !autok.get(a).equals(auto)) {
            a++;
            }
            if (a>=autok.size()) {
                autok.add(auto);
            }   
        }
        System.out.println("6.: hány darab autó van a rendszerben: "+autok.size());
    }
    public static void hanyFizetesiMod(){
        List<String> fizetesiModok = new ArrayList<>();
        for (int i = 0; i < fuvarok.size(); i++) {
            String fizetesiMod=fuvarok.get(i).getFizetes();
            int a=0;
            while (a<fizetesiModok.size() && !fizetesiModok.get(a).equals(fizetesiMod)) {
            a++;
            }
            if (a>=fizetesiModok.size()) {
                fizetesiModok.add(fizetesiMod);
            }   
        }
        System.out.println("7.: hányféle fizetési mód: "+fizetesiModok.size());
    }
}


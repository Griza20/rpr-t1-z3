package ba.unsa.etf.rpr;
import java.util.Scanner;

class Sat{
    int sati,minute,sekunde;

    Sat(int sati, int minute, int sekunde) {
        Postavi(sati,minute,sekunde);
    }
    void Postavi(int h, int min, int sek) {
        sati=h;
        minute=min;
        sekunde=sek;
    }

    void Sljedeci() {
        sekunde++;
        if (sekunde==60) { sekunde=0; minute++; }
        if (minute==60) { minute=0; sati++; }
        if (sati==24) sati=0;
    }
    void Prethodni() {
        sekunde--;
        if (sekunde==-1) { sekunde=59; minute--; }
        if (minute==-1) { minute=59; sati--; }
        if (sati==-1) sati=23;
    }
    void PomjeriZa(int pomak) {
        if (pomak>0)
            for (int i=0; i<pomak; i++) Sljedeci();
        else for (int i=0; i<-pomak; i++) Prethodni();
    }

    int DajSate() { return sati; }
    int DajMinute() { return minute; }
    int DajSekunde() { return sekunde; }

    void Ispisi() { System.out.println(sati + ":" + minute + ":" + sekunde); }

}


public class Main {

    public static void main(String[] args) {
        Sat s = new Sat(15,30,45);
        s.Ispisi();
        s.Sljedeci();
        s.Ispisi();
        s.PomjeriZa(-48);
        s.Ispisi();
        s.Postavi(0,0,0);
        s.Ispisi();
    }
}
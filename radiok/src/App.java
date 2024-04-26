import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("zenek.txt");// eltároljuk a fájlt a file változóba
        try (Scanner sc = new Scanner(file)) {// beolvassuk a fájlt
            int radio1 = 0;// az első rádió kezdőértéke
            int radio2 = 0;// a második rádió kezdőértéke
            int radio3 = 0;// az harmadik rádió kezdőértéke

            while (sc.hasNextLine()) {// addig megyünk amíg van sor a fájlba
                String line = sc.nextLine();// a line változóban tároljuk az aktív sor tartalmát
                String[] items = line.split(" ");// a szóköz mentén daraboljuk

                int radioId = Integer.parseInt(items[0]);// az első darab a rádió azonosítója
                int min = Integer.parseInt(items[1]);// a második darab a perc
                int sec = Integer.parseInt(items[2]);// a harmadik darab a másodperc

                switch (radioId) {// a radioId-t egy switch-el vizsgáljuk (lehet if - else-vel is, de talán így
                                  // szebb)
                    case 1:// ha 1 az értéke akkor az első rádió értékét növeljük a másodpercekkel
                        radio1 += min * 60 + sec;
                        break;
                    case 2:// ha 2 az értéke akkor a második rádió értékét növeljük a másodpercekkel
                        radio2 += min * 60 + sec;
                        break;
                    default:// ha nem 1 vagy 2 akkor csak a harmadik marad, tehát azt növeljük a
                            // másodpercekkel
                        radio3 += min * 60 + sec;
                        break;
                }

            }
            // kiiratjuk az eredményeket
            System.out.println("Rádió-1 idő: " + formattedTime(radio1));
            System.out.println("Rádió-2 idő: " + formattedTime(radio2));
            System.out.println("Rádió-3 idő: " + formattedTime(radio3));
        }

    }

    // a másodperceket átalakítjuk óra:perc:másodperc formátumra
    private static String formattedTime(int sec) {
        int second = sec % 60;// a másodperc az összes másodperc maradéka lesz / perc = sec/60 /
        int hour = sec / 3600;// az óra az összes másodperc osztva 3600-al
        int minute = sec % 3600 / 60;// a perc az óra maradéka lesz
        // azért adnak vissza az osztások egész számot mert int-ként lettek létrehozva a
        // változók
        String timeSum = String.format("%02d:%02d:%02d", hour, minute, second);// formázzuk a kapott értékeket
        return timeSum;
    }

}

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //camelCase->değişken isimlerinin küçük harfle başlayıp diğer kelimelerin baş harflerinin büyük olması
        //PascalCase->sınıf isimlerinde kelimelerin ilk harflerinin büyük olması

        System.out.println("*Değişkenler");
        int not = 55;//integer
        int kredi = 100000;
        double notOrtalamasi = 50.5;
        String isim = "Engin Demiroğ";
        boolean sistemeGirisYapmisMi = true;

        System.out.println("*Şart Blokları");
        //not 50 ve üzeri ise geçti,40-49 arası ise bütünleme, 0-39 arası ise kaldı bilgisini döndüren program

        if(not>=50){
            System.out.println("Not : "+ not + " Geçti");
        }else if(not>=40){
            System.out.println("Not : "+ not + " Bütünleme");
        }else{
            System.out.println("Not : "+ not + " Kaldı");
        }

        System.out.println("*Döngüler");

        for(int i=0; i<=10; i+=2){
            System.out.println(i);
        }
        System.out.println("---");

        int sayi = 10;
        while(sayi<=100){
            System.out.println(sayi);
            sayi = sayi + 10;
        }
        System.out.println("---");

        int sayi2 = 11;
        do{
            System.out.println(sayi2);
            sayi = sayi + 10;
        }while(sayi2>100);
        System.out.println("---");

        System.out.println("Metodlar");
        //DRY -> Do Not Repeat Yourself
        //Bir fonksiyon sadece bir iş yapabilir

        mesajVer("Engin");
        mesajVer("Kerem");
        hesapla();
        System.out.println(topla(5,9));
        System.out.println(toplananİkiSayininYuzdeOnu(20,55));
        System.out.println("---");

        System.out.println("Diziler");
        String[] sehirler =new String[]{"Ankara","İstanbul","İzmir"};

        for(String sehir : sehirler){
            System.out.println(sehir);
        }

        for(int i=0; i<3; i++){
            System.out.println(sehirler[i]);
        }

        int[] sayilar = new int[]{1,2,3,4,5,6,7,8,9,10};
        int aranacak = 15;
        boolean varMi = sayiBul(sayilar, aranacak);
        mesajVer(varMi, aranacak);

        System.out.println("---");
        String[] sehirler1 = new String[]{"Ankara","İstanbul","İzmir"};
        String[] sehirler2 = new String[]{"Antep","Diyarbakır","Urfa"};
        sehirler1 = sehirler2;
        sehirler1[0] = "Adana";
        System.out.println(sehirler2[0]);

        /*
        Değer Tipler->Stack'te tutulur.Boolean, int, double...
        Referans Tip->Heap'te tutulur.Array, class, abstract, interface...

                  stack                 heap
          101-> sehirler1        101-> {"Ankara","İstanbul","İzmir"}
          102-> sehirler2        102-> {"Antep","Diyarbakır","Urfa"}

          sehirler1 = sehirler2;
          sehirler1[0] = "Adana";

                  stack                 heap
         --Garbage collector---> 101-> {"Ankara","İstanbul","İzmir"}
          102-> sehirler1        102-> {"Adana","Diyarbakır","Urfa"}
          102-> sehirler2
         */

        int numara1 = 10;
        int numara2 = 20;
        numara1 = numara2;
        numara2 = 30;
        System.out.println(numara1);
        System.out.println("---");

        System.out.println("Classlar");
        Product product1 = new Product();
        product1.setName("Laptop");

        Product product2 = new Product();
        product2.setName("Mouse");

        Product[] urunler = new Product[]{product1, product2};

        for(int i=0; i<urunler.length; i++){
            System.out.println(urunler[i].getName());
        }


        /*
        Burada yeni bir ürün ekleneceğinde tekrar new'leyip dizinin indexini
        değiştirmemiz gerektiği için önceki ürünlerin referansını kaybederiz
        bu yüzden arraylist kullanmamız daha doğrudur
        CreditManager[] credits = new CreditManager[3];
        credits[0] = new MortgageManager();
        credits[1] = new VehicleManager();
        credits[2] = new OfficerManager();
        */

        ArrayList<CreditManager> credits = new ArrayList<CreditManager>();
        credits.add(new OfficerManager());
        credits.add(new VehicleManager());
        credits.add(new MortgageManager());

        for(CreditManager credit : credits){
            credit.calculate();
        }


    }
    public static void mesajVer(String isim){
        System.out.println("Merhaba " + isim);
    }
    public static void hesapla(){
        System.out.println("Hesaplandı");
    }
    public static int topla(int sayi1, int sayi2){
        int toplam = sayi1 + sayi2;
        return toplam;
    }
    public static double toplananİkiSayininYuzdeOnu(int sayi1, int sayi2){
        int toplam = topla(sayi1,sayi2);
        double sonuc = toplam * 10/100;
        return sonuc;
    }

    public static boolean sayiBul(int[] sayilar, int aranacak){

        boolean varMi = false;
        for(int sayi : sayilar){
            if(sayi == aranacak){
                varMi = true;
                break;
            }
        }
        return varMi;
    }

    public static void mesajVer(boolean varMi, int aranacak){
        String mesaj = "";
        if(varMi == true){
            mesaj = "Sayı mevcuttur : " + aranacak;
            System.out.println(mesaj);
        }else{
            mesaj = "Sayı mevcut değildir : " + aranacak;
            System.out.println(mesaj);
        }
    }


}

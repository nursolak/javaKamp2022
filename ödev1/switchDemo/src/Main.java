public class Main {

    public static void main(String[] args) {
        char grade = 'B';

        switch(grade){
            case 'A':
                System.out.println("Mükemmel : Geçtiniz");
                break;
            case 'B':
                System.out.println("Çok Güzel : Geçtiniz");
                break;
            case 'C':
            case 'D':
                System.out.println("İyi : Geçtiniz");
                break;
            case 'F':
                System.out.println("Malesef Kaldınız");
                break;
        }

    }
}

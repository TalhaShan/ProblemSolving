package Strings;

public class StringObjects {

    public static void main(String[] args) {
        String a  =  "talha";
        String b  =  "talha";
        String c = a;
        System.out.println(a==b);
        System.out.println(a==c);

        String y = new String("talha");
        String z = new String("talha");

        System.out.println(y==z);

    }
}

package Nov;

public class CountDigits {
    static int digits(int num){
     return  (int) Math.log10((num))+1;
    }
    public static void main(String[] args) {
        System.out.println(digits(1234567));
   
    }
}

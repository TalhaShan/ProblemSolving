package Recursion;

public class HelloWorld {

    static void message(){
        System.out.println("Hello World");
        message1();
    }

    static void message1(){
        System.out.println("Hello World");
        message2();
    }

    static void message2(){
        System.out.println("Hello World");
        message3();
    }

    static void message3(){
        System.out.println("Hello World");
        message4();
    }

    static void message4(){
        System.out.println("Hello World");
    }

    static  void print5(int n){
        if(n>5){
            return;
        }
        System.out.println(n);
        print5(n+1);
    }
    public static void main(String[] args) {
//        message();
            print5(1);
    }
}

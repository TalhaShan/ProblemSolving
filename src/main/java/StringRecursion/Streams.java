package StringRecursion;

public class Streams {

    static void process(String org, String ans) {
        if (org.isEmpty()) {
            System.out.println(ans);
            return;
        }

        char ch = org.charAt(0);
        if (ch == 'a') {
            process(org.substring(1), ans);
        } else {
            process(org.substring(1), ans + ch);
        }
    }


    static String processV2(String str) {
        if (str.isEmpty()) {
            return "";
        }

        char ch = str.charAt(0);
        if (ch == 'a') {
            return processV2(str.substring(1));
        } else {
            return ch + processV2(str.substring(1));
        }
    }


    static String skipApple(String str) {
        if (str.isEmpty()) {
            return "";
        }


        if (str.startsWith("apple")) {
            return skipApple(str.substring(5));
        } else {
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }


    static String skipAppNotApple(String str) {
        if (str.isEmpty()) {
            return "";
        }


        if (str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(3));
        } else {
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }
    public static void main(String[] args) {
        //process("baccad", "");
//        System.out.println(processV2("baccad"));
        System.out.println(skipAppNotApple("bachcappleasdappklo"));
    }

}

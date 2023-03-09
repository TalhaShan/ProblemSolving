package SdeSheet;

public class ReverseVowel {

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;

        while (left<right){
            boolean isLeftVow = isVowel(arr[left]);
            boolean isRightVow = isVowel(arr[right]);
            if(isRightVow && isLeftVow){
                swap(arr,left,right);
                ++left;
                right--;
            }
            if(!isLeftVow){
                ++left;
            }
            if(!isRightVow){
                right--;
            }

        }
        return  new String(arr);
    }

    static void swap(char[] arr , int left, int right){
        char temp= arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }


    static boolean isVowel(Character letter){
        char c = Character.toLowerCase(letter);

        return c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u';
    }

}

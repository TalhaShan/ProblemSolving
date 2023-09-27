import java.util.HashSet;

public class UniqueEmailAddress {

//
//    ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
//    Output: 2
//        testemail@leetcode.com, test.email@leetcode.com,testemail@leet.tcode.com


    public static int numUniqueEmails(String[] emails) {

        HashSet<String> set = new HashSet<>();
        for(String s:emails){
            String[] dots = s.split("@");
            String email = dots[0];
            if(email.contains("+")) {
               email =  email.substring(0, email.indexOf("+"));
            }
            String org = email.replace(".","");
            set.add(org+"@"+dots[1]);
        }

        return set.size();
    }

    public static void main(String[] args) {

        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"}));
        //testemail@leetcode.com
        //testemailleet@code.com

            //testemailleetcode.com

    }
}

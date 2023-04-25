package SdeSheet;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'validateRequests' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY blacklisted_ips
     *  2. STRING_ARRAY requests
     */

    public static List<Integer> validateRequests(List<String> blacklisted_ips, List<String> requests) {
    // Write your code here
    List<Integer> res = new ArrayList<>();
    HashMap<String,Integer> blocked = new HashMap<>();
        for(String req: requests){
            String [] split = req.split("\\.");
            if(blacklisted_ips.contains(split[0]+".*")){
                res.add(1);
                if(blocked.containsKey(req)){
                   int value =  blocked.get(req);
                   if(value<=5){
                   blocked.put(req, value+1);
                   res.add(1);
                   }else{
                       blocked.put(req, 0);
                   }
         
                }else{
                    blocked.put(req, 1);
                }
                
            }            
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int blacklisted_ipsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> blacklisted_ips = IntStream.range(0, blacklisted_ipsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int requestsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> requests = IntStream.range(0, requestsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.validateRequests(blacklisted_ips, requests);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

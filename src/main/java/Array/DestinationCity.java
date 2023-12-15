package Array;

import java.util.*;

public class DestinationCity {
//    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
    public static String destCity(List<List<String>> paths) {
        if(paths.size()==1) return paths.get(0).get(1);
        List<String> possibleDest=new ArrayList<>();
        List<String> source = new ArrayList<>();
            for(int i=0; i<paths.size(); i++){
                for(int j=0; j<paths.get(i).size(); j++){
                    if(possibleDest.contains(paths.get(i).get(j))){
                        possibleDest.remove(paths.get(i).get(j));
                    }else {
                        if(j==0) source.add(paths.get(i).get(j));
                        if(j>0 && !source.contains(paths.get(i).get(j))) {
                            possibleDest.add(paths.get(i).get(j));
                        }
                    }
                }
            }


        return possibleDest.get(0);
    }

    public String destCity2(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();
        for (List<String> path : paths) {
            cities.add(path.get(0));
        }

        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!cities.contains(dest)) {
                return dest;
            }
        }
        return "";
    }
    public static void main(String[] args) {
//        List<List<String>> paths = Arrays.asList(
//                Arrays.asList("London", "New York"),
//                Arrays.asList("New York", "Lima"),
//                Arrays.asList("Lima", "Sao Paulo")
//        );
        List<List<String>> paths = Arrays.asList(
                Arrays.asList("B", "C"),
                Arrays.asList("D", "B"),
                Arrays.asList("C", "A")
        );
        System.out.println(destCity(paths));
    }
    public String destCity3(List<List<String>> paths) {
        if(paths.size()==1)
            return paths.get(0).get(1);

        HashMap<String, String> hm = new HashMap<>();
        for(List<String> path: paths){
            hm.put(path.get(0),path.get(1));
        }

        String destination = paths.get(0).get(0);
        while(hm.containsKey(destination)){
            destination = hm.get(destination);
        }
        return destination;

    }
}

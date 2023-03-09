package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>(); //to add visited ones
        boolean vis[] = new boolean[V]; //to keep track of visited nodes
        Queue<Integer> q = new LinkedList<>();  ///Queue to put and pop
        q.add(0);  //starting from 0
        vis[0] = true;

        while (!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it:adj.get(node)){  //traversing the whole level
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }

        }
        return bfs;
    }
}

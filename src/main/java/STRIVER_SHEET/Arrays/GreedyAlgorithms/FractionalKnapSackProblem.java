package STRIVER_SHEET.Arrays.GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSackProblem {
    class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

    //so basic core is weight/value which item can get more fraction valueper weight
    //so we will sort above logic in descending error as we need to go greedy
    static class itemCompartor implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            double val1 = o1.weight / o1.value;
            double val2 = o2.weight / o2.value;

            if (val2 > val1) {
                return 1;
            } else if (val2 < val1) {
                return -1;
            }
            return 0;
        }
    }

    static double fractionalKnapsack(int W, Item arr[], int n) {
        double total = 0;
        Arrays.sort(arr, new itemCompartor());
        int currentW = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                total += arr[i].value;
                W -= arr[i].weight;
            } else {
                //now we need to go fraction
                if (W > 0) {  //still something left
                    total += ((double) arr[i].value / (double) arr[i].weight) * (double) W;
                    break;

                }
            }
        }
        return total;
    }
}

/*
import java.util.*;
class Item {
  int value, weight;
  Item(int x, int y) {
    this.value = x;
    this.weight = y;
  }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b)
    {
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1 < r2) return 1;
        else if(r1 > r2) return -1;
        else return 0;
    }
}
public class solve{
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());

        int curWeight = 0;
        double finalvalue = 0.0;

        for (int i = 0; i < n; i++) {

            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }

            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }

        return finalvalue;

    }
    public static void main(String args[])
    {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }
}
 */


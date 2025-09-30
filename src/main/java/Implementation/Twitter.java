package Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Tweet implements Comparable<Tweet>{
     int time;
     int tweetId;

     Tweet(int time, int tweetId){
         this.time = time;
         this.tweetId = tweetId;
     }

     @Override
     public int compareTo(Tweet that) {
         //sort order desc
         return that.time-this.time;
     }
 }

 class User{
     int userId;
     HashSet<Integer> followers;
     List<Tweet> tweets;
     User(int userId){
         this.userId = userId;
         followers = new HashSet<>();
         followers.add(userId);// why it will be helpful incase of getFeeds :D if we follow ourslef as we can also see our tweetd
         tweets = new LinkedList<>();
     }

     public void addTweet(Tweet tweet){
         tweets.add(0,tweet); //insertion at the head of linkedList
     }

     public void addFollower( int followeeId){
        followers.add(followeeId);
     }

     public void removeFollower( int followeeId){
         followers.remove(followeeId);
     }
 }
class Twitter {
     HashMap<Integer,User> userMap;
     int timeCounter;
    public Twitter() {
        userMap = new HashMap<>();
        timeCounter =0;
    }
    
    public void postTweet(int userId, int tweetId) {
        //increment TimeCointer ++
        timeCounter++;
        //In case user not there we will create it
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        //Now we also need this tweet to add to his feed as we will fetch 10 most recent including our own persona; tweet
        User user = userMap.get(userId);
            user.addTweet(new Tweet(timeCounter,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)){
            return new ArrayList<>(); //in case user not exist //List interface so can return array or LinkedList upto u.
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);
        //T O(N) //N followers
        for(int followerId:user.followers){ //A so here we getting most recent 10 tweets of each user
            int count =0 ;
            for(Tweet tweet:userMap.get(followerId).tweets){   //T O(T) //T tweets
                pq.offer(tweet); //logT
                count++;
                if(count>10){
                    break;
                }
            }
        }// ---A---
        //So overall it should be   //Time O(N*TlogT) // but we gave it 10 counter so // Time O(N*Tlog10)

        //Now we also need to fetch our tweet as it can be in most recent 10 tweets
        // Although there is one quick hack to avoid this and that is we make our self follow our self we are in follwersList in above loop as well
//        int count=0;
//        for(Tweet tweet:user.tweets){
//            pq.offer(tweet);
//            count++;
//            if(count>10){
//                break;
//            }
//        }
        // End Although there is one quick hack to avoid this and that is we make our self follow our self we are in follwersList in above loop as well

        List<Integer> result = new ArrayList<>();
        int index=0;
        while (!pq.isEmpty() && index<10){
           Tweet tweet = pq.poll();
           result.add(tweet.tweetId);
           index++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        //incase follower does not exist
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        //incase followee does not exist
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        // A-> Can see Tweet of B if and only if A follows B, but B cannot see tweet of A until it also follows A or follow back A
        //How to add new follower
        User user = userMap.get(followeeId);
        user.addFollower(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return;//in case user not exist
        }

        //How to remove new follower
        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}

//BETTER
/*
public void follow(int followerId, int followeeId) {
    // Create users if they don't exist
    userMap.putIfAbsent(followerId, new User(followerId));
    userMap.putIfAbsent(followeeId, new User(followeeId));

    // The follower (A) should add the followee (B) to their follow list
    User followerUser = userMap.get(followerId);
    followerUser.addFollower(followeeId);
}

public void unfollow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
        return;
    }

    // A can only unfollow B, but should not unfollow himself
    if (followerId == followeeId) return;

    User followerUser = userMap.get(followerId);
    followerUser.removeFollower(followeeId);
}
 */

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

//Max Heap or Priority Queue will do our work for most recent 10 tweets.


//Final working one
/*
import java.util.*;

class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }

    @Override
    public int compareTo(Tweet that) {
        // Sort in descending order of time (newest first)
        return that.time - this.time;
    }
}

class User {
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        followers.add(userId); // Follow self
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet tweet) {
        tweets.add(0, tweet); // Insert at head
    }

    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        if (followeeId != this.userId) { // Don't allow unfollowing self
            followers.remove(followeeId);
        }
    }
}

class Twitter {
    HashMap<Integer, User> userMap;
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        userMap.putIfAbsent(userId, new User(userId));
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);

        for (int followeeId : user.followers) {
            List<Tweet> tweets = userMap.get(followeeId).tweets;
            int count = 0;
            for (Tweet tweet : tweets) {
                pq.offer(tweet);
                count++;
                if (count >= 10) break;
            }
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (!pq.isEmpty() && index < 10) {
            result.add(pq.poll().tweetId);
            index++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        // Add followee to follower's follow list
        User followerUser = userMap.get(followerId);
        followerUser.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;

        User followerUser = userMap.get(followerId);
        followerUser.removeFollower(followeeId);
    }
}
 */
package edu.sdccd.cisc191;

import java.util.HashMap;

public class HashMapProducer {
    HashMap<String, String> map;

    public HashMapProducer(HashMap <String, String> map){
        this.map = map;
    }
    public void produce(String a, String b){
        map.put(a,b);
        return;
    }
}

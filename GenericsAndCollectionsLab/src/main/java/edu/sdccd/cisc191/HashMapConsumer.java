package edu.sdccd.cisc191;

import java.util.HashMap;

public class HashMapConsumer {
    private HashMap<String, String> map;
    public HashMapConsumer(HashMap<String, String> map) {this.map = map;}
    public String consume(String a){
        String current = map.get(a);
        return current;
    }
}

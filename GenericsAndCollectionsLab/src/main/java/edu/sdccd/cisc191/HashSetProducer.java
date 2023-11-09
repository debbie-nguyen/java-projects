package edu.sdccd.cisc191;

import java.util.HashSet;
public class HashSetProducer {
    HashSet<String> map;

    public HashSetProducer(HashSet <String> map){
        this.map = map;
    }
    public boolean produce(String a){
        map.add(a);
        return false;
    }
}

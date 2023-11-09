package edu.sdccd.cisc191;

import java.util.HashSet;
public class HashSetConsumer {
    private HashSet<String> map;

    public HashSetConsumer(HashSet<String> map){this.map = map;}
    public boolean consume(String a){
        boolean current = map.remove(a);
        return current;
    }
}

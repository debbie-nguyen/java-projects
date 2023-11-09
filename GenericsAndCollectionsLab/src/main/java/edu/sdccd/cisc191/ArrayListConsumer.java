package edu.sdccd.cisc191;

import java.util.ArrayList;

public class ArrayListConsumer {
    // private ??? list;
    private ArrayList<String> list = new ArrayList<String>();

    public ArrayListConsumer(ArrayList<String> list)
    {
        // TODO complete the constructor
        this.list = list;
    }

    public String consume()
    {
        // TODO change the returned value
        String current = list.get(0);
        list.remove(0);
        return  current;
    }
}

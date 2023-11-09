package edu.sdccd.cisc191;

import java.util.ArrayList;

public class ArrayListProducer {
    // private ??? list;
    private ArrayList<String> list = new ArrayList<String>();

    public ArrayListProducer(ArrayList<String> list)
    {
        // TODO complete the constructor
        this.list = list;
    }

    public void produce(int i, String string)
    {
        // TODO implement the method
        list.add(i, string);
    }
}

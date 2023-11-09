package edu.sdccd.cisc191;

public class ArrayProducer {
    private String[] producer = new String[2];

    public ArrayProducer(String[] producer)
    {
        this.producer=producer;
    }

    public void produce(int i, String string)
    {
        producer[i]=string;
    }
}

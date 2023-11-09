package edu.sdccd.cisc191;

public class ArrayConsumer {
    String text []= new String[2];
    public ArrayConsumer(String[] text){
        this.text= text;
    }

    public String consume(){
        if (text[0]!=null){
            String current =text[0];
            text[0]=null;
            return current;
        }
        else
            return text[1];
    }
}

package org.drogo.basics.oop.generics;

import java.util.Arrays;

public class CustomArrayList<T extends Number> {

    private Object[] data;
    private int size=0;
    private static int DEFAULT_SIZE=10;

    public CustomArrayList() {
        this.data= new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++]= num;

    }

    public T remove(){
        return (T) data[--size];
    }

    public T get(int index){
        return (T) data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
         data[index]=value;
    }

    private void resize() {
        Object[] temp= new Object[data.length * 2];
        for (int i=0;i< data.length;i++){
            temp[i]=data[i];
        }

        data=temp;
    }

    private boolean isFull() {
        return size== data.length;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}

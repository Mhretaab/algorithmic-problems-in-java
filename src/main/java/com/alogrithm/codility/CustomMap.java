package com.alogrithm.codility;

import java.util.ArrayList;
import java.util.List;

public class CustomMap{
    private List<Object> hashTable;
    private int leastRecentlyAccessed = -1;
    private boolean quitReceiving;

    public CustomMap() {
        this.hashTable = new ArrayList<>();
        this.quitReceiving = false;
    }

    public String[] values(){
        List objects = new ArrayList();
        for(Object o : hashTable){
            if(o != null){
                objects.add(o);
            }
        }

        String[] solution = new String[objects.size()];
        for(int i = 0; i < solution.length; ++i)
            solution[i] = (String) objects.get(i);

        return solution;
    }

    public void add(Object key, Object value){
        if(!this.quitReceiving){
            this.leastRecentlyAccessed = key.hashCode();
            this.hashTable.add(key.hashCode(), value);
        }
    }

    public Object get(Object key){
        try {
            this.leastRecentlyAccessed = key.hashCode();
            Object value = this.hashTable.get(key.hashCode());
            if(value != null){
                return value;
            }else {
                Integer notFound = -1;
                return notFound;
            }
        }catch (Exception e){
            Integer notFound = -1;
            return notFound;
        }
    }

    public Object remove(Object key){
        try {
            Object value = this.hashTable.remove(key.hashCode());
            if(value != null){
                return value;
            }else {
                Integer notFound = -1;
                return notFound;
            }
        }catch (Exception e){
            Integer v = -1;
            return v;
        }
    }

    public void evict(){
        if(this.leastRecentlyAccessed != -1){
            this.hashTable.remove(this.leastRecentlyAccessed);
        }
    }

    public void exit(){
        this.quitReceiving = true;
    }

    public String[] solution(String[] n) {
        // write your code in Java 8
        CustomMap customMap = new CustomMap();

        for(String operation : n){
            String[] operationData = operation.split(" ");
            switch(operationData[0]){
                case "add":
                    customMap.add(operationData[1], operationData[2]);
                    break;
                case "get":
                    customMap.get(operationData[1]);
                    break;
                case "remove":
                    customMap.remove(operationData[1]);
                    break;
                case "evict":
                    customMap.evict();
                    break;
                case "exit":
                    customMap.exit();
                    break;
            }
        }

        return n;
    }
}

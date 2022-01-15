package com.alogrithm.codility;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    enum ProcessStates{
        CREATED,
        WAITING,
        RUNNING,
        TERMINATED;
    }
    public final static String[] PROCESSES = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public String solution(int t, String[] logs) {
        // write your code in Java 8

        int processesRunningAtLoggingTime = 0;
        String runningProcess = "";

        for(String process : PROCESSES){
            String lastLogBeforeLogTime = getLastLogBeforeLogTime(process, t, logs);
            if(!lastLogBeforeLogTime.contains(ProcessStates.RUNNING.name().toLowerCase())){
                continue;
            }else {
                processesRunningAtLoggingTime++;
                runningProcess = process;
            }
        }

        return processesRunningAtLoggingTime > 1 ? "-1" : runningProcess;
    }

    //Get the last log of a given process at a time or before the log time
    private String getLastLogBeforeLogTime(String process, int logTime, String[] logs){
        String lastLog = "";
        int lastProcessLogTime = Integer.MIN_VALUE;
        for(String log : logs){
            String[] processData = log.split(" ");
            if(processData[1].equalsIgnoreCase(process)){
                int processLogTime = Integer.parseInt(processData[0]);
                if(processLogTime <= logTime && lastProcessLogTime < processLogTime){
                    lastProcessLogTime = processLogTime;
                    lastLog = log;
                }
            }
        }

        return lastLog;
    }

}

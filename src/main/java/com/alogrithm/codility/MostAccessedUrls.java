package com.alogrithm.codility;

import java.util.*;

public class MostAccessedUrls {

    private class UrlOccurrence{
        String url;
        int occurrence;

        public UrlOccurrence(String url, int occurrence) {
            this.url = url;
            this.occurrence = occurrence;
        }
    }

    public String[] solution(int n, String[] logs) {
        // write your code in Java 8
        Map<String, Integer> urlNumberOfAccess = new HashMap<>();

        for(String log : logs){
            String[] logData = log.split(" ");
            String logStatus = logData[1];
            String url = logData[2];
            if(logStatus.equals("200")){
                if(urlNumberOfAccess.containsKey(url)){
                    urlNumberOfAccess.put(url, urlNumberOfAccess.get(url) + 1);
                }else {
                    urlNumberOfAccess.put(url, 1);
                }
            }
        }

        List<UrlOccurrence> urlOccurrences = new ArrayList<>();
        for(String key : urlNumberOfAccess.keySet()){
            urlOccurrences.add(new UrlOccurrence(key, urlNumberOfAccess.get(key)));
        }

        Collections.sort(urlOccurrences, (url1, url2) -> {
            int value = 1;
            if(url1.occurrence > url2.occurrence){
                value = -1;
            }else if(url1.occurrence == url2.occurrence){
                value = url1.url.compareTo(url2.url);
            }
            return value;
        });

        String[] topAccessedUrls = new String[n];
        for(int i = 0; i < n; ++i)
            topAccessedUrls[i] = urlOccurrences.get(i).url;

        return topAccessedUrls;
    }

    public static void main(String[] args) {
        String[] logs = {
                "10.20.31.12 200 http://example.com/index",
                "10.20.30.12 200 http://example.com/welcome",
                "10.20.31.11 200 http://example.com/index",
                "192.168.10.12 200 http://example.com/index",
                "192.168.15.12 404 http://example.com/nonono",
                "192.168.17.12 404 http://example.com/nonono"
        };
        MostAccessedUrls mostAccessedUrls = new MostAccessedUrls();
        System.out.println(Arrays.toString(mostAccessedUrls.solution(2, logs)));
    }
}

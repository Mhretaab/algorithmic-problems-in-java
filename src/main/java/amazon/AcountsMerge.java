package amazon;

import com.alogrithm.dynamicconnectivity.QuickUnion;

import java.util.*;

public class AcountsMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> berhe = new ArrayList<>();
        berhe.add("berhe");
        berhe.add("berhe1@email.com");
        berhe.add("email_2@email.com");

        List<String> berhe2 = new ArrayList<>();
        berhe2.add("berhe");
        berhe2.add("gmail@email.com");
        berhe2.add("hotmail@email.com");

        List<String> berhe3 = new ArrayList<>();
        berhe3.add("berhe");
        berhe3.add("gmail@email.com");
        berhe3.add("email_2@email.com");

        List<String> berhe4 = new ArrayList<>();
        berhe4.add("berhe");
        berhe4.add("yahoo@email.com");

        List<String> mhret = new ArrayList<>();
        mhret.add("mhret");
        mhret.add("mhret@email.com");
        
        accounts.add(berhe);
        accounts.add(mhret);
        accounts.add(berhe2);
        accounts.add(berhe3);
        accounts.add(berhe4);

        System.out.println(solve(accounts));
        
    }

    private static List<List<String>> solve(List<List<String>> accounts) {
        QuickUnion quickUnion = new QuickUnion(accounts.size());

        Map<String, Integer> emailToAccountsIndex = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int k = 1; k < account.size(); ++k){
                String email = account.get(k);
                if(email != null) {
                    if(emailToAccountsIndex.containsKey(email)){
                        quickUnion.union(emailToAccountsIndex.get(email), i);
                    }else {
                        emailToAccountsIndex.put(email, i);
                    }
                }
            }
        }

        int numberOfGroupedAccounts = quickUnion.numberOfComponents();
        List<List<String>> mergedAccounts = new ArrayList<>(numberOfGroupedAccounts);
        for(int i = 0; i < numberOfGroupedAccounts; ++i){
            mergedAccounts.add(new ArrayList<>());
        }

        Map<Integer, Integer> groupIdToIndex = new HashMap<>();
        int nextIdx = 0;
        for(Map.Entry<String, Integer> entry : emailToAccountsIndex.entrySet()){
            String email = entry.getKey();
            int groupId = quickUnion.root(entry.getValue());

            if(groupIdToIndex.containsKey(groupId)){
                mergedAccounts.get(groupIdToIndex.get(groupId)).add(email);
            }else {
                groupIdToIndex.put(groupId, nextIdx);
                String name = accounts.get(groupId).get(0);
                mergedAccounts.get(nextIdx).add(name);
                mergedAccounts.get(nextIdx).add(email);
                nextIdx++;
            }
        }

        /*List<List<String>> result = new ArrayList<>(numberOfGroupedAccounts);
        for(int i = 0; i < numberOfGroupedAccounts; ++i){
            result.add(new ArrayList<>());
        }
        for(int i = 0; i < mergedAccounts.size(); ++i){
            List<String> account = mergedAccounts.get(i);
            List<String> emails = account.subList(1, mergedAccounts.size()-1);
            Collections.sort(emails);
            emails.add(0, account.get(0));
            result.add(emails);
        }*/
        for(List<String> account : mergedAccounts){
            Collections.sort(account.subList(1, mergedAccounts.size() - 1));
        }

        return mergedAccounts;
    }
}

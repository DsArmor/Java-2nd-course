import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public Solution() {
    }

    public <T> ArrayList<T> newArrayList(T[] mas){
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, mas);
        return arrayList;
    }

    public <T> HashSet<T> newHashSet(T[] mas){
        HashSet<T> hashSet = new HashSet<>();
        Collections.addAll(hashSet, mas);
        return hashSet;
    }

    public <K, V> HashMap<K, V> newHashMap(K[] ks, V[] vs){
        HashMap<K, V> hashMap = new HashMap<K, V>();
        try{
            for (int i = 0; i < ks.length; i++){
                hashMap.put(ks[i], vs[i]);
            }
        } catch (Exception e){
            System.out.println("Что то пошло не так");
        }
        return hashMap;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

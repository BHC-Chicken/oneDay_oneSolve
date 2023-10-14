import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static Set<String> set = new HashSet<>();
    
    public int solution(String str1, String str2) {
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();

        slice(arr1, str1);
        slice(arr2, str2);

        Collections.sort(arr1);
        Collections.sort(arr2);

        double score = 0.0;

        List<String> gyo = new ArrayList<>();
        List<String> hap = new ArrayList<>();

        for (String word : set) {
            long count1 = arr1
                    .stream()
                    .filter(a -> a.equals(word))
                    .count();

            long count2 = arr2
                    .stream()
                    .filter(a -> a.equals(word))
                    .count();

            if (count1 > count2) {
                for (int i = 0; i < count1; i++) {
                    hap.add(word);
                }
                for (int i = 0; i < count2; i++) {
                    gyo.add(word);
                }
            } else {
                for (int i = 0; i < count2; i++) {
                    hap.add(word);
                }
                for (int i = 0; i < count1; i++) {
                    gyo.add(word);
                }
            }
        }

        if (gyo.isEmpty() && hap.isEmpty()) {
            score = 1;
        } else {
            score = (double) gyo.size() / hap.size();
        }

        return (int) (score * 65536);
    }
    
    static void slice(List<String> arr, String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (isWord(word.charAt(i)) && isWord(word.charAt(i + 1))) {
                String result =
                        String.valueOf(word.charAt(i)).toUpperCase() + String.valueOf(word.charAt(i + 1)).toUpperCase();
                arr.add(result);
                set.add(result);
            }
        }
    }

    static boolean isWord(char word) {
        return word >= 65 && word <= 90 || word >= 97 && word <= 122;
    }
}
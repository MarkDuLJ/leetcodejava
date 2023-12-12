import java.io.BufferedReader;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        Solution242 res = new Solution242();
//        System.out.println(res.isAnagram("anagram","nagaram"));
        System.out.println(res.isAnagram("anagramm","marganaa"));


    }

}

/*
*Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies.
* */

class Solution242{
    public boolean isAnagram(String s, String t){
        if(s.length()!= t.length()) return false;
        Hashtable<Character, Integer> charset = new Hashtable<>();
        Hashtable<Character, Integer> charset1 = new Hashtable<>();

        for (char c :
                s.toLowerCase().toCharArray()) {

                charset.compute(c,(name,freq) -> (freq == null) ? 1 : ++freq);

        }
        for (char c :
                t.toLowerCase().toCharArray()) {
                charset1.compute(c,(name,freq) -> (freq == null) ? 1 : ++freq);
        }

        return charset1.equals(charset);
    }

}



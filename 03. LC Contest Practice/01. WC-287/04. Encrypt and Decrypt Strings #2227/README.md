# [**2227. Encrypt and Decrypt Strings**](https://leetcode.com/problems/encrypt-and-decrypt-strings/)

## Approach 1 : use 2 HM
- Explanation
- The hashmap ```cv``` help binding each pair of keys[i] and values[i],
so that we can encrypt a char to the string in O(1)

- ed_f counts the frequency of words in dictionary after encrypt,
then we can used in decrypt in O(1).

```java
class Encrypter {
    HashMap<Character, String> cv; // character-Value(2letterString)
    HashMap<String, Integer> ed_f; // encryptedDictionary-frequency

    public Encrypter(char[] k, String[] v, String[] d) {
        cv=new HashMap<>();
        for(int i=0; i<k.length; i++) cv.put(k[i],v[i]);
        
        ed_f=new HashMap<>(); // encrypted dictionary wrd - frequency
        for(String s: d){
            String e=encrypt(s);
            ed_f.put(e, ed_f.getOrDefault(e,0)+1);
        }
        
    }
    
    public String encrypt(String wrd1) {
        StringBuilder res = new StringBuilder();
        for(char c : wrd1.toCharArray()){
            String ap = cv.getOrDefault(c, "#");
            if(ap=="#") return "";
            res.append(ap);
        }
        return res.toString();
    }
    
    public int decrypt(String wrd2) {
        return ed_f.getOrDefault(wrd2,0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
```
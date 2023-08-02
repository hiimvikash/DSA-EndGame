## [Reverse words in a given string](https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1)
### Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
- S = i.like.this.program.very.much
- Output: much.very.program.this.like.i

## Approach :-
```
The idea is to in-place reverse each word present in the input text and finally reverse the whole text to get the desired output. For instance,

Input text: Preparation.Interview.Technical
 
1. Reverse each word:
noitaraperp.weivretnI.lacinhceT
 
2. Reverse the whole text:
Technical.Interview.Preparation
```

```java
class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here 
        char ch[] = s.toCharArray();
        int low = 0;
        int n = ch.length;
        for(int i = 0; i<n; i++){
            if(ch[i] == '.'){
                reverseText(ch, low, i-1);
                low = i+1;
            }
            else if(i == n-1){
                reverseText(ch, low, i);
            }
        }
        
        reverseText(ch, 0, n-1);
        
        return String.valueOf(ch);
    }
    
    void reverseText(char ch[], int s, int e){
        if(s > e) return;
        
        char temp = ch[s];
        ch[s] = ch[e];
        ch[e] = temp;
        
        reverseText(ch, ++s, --e);
    }
}
```
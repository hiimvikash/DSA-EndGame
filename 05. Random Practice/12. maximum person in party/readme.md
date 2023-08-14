You are given a event where person p[i] is either entering the hall('+') or leaving the hall ('-'), you need to find maximum person in the hall that were present in any point of time.

<hr>

![WhatsApp Image 2023-08-11 at 13 17 10](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/cb571fd3-df87-46ff-a184-4139607277a5)
![WhatsApp Image 2023-08-11 at 13 17 11](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/24f83967-800e-4da6-9b71-267f64769d04)

```java
public static void main(String[] args) {
        int p[] = {1, 2, 2, 3, 1,4};
        char status[] = {'+', '+', '-', '+', '-','-'};
        int n = p.length;
        System.out.println(getMaxCount(p, status, n));
    }
    
    private static int getMaxCount(int p[], char status[], int q){
        Set<Integer> st=new HashSet<>();
        int max = 0;
        for(int i = 0; i<q; i++){
            if(status[i] == '+'){
                if(st.contains(p[i])){
                    return -1;
                }else st.add(p[i]);
            }else{
                if(!st.contains(p[i])){
                    return -1;
                }else st.remove(p[i]);
            }
            max = Math.max(max, st.size());
        }
        return max;
    }
```

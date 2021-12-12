# **[Next Smaller Element](https://www.geeksforgeeks.org/next-smaller-element/)**

```java
int[] nse(int arr[]){
	    int n=arr.length;
	    Stack<Integer> st=new Stack<>();
	    HashMap<Integer,Integer> hm=new HashMap<>();
	    
	    for(int i=0; i<n; i++){
	        if(st.isEmpty()){
	            st.push(arr[i]);
	        }
	        else{
	            while(!st.isEmpty() && arr[i]<st.peek()){
	                hm.put(st.pop(),arr[i]);
	            }
	            st.push(arr[i]);
	        }
	    }
	    for(int i=0; i<n; i++){
	        arr[i]=hm.getOrDefault(arr[i],-1);
	    }
	    return arr;
}
```


package arrays;
public class MinMax {

	public static void main(String[] args) {
		//            0  1  2    3  4    5  6    7
		int arr[]= {-900,23,67,1200,34,9800,0,-1000};
		int n=arr.length;
		MinMaxe mm=getMinMax(arr,n);
		
		System.out.println("Maximum Element in an array= "+mm.max);
		System.out.println("Minimum Element in an array= "+mm.min);
	}
	
	public static MinMaxe getMinMax(int arr[],int n){
	    int maxI;
	    int minI;
	    int maxJ;
	    int minJ;
	    maxI=maxJ=-999999;
	    minI=minJ=999999;
	    
	    int mid=n/2;
	    if(n%2!=0)// if odd
	        mid+=1;
	        
	    for(int i=0,j=mid; i<mid; i++){
	        maxI=Math.max(maxI,arr[i]);
	        maxJ=Math.max(maxJ,arr[j]);
	        
	        minI=Math.min(minI,arr[i]);
	        minJ=Math.min(minJ,arr[j]);
	        if(j<n-1) j++;
	    }
	    MinMaxe obj=new MinMaxe();
	    obj.max=Math.max(maxI,maxJ);
	    obj.min=Math.min(minI,minJ);
	    return obj;
	}

}
class MinMaxe{
    int max;
    int min;
    public MinMaxe(){
        max=-999999;
        min=999999;
    }
    
}    

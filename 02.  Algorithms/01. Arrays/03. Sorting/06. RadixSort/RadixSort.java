
import java.util.ArrayList;

public class RadixSort {
	
	public static void sort(int arr[],int div) //function to store based on their digit
	{
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>(); // array contains list which has elemnets according to their digit
		for(int i=0;i<10;i++) //size of array taken as 10 i.e. 0 to 9
		{
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			array.add(tempList);
		}
		for(int i=0;i<arr.length;i++)
		{
			if(array.get((arr[i]/div)%10).size()==0) // if size of list at desired index of array is zero then create new list
			{
				
				ArrayList<Integer> tempList =new ArrayList<Integer>();
				tempList.add(arr[i]);
				array.add((arr[i]/div)%10, tempList);
			}
			else // if size of list at desired index of array is not zero then remove old list put new list at that index
			{
				ArrayList<Integer> tempList =new ArrayList<Integer>();
				tempList = array.get((arr[i]/div)%10);
				array.remove((arr[i]/div)%10);
				tempList.add(arr[i]);
				array.add((arr[i]/div)%10, tempList);
			}
		}
		
		int k=0; //put sorted values in the original array
		for(int i=0;i<array.size();i++)
		{
			if(array.get(i).size()!=0)
			{
				for(int j=0;j<array.get(i).size();j++)
				{
					arr[k] = array.get(i).get(j);
					k++;
				}
			}
		}
	}
	
	public static void radixSort(int arr[],int max)
	{
		for(int div=1;(max/div)>0;div=div*10) //loop runs as equal number of times as there are total number of digits in maximum integer
		{
			sort(arr,div);
		}
	}
	
	
	public static int max(int arr[]) //maximum number is found to calculate how many times loop will run 
	{
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
	}
	
	public static void print(int arr[]) //function to print final sorted array
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args)
	{
		int arr[] = {170,45,75,90,802,24,2,66};
		int max = max(arr);
		radixSort(arr,max);
		print(arr);
	}

}


/* Author: Shashank G
 * 
 * Merge Sort Algorithm
 * 
 * */


import java.util.Arrays;

class mergesort{
	
	public static void main(String[] args) throws Exception{
		
		int[] sorto = new int [8];
		sorto[0]=20;
		sorto[1]=10;
		sorto[2]=1;
		sorto[3]=5;
		sorto[4]=7;
		sorto[5]=6;
		sorto[6]=8;
		sorto[7]=12;

		int[] x= merge_sort(sorto);
		
		for (int a : x){
			System.out.println(a);
		}
		
	} // end of main
	
public static int[] merge_sort(int[] ab){	
		int mid = (ab.length/2);
		
		// Base Case
		if (ab.length ==1){
			return ab;
		}
		
		int[] LA= Arrays.copyOfRange(ab,0,mid);
		int[] RA= Arrays.copyOfRange(ab, mid, ab.length);
		
		int [] left  = merge_sort(LA);		// recursion
		int [] right = merge_sort(RA);		// recursion
		
		return merge(left, right);
	}
	
private static int [] merge(int [] a, int [] b){
		
		int m = a.length;
		int n = b.length;
		int [] result = new int [m+n];
		
		int k = m + n -1; 	// 0 based index of result buffer
		int i = m-1;		// last index of a	
		int j = n-1;		// last index of b
		
		while (i>=0 && j>=0 ){				// compare and fill result till one array ends
			if (a[i] > b[j]){
				result[k] = a[i];
				i-- ; k--;	
			}
			else{
				result[k] = b[j];
				j--; k--;
			}
		}// i =2; j = -1
		
		if (i < 0){					// put remaining b []
			while(j>=0){
				result[k] = b[j];
				k--; j--;
			}
		}
		
		if (j<0){					// put remaining a[]
			while (i>=0){
				result [k] = a[i];
				k--; i--;
			}
		}
		
		return result;
		
	
	}	// end of merge
		
	
	
}
/* Author: Shashank G
 * 
 * Given an array of numbers, find min in O(n) using recursion;
 *
 **/

import java.util.Arrays;

class findmin{
	
	public static void main(String[] args) throws Exception{
		
		int[] sorto = new int [10];
		sorto[0]=20;
		sorto[1]=50;
		sorto[2]=110;
		sorto[3]=2310;
		sorto[4]=101;
		sorto[5]=500;
		sorto[6]=1;
		sorto[7]=1;
		sorto[8]=29;
		sorto[9]=23101;
			
		findmin x= new findmin();
		System.out.println(x.find_min(sorto));
		
	}// end of main
	
	public int find_min(int[] ab){
			
		int mid = ab.length/2;
		
		// Base Case
		if (ab.length ==1){
			return ab[0];
		}
		
		else{
			int[] ML= Arrays.copyOfRange(ab,0,mid);
			int[] MR= Arrays.copyOfRange(ab, mid,ab.length);
			
			int left_max= find_min(ML);				// recursion
			int right_max = find_min(MR);			// recursion
			
			return Math.min(left_max,right_max);
			}
			
		}
		
	}
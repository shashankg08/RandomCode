/* Author: Shashank G
 * 
 * Given an array of numbers, find max in O(n) using recursion;
 *
 **/


import java.util.Arrays;

class findmax{
	
	public static void main(String[] args) throws Exception{
		
		int[] sorto = new int [10];
		sorto[0]=110100;
		sorto[1]=50;
		sorto[2]=110;
		sorto[3]=2310;
		sorto[4]=101;
		sorto[5]=500;
		sorto[6]=10;
		sorto[7]=1;
		sorto[8]=29;
		sorto[9]=23101;
			
		findmax x= new findmax();
		System.out.println(x.find_max(sorto));
		
	}// end of main
	
	public int find_max(int[] ab){
			
		int mid = ab.length/2;
		
		if (ab.length ==1){
			return ab[0];
		}
		else{
			int[] ML= Arrays.copyOfRange(ab,0,mid);
			int[] MR= Arrays.copyOfRange(ab, mid,ab.length);
			
			int left_max= find_max(ML);				// recursion
			int right_max = find_max(MR);			// recursion
			
			return Math.max(left_max,right_max);
			}
			
		}
		
	}
	
	

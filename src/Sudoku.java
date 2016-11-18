import java.util.Scanner;
import java.util.Arrays;
public class Sudoku {
	
	public static void main(String args[]) {
		
		
		/******************
		 *  Input Sudoku
		 ******************/
		System.out.println("Please input the puzzle in a string of number with no space:\nFor example '835416927296857431417293658569134782123678549748529163652781394981345276374962815', a string of 81 numbers, will be represented as\n");
		String dis = "s= {{8, 3, 5, 4, 1, 6, 9, 2, 7}\n{2, 9, 6, 8, 5, 7, 4, 3, 1}\n{4, 1, 7, 2, 9, 3, 6, 5, 8}\n{5, 6, 9, 1, 3, 4, 7, 8, 2}\n{1, 2, 3, 6, 7, 8, 5, 4, 9}\n{7, 4, 8, 5, 2, 9, 1, 6, 3}\n{6, 5, 2, 7, 8, 1, 3, 9, 4}\n{9, 8, 1, 3, 4, 5, 2, 7, 6}\n{3, 7, 4, 9, 6, 2, 8, 1, 5}}\n";
		System.out.print(dis);
		Scanner inputs = new Scanner(System.in);
		String nums = inputs.nextLine();
		
		//System.out.println(nums);
		
		
		char[] t1 = nums.toCharArray();
		
		char[][] s = new char[9][9]; 
		int count = 9;
		for(int i=0;i<9;i++){
			char[] t2 = Arrays.copyOfRange(t1, (count - 9), count);
			//System.out.println(t2.length + "DDDDDD\n");
			int j=8;
			//System.out.print(i);
			while(j>=0){
				s[i][j] = t2[j];
				j--;
				
			}
			count += 9;
		}
		
		/*char[][] s= {{8, 3, 5, 4, 1, 6, 9, 2, 7},
				 {2, 9, 6, 8, 5, 7, 4, 3, 1},
				 {4, 1, 7, 2, 9, 3, 6, 5, 8},
				 {5, 6, 9, 1, 3, 4, 7, 8, 2},
				 {1, 2, 3, 6, 7, 8, 5, 4, 9},
				 {7, 4, 8, 5, 2, 9, 1, 6, 3},
				 {6, 5, 2, 7, 8, 1, 3, 9, 4},
				 {9, 8, 1, 3, 4, 5, 2, 7, 6},
				 {3, 7, 4, 9, 6, 2, 8, 1, 5}}; */
		
		long startTime, elapsedTimeNs, elapsedTimeNs_s, elapsedTimeNs_ms, elapsedTimeNs_us, elapsedTimeNs_ns;
		

		
    	/******************
    	 *  1 Thread
    	 ******************/
    	startTime = System.nanoTime();   	
    	System.out.println(Thread1.RUN(s));
    	elapsedTimeNs = System.nanoTime() - startTime;
    	elapsedTimeNs_s = elapsedTimeNs/1000000000;
    	elapsedTimeNs %= 1000000000;
    	elapsedTimeNs_ms = elapsedTimeNs/1000000;
    	elapsedTimeNs %= 1000000;
    	elapsedTimeNs_us = elapsedTimeNs/1000;
    	elapsedTimeNs %= 1000;
    	elapsedTimeNs_ns = elapsedTimeNs/1;
    	System.out.println("Using 1 Thread, Final running time: " + elapsedTimeNs_s +"s "+ elapsedTimeNs_ms +"ms "+elapsedTimeNs_us+"us "+elapsedTimeNs_ns/1+"ns");

    	   	
    	/******************
		 *  3 Thread
		 ******************/
		startTime = System.nanoTime();   	
    	System.out.println(Thread3.RUN(s));
    	elapsedTimeNs = System.nanoTime() - startTime;
    	elapsedTimeNs_s = elapsedTimeNs/1000000000;
    	elapsedTimeNs %= 1000000000;
    	elapsedTimeNs_ms = elapsedTimeNs/1000000;
    	elapsedTimeNs %= 1000000;
    	elapsedTimeNs_us = elapsedTimeNs/1000;
    	elapsedTimeNs %= 1000;
    	elapsedTimeNs_ns = elapsedTimeNs/1;
    	System.out.println("Using 3 Threads, Final running time: " + elapsedTimeNs_s +"s "+ elapsedTimeNs_ms +"ms "+elapsedTimeNs_us+"us "+elapsedTimeNs_ns/1+"ns");


    	/******************
		 *  11 Thread
		 ******************/
		startTime = System.currentTimeMillis();   	
    	System.out.println(Thread11.RUN(s));
    	elapsedTimeNs = System.currentTimeMillis() - startTime;
    	elapsedTimeNs_s = elapsedTimeNs/1000;
    	elapsedTimeNs %= 1000;
    	elapsedTimeNs_ms = elapsedTimeNs/1;
    	elapsedTimeNs %= 1;
    	elapsedTimeNs_us = elapsedTimeNs/1;
    	elapsedTimeNs %= 1;
    	elapsedTimeNs_ns = elapsedTimeNs/1;
    	System.out.println("Using 11 Threads, Final running time: " + elapsedTimeNs_s +"s "+ elapsedTimeNs_ms +"ms "+elapsedTimeNs_us+"us "+elapsedTimeNs_ns/1+"ns");
    	

    	
    	/******************
		 *  27 Thread
		 ******************/
		startTime = System.nanoTime();   	
    	System.out.println(Thread27.RUN(s));
    	elapsedTimeNs = System.nanoTime() - startTime;
    	elapsedTimeNs_s = elapsedTimeNs/1000000000;
    	elapsedTimeNs %= 1000000000;
    	elapsedTimeNs_ms = elapsedTimeNs/1000000;
    	elapsedTimeNs %= 1000000;
    	elapsedTimeNs_us = elapsedTimeNs/1000;
    	elapsedTimeNs %= 1000;
    	elapsedTimeNs_ns = elapsedTimeNs/1;
    	System.out.println("Using 27 Threads, Final running time: " + elapsedTimeNs_s +"s "+ elapsedTimeNs_ms +"ms "+elapsedTimeNs_us+"us "+elapsedTimeNs_ns/1+"ns");
    	

	      
	   }   
}

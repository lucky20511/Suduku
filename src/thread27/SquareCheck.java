package thread27;

import java.util.HashSet;

public class SquareCheck extends Thread {
	   public Thread t;
	   private int threadNum;
	   private int[] nums;
	   private HashSet<Character> hashset= new HashSet<Character>();;
	   private char[][] board;
	   private int offset;
	   
	   public SquareCheck(int num, int[] a, char[][] b, int c) {
		   hashset = new HashSet<Character>();
		   threadNum = num;
		   nums=a;
		   board = b;
		   offset = c;
		   //System.out.println("Creating SquareCheck " +  threadNum );
	   }
	   
	   public void run() {
		   for(int i = 0; i < 9; i++)
			   if(!hashset.add(board[i/3 + 3*(threadNum/3)][i%3 + 3*(threadNum%3)]))
				   return;
			
		   nums[offset+threadNum] = 1;
		   //System.out.println("SquareCheck  Thread " +  threadNum + " exiting.");
	   }

	   public void start () {
		   if (t == null) {
			   t = new Thread (this, Integer.toString(threadNum));
			   t.start();
		   }
	   }
}

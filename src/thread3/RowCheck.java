package thread3;

import java.util.HashSet;

public class RowCheck extends Thread {
	   public Thread t;
	   private int[] nums;
	   private HashSet<Character> hashset= new HashSet<Character>();;
	   private char[][] board;
	   private int offset;
	   
	   public RowCheck(int[] a, char[][] b, int c) {
		   hashset = new HashSet<Character>();
		   nums=a;
		   board = b;
		   offset = c;
		   //System.out.println("Creating RowCheck " +  threadNum );
	   }
	   
	   public void run() {
		   for(int Num = 0; Num < 9; Num++){
			   for(int i = 0; i < 9; i++)
				   if(!hashset.add(board[Num][i]))
					   return;
			   hashset.clear();
			   nums[offset+Num] = 1;
		   }
		   //System.out.println("RowCheck  Thread " +  threadNum + " exiting.");
	   }

	   public void start () {
		   if (t == null) {
			   t = new Thread (this, Integer.toString(0));
			   t.start();
		   }
	   }
}

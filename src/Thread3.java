import thread3.ColCheck;
import thread3.RowCheck;
import thread3.SquareCheck;

public class Thread3 {
	public static boolean RUN(char[][] s){
		/******************
		 *  Global Record
		 ******************/	
		int[] a = new int[27];

		/**********************
		 *  Row Thread
		 **********************/
		//new Thread
		RowCheck threads_row = new RowCheck(a,s,0);
		//thread start
		threads_row.start();


		/**********************
		 *  Col Thread
		 **********************/
		//new Thread
		ColCheck threads_col = new ColCheck(a,s,9);
		//thread start
		threads_col.start();


		/************************
		 *  Square Thread
		 ************************/
		//new Thread
		SquareCheck threads_square = new SquareCheck(a,s,18);
		// thread start
		threads_square.start();


		/****************
		 *  Row Join
		 ****************/
		//thread join
		try {
			threads_row.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/****************
		 *  Col Join
		 ****************/
		//thread join
		try {
			threads_col.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/****************
		 *  Square Join
		 ****************/
		//thread join
		try {
			threads_square.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		boolean check = true;;
		for(int i : a)
			if(i!=1){
				check = false;
				break;
			}
		return check;
	}
}

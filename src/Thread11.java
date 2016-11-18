import thread3.ColCheck;
import thread3.RowCheck;
import thread27.SquareCheck;

public class Thread11 {
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
		 *  Square Thread (0-9)
		 ************************/
		//new Thread
		SquareCheck[] threads_square = new SquareCheck[9];
		for(int i = 0; i < threads_square.length; i++){
			threads_square[i] = new SquareCheck(i, a, s, 18);
		}
		// thread start
		for(int i = 0; i < threads_square.length; i++){
			threads_square[i].start();
		}


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
		for(int i = 0;i < threads_square.length; i++){
			try {
				threads_square[i].t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

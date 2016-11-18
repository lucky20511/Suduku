import thread27.RowCheck;
import thread27.ColCheck;
import thread27.SquareCheck;



public class Thread27 {
	
	
	
	public static boolean RUN(char[][] s){
	/******************
	 *  Global Record
	 ******************/	
	int[] a = new int[27];

	/**********************
	 *  Row Thread (0-9)
	 **********************/
	//new Thread
	RowCheck[] threads_row = new RowCheck[9];
	for(int i = 0; i < threads_row.length; i++){
		threads_row[i] = new RowCheck(i, a, s, 0);
	}
	// thread start
	for(int i = 0; i < threads_row.length; i++){
		threads_row[i].start();
	}


	/**********************
	 *  Col Thread (0-9)
	 **********************/
	//new Thread
	ColCheck[] threads_col = new ColCheck[9];
	for(int i = 0; i < threads_col.length; i++){
		threads_col[i] = new ColCheck(i, a, s, 9);
	}
	// thread start
	for(int i = 0; i < threads_col.length; i++){
		threads_col[i].start();
	}

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
	for(int i = 0;i < threads_row.length; i++){
		try {
			threads_row[i].t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/****************
	 *  Col Join
	 ****************/
	//thread join
	for(int i = 0;i < threads_col.length; i++){
		try {
			threads_col[i].t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

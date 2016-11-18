import java.util.HashMap;

public class Thread1 {
	
	private static boolean  rowCheck(char[][] b){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(b[i][j] != '.'){
                    if(!map.containsKey(b[i][j]))
                        map.put(b[i][j], 1);
                    else
                        return false;
                }
            }
            map.clear();
        }
        return true;
    }
    
    private static boolean  colCheck(char[][] b){
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(b[j][i] != '.'){
                    if(!map.containsKey(b[j][i]))
                        map.put(b[j][i], 1);
                    else
                        return false;
                }
            }
            map.clear();
        }
        return true;
    }
    
    private static boolean squareCheck(char[][] b){
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(b[j/3 + 3*(i/3)][j%3 + 3*(i%3)] != '.'){
                    if(!map.containsKey(b[j/3 + 3*(i/3)][j%3 + 3*(i%3)]))
                        map.put(b[j/3 + 3*(i/3)][j%3 + 3*(i%3)], 1);
                    else
                        return false;
                }
            }
            map.clear();
        }
        return true;
    }
	
    
	public static boolean RUN(char[][] s){
		//row
        if(!rowCheck(s)) return false;
 
        //col
        if(!colCheck(s)) return false;
        
        //square
        if(!squareCheck(s)) return false;
            
        return true;
		
	}
}

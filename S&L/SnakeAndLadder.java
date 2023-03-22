import java.util.*;
class SnakeAndLadder{
	
	String board[][];
	HashMap<Integer,Integer> snakes;
	HashMap<Integer,Integer> ladders;
	ArrayList<Integer> snakeTail=new ArrayList<>();
	ArrayList<Integer> ladderTop=new ArrayList<>();
	
	HashMap<String,Integer> players;
	
	SnakeAndLadder(){
		this.board=new String[10][10];
		this.snakes=new LinkedHashMap<>();
		snakes.put(40,3);
		snakes.put(43,18);
		snakes.put(27,5);
		snakes.put(54,31);
		snakes.put(89,53);
		snakes.put(66,45);
		snakes.put(76,58);
		snakes.put(99,41);
		
		snakeTail.add(3);
		snakeTail.add(18);
		snakeTail.add(5);
		snakeTail.add(31);snakeTail.add(53);
		snakeTail.add(45);
		snakeTail.add(58);
		snakeTail.add(41);
		
		this.ladders=new LinkedHashMap<>();
		ladders.put(25,4);
		ladders.put(46,13);
		ladders.put(49,33);
		ladders.put(69,50);
		ladders.put(63,42);
		ladders.put(81,62);
		ladders.put(92,74);
		
		ladderTop.add(4);
		ladderTop.add(13);
		ladderTop.add(33);ladderTop.add(50);ladderTop.add(42);ladderTop.add(62);ladderTop.add(74);
		
		int index=1;
		for(int i=9;i>=0;i--){
			for(int j=0;j<10;j++){
				if((i+1)%2!=0){
					board[i][j]=--index +"";
				}
				else{
					board[i][j]=index++ +"";
				}
			}
			index+=10;
		}
		this.players=new LinkedHashMap<>();
		
	}
	
	void addPlayers(String name){
		players.put(name,1);
	}
	
	void play(String name,int dice){
		int playerPos=0;
		if((players.get(name)+dice)<=100){
			
			players.replace(name,players.get(name)+dice);
			playerPos=players.get(name);
		}	
		if(snakes.containsKey(playerPos)){
			players.replace(name,snakes.get(playerPos));
		}
		if(ladders.containsKey(playerPos)){
			players.replace(name,ladders.get(playerPos));
		}
	}
	
	void show(){
		Set<String> set1=players.keySet();
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(players.containsValue(Integer.parseInt(board[i][j]))){
				for(String p:set1){
					if((players.get(p)+"").equals(board[i][j])){
						System.out.printf("%4s",p);
						break;
					}
				}
				}
				 else if(snakes.containsKey(Integer.parseInt(board[i][j]))){
					snakeTail.add(snakes.get(Integer.parseInt(board[i][j])));
					Set<Integer> set=snakes.keySet();
					int ind=1;
					for(Integer in:set){
						if(Integer.parseInt(board[i][j])==in){
							break;
						}
						ind++;
					}
					System.out.printf("%4s","s"+ind);
				}
				else if(snakeTail.contains(Integer.parseInt(board[i][j]))){
					System.out.printf("%4s","s"+(snakeTail.indexOf(Integer.parseInt(board[i][j]))+1));
				}
				else if(ladders.containsKey(Integer.parseInt(board[i][j]))){
					ladderTop.add(ladders.get(Integer.parseInt(board[i][j])));
					Set<Integer> set=ladders.keySet();
					int ind=1;
					for(Integer in:set){
						if(Integer.parseInt(board[i][j])==in){
							break;
						}
						ind++;
					}
					System.out.printf("%4s","l"+ind);
				}
				else if(ladders.containsKey(Integer.parseInt(board[i][j]))){
					System.out.printf("%4s","l"+(ladderTop.indexOf(Integer.parseInt(board[i][j]))+1));
				}
				
				else {
					System.out.printf("%4s",board[i][j]);
				}
			}
			System.out.println("\n");
		}
	}
}
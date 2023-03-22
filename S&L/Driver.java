import java.util.*;
class Driver{
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		SnakeAndLadder s=new SnakeAndLadder();
		
		System.out.println("Enter the number of players");
		int num=sc.nextInt();
		int temp=num;
		System.out.println("Enter player name");
		ArrayList<String> ar=new ArrayList<>();
		while(num>0){
			String name=sc.next();
			s.addPlayers(name);
			ar.add(name);
			num--;
		}
		s.show();
		boolean win=false;
		int dice=0;
		int player=1;
		while(!win){
			clear();
			System.out.println(ar.get(player-1)+"'s turn\n");
			dice=(int)(Math.random()*((6-1)+1));
			/*while(dice>6 || dice<1){
				System.out.println("Invalid dice number\nRe-enter");
				dice=sc.nextInt();
			}*/
			s.play(ar.get(player-1),dice);
			if(s.players.get(ar.get(player-1))==100){
				win=true;
				System.out.println(ar.get(player-1)+" won ");
			}
			player++;
			if(player>temp){
				player=1;
			}
			s.show();
			try{
			Thread.sleep(2000);
			}
			catch(Exception e){}
		}
	}
	static void clear(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception e){
			
		}
	}
}
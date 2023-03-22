import java.util.*;
import java.io.*;
class TicTacToe{
	static Scanner sc=new Scanner(System.in);
	static String[][] board=new String[3][3];

	static{
		int c=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j]=(++c)+"";
			}
		}
	}
	
	static boolean win(String player){
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
			return true;
		}
		if(board[0][0]==player && board[0][1]==player && board[0][2]==player){
			return true;
		}
		if(board[1][0]==player && board[1][1]==player && board[1][2]==player){
			return true;
		}
		if(board[2][0]==player && board[2][1]==player && board[2][2]==player){
			return true;
		}
		if(board[0][0]==player && board[1][0]==player && board[2][0]==player){
			return true;
		}
		if(board[0][1]==player && board[1][1]==player && board[2][1]==player){
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][2]==player){
			return true;
		}
		
		return false;
	}
	
	static void print(){
		System.out.print("\n\n");
		System.out.println("\t\t\t|---|---|---|");
		for(int i=0;i<3;i++){
			System.out.print("\t\t\t| ");
			for(int j=0;j<3;j++){
				System.out.print(board[i][j]+" | ");
			}
			if(i!=2){
			System.out.println("\n\t\t\t|-----------|");
			}
		}
		System.out.println("\n\t\t\t|---|---|---|\n\n");
	}
	static void play(){
		System.out.print("Enter X's Name : ");
		String player1=sc.next();
		System.out.print("Enter O's Name : ");
		String player2=sc.next();
		clear();
		print();
		int filled=0;
		String player="";
		boolean turn=true;
		while(true){
			clear();
			print();
			player=turn?"X":"O";
			System.out.print("Enter the slot number to place "+player+" : ");
			int slot=sc.nextInt();
			while(slot<=0 || slot>9){
				System.out.print("Invalid slot number ,Re enter : ");
				slot=sc.nextInt();
			}
			while(true){
			   int row,col;
			   if(slot<=3){
				   row=0;
				   col=(slot%3)-1;
				   if(col<0){
					   col=2;
				   }
			   }
			   else if(slot<=6){
			       row=1;
			       col=(slot%3)-1;
				   if(col<0){
					   col=2;
				   }
			   }
			   else{
				   row=2;
				   col=(slot%3)-1;
				   if(col<0){
					   col=2;
				   }
		       }
			   
			   if(!board[row][col].equals("X") && !board[row][col].equals("O")){
				   board[row][col]=player;
				   turn=turn?false:true;
				   filled++;
				   break;
			   }
			   System.out.print("Invalid move ,Re enter : ");
			   slot=sc.nextInt();
			}
			
			if(filled>=5){
				if(win(player)){
					clear();
					print();
					System.out.println((player=="X"?player1:player2)+" has won");
					return;
				}
			}
			
			if(filled==9){
				print();
				System.out.println("Game Over");
				return;
			}
			
		}
		
	}
	
	public static void main(String args[]){
		play();
	}
	
	static void clear(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception e){
			
		}
	}
}
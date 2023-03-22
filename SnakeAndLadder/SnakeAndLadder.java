import java.util.*;
import java.io.*;
class SnakeAndLadder{
	public static int snake(int ar[][],int pos){
		for(int i=0;i<ar.length;i++){
			if(ar[i][0]==pos){
				return ar[i][1];
			}
		}
		return 0;
	}
	public static int ladder(int ar[][],int pos){
		for(int i=0;i<ar.length;i++){
			if(ar[i][0]==pos){
				return ar[i][1];
			}
		}
		return 0;
	}
	public void game()throws IOException{
		
		Scanner sc=new Scanner(System.in);
		FileOutputStream inputFile=new FileOutputStream("result.txt",true);
		//int[][] board=new int[10][10];
		//String board1[][]=new String[10][10];
		int temp=111;
		int row=1;
		for(int i=0;i<10;i++){
			temp-=10;
			for(int j=0;j<10;j++){
				board1[i][j]=" _ ";
				if((i+1)%2!=0){
					
					board[i][j]=--temp;
				}
				else{
					
					board[i][j]=temp++;
				}
			}
		}
		//FileOutputStream outputFile=new FileOutputStream("output.txt",true);
		
		System.out.println("Enter no. of snakes");
		inputFile.write("Enter no. of snakes\n".getBytes());
		int noOfSnake=sc.nextInt();
		inputFile.write((noOfSnake+"\n").getBytes());
		int[][] snakes=new int[noOfSnake][2];
		System.out.println("Enter snake positions");
		inputFile.write("Enter snake positions\n".getBytes());
		for(int i=0;i<noOfSnake;i++){
			int head=sc.nextInt();
			int tail=sc.nextInt();
			inputFile.write((head+" "+tail+"\n").getBytes());
			snakes[i][0]=head;
			snakes[i][1]=tail;
		}
		System.out.println("Enter no. of ladder");
		inputFile.write("Enter no. of ladder\n".getBytes());
		int noOfLadder=sc.nextInt();
		inputFile.write((noOfLadder+"\n").getBytes());
		int[][] ladders=new int[noOfLadder][2];
		System.out.println("Enter ladder positions");
		inputFile.write("Enter no. of ladder\n".getBytes());
		for(int i=0;i<noOfLadder;i++){
			int bottom=sc.nextInt();
			int top=sc.nextInt();
			inputFile.write((bottom+" "+top+"\n").getBytes());
			ladders[i][0]=bottom;
			ladders[i][1]=top;
		}
		System.out.println("Enter no of players");
		inputFile.write("Enter no of players\n".getBytes());
		int noOfPlayer=sc.nextInt();
		inputFile.write((noOfPlayer+"\n").getBytes());
		String[] players=new String[noOfPlayer];
		for(int i=0;i<noOfPlayer;i++){
			String name=sc.next();
			inputFile.write((name+"\n").getBytes());
			players[i]=name;
			
		}
		
		int[] pos=new int[noOfPlayer];
		boolean win=false;
		for(int i=0;i<noOfPlayer;i++){
			pos[i]=0;
		}
		int[][] board=new int[10][10];
		//String board1[][]=new String[10][10];
		int temp=111;
		int row=1;
		/*for(int i=0;i<10;i++){
			temp-=10;
			for(int j=0;j<10;j++){
				board1[i][j]=" _ ";
				if((i+1)%2!=0){
					
					board[i][j]=--temp;
				}
				else{
					
					board[i][j]=temp++;
				}
			}
		}*/
		
		System.out.println("1.Random\n2.User");
		inputFile.write("1.Random\n2.User\n".getBytes());
		int choice=sc.nextInt();
		inputFile.write(("Selected Choice : "+choice+"\n").getBytes());
		int dice=0;
		while(win==false){
			for(int i=0;i<noOfPlayer;i++){
				if(choice==1){
					dice=(int)(Math.random()*((6-1)+1));
				}
				else if(choice==2){
					System.out.println(players[i]+"'s turn\nEnter the number");
					inputFile.write((players[i]+"'s turn\nEnter the number\n").getBytes());
					dice=sc.nextInt();
					inputFile.write((dice+"\n").getBytes());
					int chance=0;
					while((dice<0 || dice>6) && chance<2){
						inputFile.write("Number out of range\nRange 0 t0 6\n".getBytes());
							System.out.println("Number out of range\nRange 0 t0 6");
							dice=sc.nextInt();
							inputFile.write((dice+"\n").getBytes());
							chance++;
						
					}
					if(chance>=3){
						dice=0;
					}
				}
				int initPos=pos[i];
				int up=ladder(ladders,pos[i]+dice);
				int down=snake(snakes,pos[i]+dice);
				if(up==0 && down==0){
					pos[i]=pos[i]+dice;
				}
				else if(up!=0){
					pos[i]=up;
				}
				else if(down !=0){
					pos[i]=down;
				}
				if(pos[i]<0){
					pos[i]=0;
				}
				if(pos[i]>100){
					pos[i]=initPos;
				}
				inputFile.write((players[i]+" rolled a "+dice+" and moved from "+ initPos+" to " +pos[i]+"\n").getBytes());
				System.out.println((players[i]+" rolled a "+dice+" and moved from "+ initPos+" to " +pos[i]));
				if(pos[i]>=100){
					inputFile.write((players[i]+" has won the game"+"\n").getBytes());
					System.out.println(players[i]+" has won the game");
					win=true;
					break;
				}
			}
		}
		inputFile.close();
		
		
	}
}


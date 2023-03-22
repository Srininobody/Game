import java.util.*;
public class Game2048{
	static Scanner sc=new Scanner(System.in);
	static int[][] board=new int[4][4];
	static byte[] randomNums=new byte[2];
	static boolean moved=true;
	static byte isWin=0;
	static{
		for(int i=0;i<4;i++){
			Arrays.fill(board[i],0);
		}
		
		randomNums[0]=2;
		randomNums[1]=4;
		
		board[1][2]=2;
		board[2][0]=2;
	}
	
	static int random(int max,int min){
	    return min+(int)(Math.random()*((max-min)+1));
	}
	
	static void move(char move){
		switch(move){
			case 'l':
			    for(int i=0;i<4;i++){
					int temp=0;
					boolean isMerged=false;
					for(int j=1;j<4;j++){
						
						if(board[i][j]==0){
							continue;
						}
						else if(board[i][j]!=0 && board[i][temp]==0){
							temp=j;
						}
						else if(board[i][j]==board[i][temp] && !isMerged){
							board[i][temp]+=board[i][j];
							if(board[i][temp]==2048){
								isWin=1;
							}
							board[i][j]=0;
							temp=j;
							isMerged=true;
							moved=true;
						}
						else if(board[i][j]!=board[i][temp]){
							temp=j;
						}
						else if(isMerged){
							temp=j;
							isMerged=false;
						}
					}
					int zeroPointer=0;
					int left=0;
					while(left<4){
						if(board[i][left]!=0){
							int temp1=board[i][zeroPointer];
							board[i][zeroPointer]=board[i][left];
							board[i][left]=temp1;
							zeroPointer++;
							moved=true;
						}
						left++;
					}
				}
				break;
			case 'r':
			    for(int i=0;i<4;i++){
					int temp=3;
					boolean isMerged=false;
					for(int j=2;j>=0;j--){
						
						if(board[i][j]==0){
							continue;
						}
						else if(board[i][j]!=0 && board[i][temp]==0){
							temp=j;
						}
						else if(board[i][j]==board[i][temp] && !isMerged){
							board[i][temp]+=board[i][j];
							board[i][j]=0;
							if(board[i][temp]==2048){
								isWin=1;
							}
							temp=j;
							isMerged=true;
							moved=true;
						}
						else if(board[i][j]!=board[i][temp]){
							temp=j;
						}
						else if(isMerged){
							temp=j;
							isMerged=false;
						}
					}
					int zeroPointer=3;
					int right=3;
					while(right>=0){
						if(board[i][right]!=0){
							int temp1=board[i][zeroPointer];
							board[i][zeroPointer]=board[i][right];
							board[i][right]=temp1;
							moved=true;
							zeroPointer--;
						}
						right--;
					}
				}
			    break;
			case 'u':
			 for(int i=0;i<4;i++){
					int temp=0;
					boolean isMerged=false;
					for(int j=1;j<4;j++){
						
						if(board[j][i]==0){
							continue;
						}
						else if(board[j][i]!=0 && board[temp][i]==0){
							temp=j;
						}
						else if(board[j][i]==board[temp][i] && !isMerged){
							board[temp][i]+=board[j][i];
							board[j][i]=0;
							if(board[temp][i]==2048){
								isWin=1;
							}
							temp=j;
							isMerged=true;
							moved=true;
						}
						else if(board[j][i]!=board[temp][i]){
							temp=j;
						}
						else if(isMerged){
							temp=j;
							isMerged=false;
						}
					}
					int zeroPointer=0;
					int up=0;
					while(up<4){
						if(board[up][i]!=0){
							int temp1=board[zeroPointer][i];
							board[zeroPointer][i]=board[up][i];
							board[up][i]=temp1;
							moved=true;
							zeroPointer++;
						}
						up++;
					}
				}
			    break;
			case 'd':
			    for(int i=0;i<4;i++){
					int temp=3;
					boolean isMerged=false;
					for(int j=2;j>=0;j--){
						
						if(board[j][i]==0){
							continue;
						}
						else if(board[j][i]!=0 && board[temp][i]==0){
							temp=j;
						}
						else if(board[j][i]==board[temp][i] && !isMerged){
							board[temp][i]+=board[j][i];
							board[j][i]=0;
							if(board[temp][i]==2048){
								isWin=1;
							}
							temp=j;
							isMerged=true;
							moved=true;
						}
						else if(board[j][i]!=board[temp][i]){
							temp=j;
						}
						else if(isMerged){
							temp=j;
							isMerged=false;
						}
					}
					int zeroPointer=3;
					int down=3;
					while(down>=0){
						if(board[down][i]!=0){
							int temp1=board[zeroPointer][i];
							board[zeroPointer][i]=board[down][i];
							board[down][i]=temp1;
							moved=true;
							zeroPointer--;
						}
						down--;
					}
				}
			    break;
		}
	}
	
	static boolean isGameOver(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]==0){
					return true;
				}
				if(i-1>=0){
					if(board[i-1][j]==board[i][j])
						return true;	
				}
				if(i+1<4){
					if(board[i+1][j]==board[i][j])
						return true;
				}
				if(j-1>=0){
					if(board[i][j-1]==board[i][j])
						return true;
				}
				if(j+1<4){
					if(board[i][j+1]==board[i][j])
						return true;
				}
			}
		}
		
		return false;
	}
	
	static void print(){
		System.out.print("\n\n");
	    for(int i=0;i<4;i++){
			System.out.print("\t\t\t");
			for(int j=0;j<4;j++){
				if(board[i][j]==0){
					System.out.printf("%4s"," -");
				}
				else{
					System.out.printf("%4d",board[i][j]);
				}
			}
			System.out.println("\n");
		}
		
		System.out.println("\n");
	}
	public static void main(String args[]){
		
		while(true){
			//clear();
			print();
			moved=false;
			System.out.print("\t\t\tEnter your move : ");
			char move=sc.next().charAt(0);
			move(move);
			int row=random(3,0);
			int col=random(3,0);
			if(moved){
			    while(board[row][col]!=0){
				    row=random(3,0);
				    col=random(3,0);
		    	}
		    	int newNum=randomNums[random(1,0)];
		    	board[row][col]=newNum;
			}
			
			if(isWin==1){
				System.out.println("\n\t\t\tYou Won...");
				return;
			}
			
			if(!isGameOver()){
				System.out.println("\n\t\t\tGame Over...");
				return;
			}
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
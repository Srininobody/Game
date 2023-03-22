import java.util.*;
class Driver{
	static void clear(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception e){
			
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		TicTacToe t=new TicTacToe();
		clear();
		System.out.print("\n\t\t\tX : ");
		String player1=sc.next();
		System.out.print("\n\t\t\tO : ");
		String player2=sc.next();
		sc.nextLine();
		String players[]={player1,player2};
		boolean b=true;
		int p=1;
		while(b){
			clear();
			System.out.println("\n");
			t.print();
			System.out.println("\n\t\t\t"+players[p-1]+"'s Turn....");
			System.out.print("\n\t\t\tEnter row and column : ");
			String input=sc.nextLine();
			if(input.equals("exit")){
				return;
			}
			String input1[]=input.split(" ");
			int row=Integer.parseInt(input1[0]);
			int col=Integer.parseInt(input1[1]);
			while(t.cells[row-1][col-1]!=' ' || (row<1 && row>3) || (col<1 || col>3)){
				System.out.println("\t\t\tInvalid Input");
				System.out.print("\n\t\t\tRe-enter row and column : ");
		        input=sc.nextLine();
			    if(input.equals("exit")){
				    return;
			    }
			    input1=input.split(" ");
			    row=Integer.parseInt(input1[0]);
			    col=Integer.parseInt(input1[1]);
			
				clear();
				System.out.println("\n");
				t.print();
				System.out.println("\t\t\t"+players[p-1]+"'s Turn....");
			}
		
		    if(p==1){
				t.cells[row-1][col-1]='X';
				t.filledCells++;
				if(t.win('X')){
					clear();
			        System.out.println("\n");
			        t.print();
					System.out.println("\n\t\t\t"+players[p-1]+" has won...");
					return;
				}
			}
			else{
				t.cells[row-1][col-1]='O';
				t.filledCells++;
				if(t.win('O')){
					clear();
			        System.out.println("\n");
			        t.print();
					System.out.println("\n\t\t\t"+players[p-2]+" has won...");
					return;
				}
			}
			if(t.filledCells==9){
				System.out.println("\t\t\tGame Over ....");
				return;
			}
			if(p>=2){
				p=1;
			}
			else{
				p++;
			}
		}
	}
}
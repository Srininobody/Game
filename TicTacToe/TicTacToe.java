class TicTacToe{
	char cells[][];
	int filledCells;
	TicTacToe(){
		cells=new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				cells[i][j]=' ';
			}
		}
		filledCells=0;
	}
	
	boolean win(char player){
		
		if(cells[0][0]==player && cells[1][1]==player && cells[2][2]==player){
			return true;
		}
		else if(cells[1][0]==player && cells[1][1]==player && cells[1][2]==player){
			return true;
		}
		else if(cells[0][1]==player && cells[1][1]==player && cells[2][1]==player){
			return true;
		}
		else if((cells[0][0]==player && cells[0][1]==player && cells[0][2]==player) || (cells[2][0]==player && cells[2][1]==player && cells[2][2]==player)){
			return true;
		}
		else if((cells[0][0]==player && cells[1][0]==player && cells[2][0]==player) || (cells[0][2]==player && cells[1][2]==player && cells[2][2]==player)){
			return true;
		}
		
		return false;
	}
	
	void print(){
		for(int i=0;i<3;i++){
			//System.out.print("\t\t\t");
			System.out.print("\t\t\t+---+---+---+");
		     System.out.print("\n\t\t\t");
			for(int j=0;j<3;j++){
				
				if(cells[i][j]!=' '){
				    System.out.print("| "+cells[i][j]+" ");
				}
				else{
					System.out.printf("|   ");
				}
				//System.out.print("x");
			}
			System.out.print("|\n");
		}
		System.out.println("\t\t\t+---+---+---+");
	}
}
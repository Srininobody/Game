class BurstBaloon{

    char[][] matrix;
    boolean filled;
    int length;
    int presentRow;
    BurstBaloon(int length){
        this.matrix=new char[length][length];
        this.length=length;
        this.filled=false;
        this.presentRow=length-1;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                matrix[i][j]='-';
            }
        }
    }

    void game(int column,char colour){
        int row=length-1;
        while(row>=0){
            if(matrix[row][column-1]=='-'){
                matrix[row][column-1]=colour;
                if(flag(column-1)){
                    int r=0;
                    while(row<length){
                        matrix[row][column-1]='-';
                        row++;
                    }
                    print();
                    filled=true;
                    return;
                }
                print();
                return;
            }
            else{
                int col=0;
                while(col<length){
                    if(matrix[row][col]=='-'){
                        matrix[row][col]=colour;
                        print();
                        return;
                    }
                    if(flag(col)){
                        int r=0;
                        while(row<length){
                            matrix[row][col]='-';
                            row++;
                        }
                        return;
                    }
                    col++;
                }
            }

            row--;
        }
    }

    boolean flag(int col){
        int row=length-1;
        while(row>0){
            if(matrix[row][col]!=matrix[row-1][col]){
                return false;
            }
            row--;
        }
        return true;
    }
    boolean left(int row,char colour){

        int column=0;
        while(row>=0){
            column=0;
            while(column<length){
                if(matrix[row][column]=='-'){
                    matrix[row][column]=colour;
                    print();
                    return true;
                }
                column++;
            }
            row--;
        }
        return false;
    }

    void checkRow(){
        int count=1;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(matrix[i][j]!='-'){
                    count++;
                }
                else{
                    break;
                }
            }

        }

    }
    boolean check(int row){
        int col=0;
        while(col<length){
            if(matrix[row][col]=='-'){
                return false;
            }
            col++;
        }
        return true;
    }
    int checkColumn(){
        boolean isSame;
        for(int i=0;i<length;i++){
            isSame=true;
            for(int j=length-2;j>=0;j--){
                if(matrix[j][i]!=matrix[j+1][i] && matrix[j+1][i]!='-'){
                    isSame=false;
                    break;
                }
            }
            if(isSame){
                return i;
            }
        }
        return -1;
    }

    void print(){
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
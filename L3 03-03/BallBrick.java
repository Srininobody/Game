class BallBrick{
    String display[][];
    int ballCount;
    int ballPos;
    int totalBricks;
    boolean base[];
    boolean right;

    BallBrick(int m,int n){
        this.display=new String[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || j==n-1){
                    display[i][j]="W";
                }
                else if(i==m-1 && j!=n/2){
                    display[i][j]="G";
                }
                else if(i==m-1 && j==n/2){
                    display[i][j]="o";
                }
                else{
                    display[i][j]=" ";
                }
            }
        }
        base=new boolean[m-2];
        for(int i=0;i<m-2;i++){
            base[i]=false;
        }
        base[base.length/2]=true;
        right=true;
        this.ballPos=n/2;
    }

    void setBallCount(int count){
        this.ballCount=count;
    }
    void setTotalBrick(int total){
        this.totalBricks=total;
    }

    void returnToInitPos(){
        for(int i=1;i<display[display.length-1].length-2;i++){
            if(i==display[display.length-1].length/2){
                display[display.length-1][i]="o";
            }
            else if(!base[i-1]){
                display[display.length-1][i]="G";
            }
            else{
                display[display.length-1][i]="_";
            }
        }
        ballPos=display.length/2;
    }

    void changeBallPos(int pos){
        for(int i=1;i<display[display.length-1].length-2;i++){
            if(i==pos){
                display[display.length-1][i]="o";
            }
            else if(base[i-1]==true){
                display[display.length-1][i]="_";
            }
            else{
                display[display.length-1][i]="G";
            }

        }
    }

    void traverse(int row,int i){
        if(display[row][i].equals("DE")){
            DE(row);
            changeBallPos(i);
            ballPos=i;
            if(!base[i-1]){
                ballCount--;
            }

            return;
        }
        if(display[row][i].equals("B")){
            if(right){
                rightBase(i);
            }
            else{
                leftBase(i);
            }
            return;
        }
        if(display[row][i].equals("DS")){

            DS(row,i);
            changeBallPos(i);
            ballPos=i;
            ballCount--;
            return;
        }
        if(display[row][i].equals("N")){
            poles(row-1,i);
            display[row][i]=" ";
            ballPos=i;
            changeBallPos(row);
            if(!base[i-1]){
                ballCount--;
            }
            totalBricks--;
            return;
        }
        if(display[row][i].equals("S")){
            poles(row+1,i);
            display[row][i]=" ";
            ballPos=i;
            changeBallPos(row);
            if(!base[i-1]){
                ballCount--;
            }
            totalBricks--;
            return;
        }
        if(display[row][i].equals("E")){
            poles(row,i+1);
            display[row][i]=" ";
            ballPos=i;
            changeBallPos(row);
            if(!base[i-1]){
                ballCount--;
            }
            totalBricks--;
            return;
        }
        if(display[row][i].equals("W")){
            poles(row,i-1);
            display[row][i]=" ";
            ballPos=i;
            changeBallPos(row);
            if(!base[i-1]){
                ballCount--;
            }
            totalBricks--;
            return;
        }
    }
    void init(String dir){
        if(dir.equalsIgnoreCase("st")){
            for(int i=display.length-1;i>=0;i--){
                if(i==0){
                    break;
                }
                if(Parser.parse(display[i][ballPos])){
                    display[i][ballPos]=(Integer.parseInt(display[i][ballPos])-1)+"";
                    totalBricks--;
                    if(display[i][ballPos].equals("0")){
                        display[i][ballPos]=" ";
                    }
                    break;
                }
                else{
                    traverse(i,ballPos);
                }


            }

        }

        else if(dir.equalsIgnoreCase("ld")){
            int row=display.length-1;
            try{
                for(int i=ballPos;i>=0;i--){
                    if(i==0){
                        RD(row);
                        break;
                    }
                    if(Parser.parse(display[row][i])){
                        display[row][i]=(Integer.parseInt(display[row][i])-1)+"";
                        totalBricks--;
                        if(display[row][i].equals("0")){
                            display[row][i]=" ";
                        }
                        if(!base[i-1]){
                            ballCount--;
                        }
                        ballPos=i;
                        changeBallPos(i);
                        break;
                    }

                    else{
                        traverse(row,i);
                    }

                    row--;
                }
            }
            catch(Exception e){

            }
        }
        else if(dir.equalsIgnoreCase("rd")){
            int row=display.length-1;
            for(int i=ballPos;i<display.length-1;i++){
                if(i==display[row].length-1 || row<=1){
                    LD(row);
                    break;
                }
                if(Parser.parse(display[row][i])){
                    display[row][i]=(Integer.parseInt(display[row][i])-1)+"";
                    totalBricks--;
                    if(display[row][i].equals("0")){
                        display[row][i]=" ";
                    }
                    ballPos=i;
                    changeBallPos(row);
                    if(!base[i-1]){
                        ballCount--;
                    }
                    break;
                }
                else{
                    traverse(row,i);
                }


                row--;
            }
        }
    }

    void down(int col){
        this.ballPos=col;
    }
    void RD(int row){
        for(int i=0;i<display.length;i++){
            if(Parser.parse(display[row][i])){
                display[row][i]=(Integer.parseInt(display[row][i])-1)+"";
                totalBricks--;
                if(display[row][i].equals("0")){
                    display[row][i]=" ";
                }

                if(!base[i-1] && i!=ballPos){
                    ballCount--;
                }
                ballPos=i;
                changeBallPos(i);
                break;
            }
            else{
                traverse(row,i);
            }
            if(i==display[i].length-1){
                ballCount--;
                returnToInitPos();
                break;
            }
        }

    }
    void LD(int row){

        for(int i=display.length-1;i>=0;i--){
            if(Parser.parse(display[row][i])){
                display[row][i]=(Integer.parseInt(display[row][i])-1)+"";
                totalBricks--;
                if(display[row][i].equals("0")){
                    display[row][i]=" ";
                }
                if(!base[i-1] && i!=ballPos){
                    ballCount--;
                }
                ballPos=i;
                changeBallPos(i);
                break;
            }
            else{
                traverse(row,i);
            }

            if(i==0){
                ballCount--;
                returnToInitPos();
                break;
            }
        }

    }
    void DS(int row,int col){

        int r=2;
        for(int i=row-1;i<=row+r;i++){
            int c=2;
            for(int j=col-1;j<=j+c;j++){
                if(!display[i][j].equals("W") && !display[i][j].equals("G") && !display[i][j].equals("o")){
                    switch(display[i][j]){
                        case "DE":
                            totalBricks--;
                            display[i][j]=" ";
                            DE(i);
                            break;
                        case "DS":
                            display[i][j]=" ";

                            totalBricks--;
                            DS(i,j);
                            break;
                        case " ":
                            break;
                        case "B":
                            if(right){
                                rightBase(j);
                            }
                            else{
                                leftBase(j);
                            }
                            break;
                        default:
                            totalBricks-=(Integer.parseInt(display[i][j]));
                    }
                    display[i][j]=" ";
                    System.out.println(totalBricks);
                }
                c--;
            }
            r--;
        }

    }

    void DE(int row){
        for(int i=1;i<=display.length-2;i++){
            if(Parser.parse(display[row][i])){
                totalBricks-=Integer.parseInt(display[row][i]);
                display[row][i]=" ";
                System.out.println("total bricks "+totalBricks);
            }
            else if(display[row][i].equals("DE")){
                totalBricks--;
                display[row][i]=" ";
                DE(row);
            }
            else if(display[row][i].equals("DS")){
                DS(row,i);
            }
            else if(display[row][i].equals("B")){
                if(right){
                    rightBase(i);
                    totalBricks--;
                }
                else{
                    leftBase(i);
                    totalBricks--;
                }
            }
        }
    }
    void printBoard(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(display[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("ball count "+ballCount);
    }

    void rightBase(int pos){
        for(int i=pos;i<base.length-1;i++){
            if(base[i]==false){
                base[i]=true;
                display[display.length-1][i+1]="_";
                break;
            }
        }
        right=false;
    }
    void leftBase(int pos){
        for(int i=pos;i>=1;i--){
            if(base[i]==false){
                base[i]=true;
                break;
            }
        }
        right=true;
    }
    void poles(int row,int col){

        switch(display[row][col]) {
            case "N":
                totalBricks--;
                display[row][col] = " ";
                poles(row - 1, col);
                break;
            case "S":
                totalBricks--;
                display[row][col] = " ";
                poles(row + 1, col);
                break;
            case "W":
                totalBricks--;
                display[row][col] = " ";
                poles(row, col - 1);
                break;
            case "E":
                totalBricks--;
                display[row][col] = " ";
                poles(row, col + 1);
                break;

            case "DS":
                DS(row, col);
                break;
            case "DE":
                DE(row);
                break;
            case "B":
                if (right) {
                    rightBase(ballPos);
                } else {
                    leftBase(ballPos);
                }
                totalBricks--;
                break;
            default:
                if (Parser.parse(display[row][col])) {
                    display[row][col] = (Integer.parseInt(display[row][col]) - 1) + "";
                    if(display[row][col].equals("0")){
                        display[row][col]=" ";
                    }
                    totalBricks--;
                }
        }
    }
}
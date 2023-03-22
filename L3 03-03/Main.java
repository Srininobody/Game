import java.util.*;
class Main{
    public static void main(String args[]){


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of NxN matrix");
        int size=sc.nextInt();
        BallBrick ballBrick=new BallBrick(size,size);
        String yesOrNo="y";
        int count=0;
        while(yesOrNo.equalsIgnoreCase("y")){
            System.out.println("Enter the brick's position and brick type:");
            int row=sc.nextInt();
            int col=sc.nextInt();
            String brick=sc.next();
            ballBrick.display[row][col]=brick+"";
            System.out.println("Do you want to continue(Y or N)?");
            yesOrNo=sc.next();
            if(brick.equals("DS") || brick.equals("DE") || brick.equals("B") || brick.equals("N") || brick.equals("S") || brick.equals("E") ||brick.equals("W")){
                count+=1;
            }
            else{
                count+=Integer.parseInt(brick);
            }
            ballBrick.printBoard();
        }
        ballBrick.setTotalBrick(count);
        System.out.println("Enter  ball count");
        int ballCount=sc.nextInt();
        ballBrick.setBallCount(ballCount);
        ballBrick.printBoard();

        System.out.println("Enter the direction");
        String dir=sc.next();
        while(ballBrick.ballCount>0){
            ballBrick.init(dir);
            ballBrick.printBoard();
            if(ballBrick.totalBricks<=0){
                System.out.println("you win");
                break;
            }
            if(ballBrick.ballCount==0){
                System.out.println("you loss");
                break;
            }

            System.out.println(ballBrick.totalBricks);
            System.out.println("Enter the direction");
            dir=sc.next();
        }

    }
}
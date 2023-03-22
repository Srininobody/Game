import java.util.*;
class Driver{
    static Scanner sc=new Scanner(System.in);
    BurstBaloon burstBaloon;
    void play(){
        System.out.println("Enter the size of matrix");
        int size=sc.nextInt();
        burstBaloon=new BurstBaloon(size);

        char c=' ';
        while(c!='N'){
            System.out.print("Enter the column number : ");
            int column=sc.nextInt();
            System.out.print("Enter the baloon colour : ");
            char colour=sc.next().charAt(0);
            burstBaloon.game(column,colour);
			/*if(burstBaloon.checkRow() || burstBaloon.checkColumn()){
				System.out.println("column is completely filled");
				break;
			}*/
            if(burstBaloon.filled){
                System.out.println("matrix is filled");
				break;
            }
            System.out.println("Do you wish to continue Y/N : ");
            c=sc.next().charAt(0);

        }
        System.out.println("program terminted");
    }
    public static void main(String args[]){
        Driver driver=new Driver();
        driver.play();
    }
}
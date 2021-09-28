package Task2;

import java.util.Scanner;

public class Task2 {
    public static void checkArmStrong(int input){
        int originalInput = input;
        int result = 0,digits=0;
        while(originalInput>0)
        {
            originalInput/=10;
            digits++;
        }

        originalInput=input;

        while (originalInput != 0)
        {
            int remainder =originalInput%10;
            result += Math.pow(remainder,digits);
            originalInput/= 10;
        }

        if(result == input) {
            System.out.println(input+ " is an Armstrong number.");
        }
        else {
            throw new BadRequestException(input+" is not ArmStrong number.");
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner scanner=new Scanner(System.in);
        int input= scanner.nextInt();
        checkArmStrong(input);
    }
}

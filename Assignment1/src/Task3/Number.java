package Task3;

public class Number {
    private int num = 19;

    public static void main (String[] args) {
        Number number = new Number();
        System.out.println("isZero : "+number.isZero());
        System.out.println("isPositive : "+number.isPositive());
        System.out.println("isNegative : "+number.isNegative());
        System.out.println("isOdd : "+number.isOdd());
        System.out.println("isEven : "+number.isEven());
        System.out.println("isPrime: "+number.isPrime());
        System.out.println("isAmstrong: "+ number.isAmstrong());
        System.out.println("Factorial of "+ number.num + " is "+ number.getFactorial());
        System.out.println("The square of "+ number.num + " is "+ number.getSqr());
        System.out.println("The sum of digits of "+ number.num + " is "+ number.sumDigits());
        System.out.println("The reverse of "+ number.num + " is "+ number.getReverse());
        System.out.println("THe square root of "+ number.num + " is " + number.getSqrt());

    }

    public Boolean isZero() {
        if (num == 0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean isPositive() {
        if (num > 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isNegative() {
        if (num < 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isOdd(){
        if((num%2)!=0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isEven(){
        if((num%2)==0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isPrime(){
        int count = 0;
        for (int i = 1; i <= num; i++){
            int rem = num % i;
            if (rem==0) {
                count = count + 1;
            }
        }
        if (count == 2){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isAmstrong(){
        int amstrong = 0;
        int reminder;
        int number = num;

        while (number != 0){
            reminder = number % 10;
            amstrong = amstrong + reminder*reminder*reminder;
            number = number/10;
        }
        if (amstrong == num){
            return  true;
        }else{
            return false;
        }
    }

    public int getFactorial(){
        int factorial = 1;
        for (int i=num; i>=1; i--){
            factorial *= i;
        }
        return factorial;
    }

    public int getSqr() {
        return (num*num);
    }

    public int sumDigits(){
        int sum = 0;
        int rem;
        int number = num;
        while(number!=0){
            rem = number%10;
            sum = sum + rem;
            number = number/10;
        }
        return sum;
    }

    public int getReverse(){
        int rev = 0;
        int number = num;
        while(number != 0) {
            int rem = number % 10;
            rev = rev * 10 + rem;
            number = number / 10;
        }
        return rev;
    }

    public double getSqrt(){
        return Math.sqrt(num);
    }
}

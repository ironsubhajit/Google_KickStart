import java.util.Scanner;

public class Solution {
    public static String check(Scanner sc){
        long[] ip = new long[4];
        for (int i = 0 ; i < 4; i++){
            ip[i] = sc.nextInt();
        }
        long n = ip[0];
        long Dfood = ip[1];
        long Cfood = ip[2];
        long Mfood = ip[3];

        String ani = sc.next();

        long[] animals = {0, 0};

        for (int i = 0; i < n; i++){
            char ch = ani.charAt(i);
            if(ch == 'D'){
                animals[0] += 1;
            }else if(ch == 'C') {
                animals[1] += 1;
            }
        }


        for (int i = 0; i < n; i++){
            char ch = ani.charAt(i);
            if(ch == 'D' && Dfood > 0) {
                Dfood = (Dfood - 1); // del 1 fed Dog
                Cfood += Mfood; // Add M to cat
                animals[0] -= 1;
            }else if(ch == 'C' && Cfood > 0){
                Cfood = (Cfood - 1); // del 1 fed cat
                animals[1] -= 1;
            }else{
                break;
            }
        }
        if(animals[0] <= 0){
            return "YES";
        }else{
            return "NO";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(long test = 0; test <= tc; test++){
            String op = check(sc);
            System.out.println("Case #"+test+": "+op);
        }
    }
}

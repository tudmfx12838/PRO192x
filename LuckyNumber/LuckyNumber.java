import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        play(input);

        //(Math.random())*((max-min)+1)) + min;

        /*
        //report(report, totalOfGames, guessOfAvg, bestGame);
        //report("Dang Minh Tu","1-0~10-3-3*2-1~5-2-4*3-20~40-5-32*", 3, 10, 2); 
        */
    }
    public static void play(Scanner input){
        int numOfMin = 0;
        int numOfMax = 0;
        double randomDouble = 0.0;
        int guessNum = 0, count = 0;
        boolean isContinues = true;
        int totalOfGames = 0, totalOfGuess = 0, guessOfAvg = 0, bestGame = Integer.MAX_VALUE;
        String report = "";

        System.out.print("Nhap ten cua ban: ");
        String name = input.nextLine();
        System.out.println("Chao mung " + name + " den tro choi doan so may man");
        
        do{
            totalOfGames++;
            count = 0;

            System.out.print("Nhap do kho(muon doan tu 0 den 10 thi nhap '0 10'): ");
            numOfMin = input.nextInt();
            numOfMax = input.nextInt();
            randomDouble = (Math.random())*((numOfMax-numOfMin)+1) + numOfMin;
            int luckyNumber = (int)randomDouble;
            System.out.println("luckyNumber is " + luckyNumber);
    
            System.out.println("Toi dang nghi mot so trong khoang tu " + numOfMin + " den " + numOfMax + "...");

            do{
                System.out.print("Ban doan? ");
                guessNum = input.nextInt();
                count++;
                if (guessNum > luckyNumber){
                    System.out.println("So may man lon hon so du doan cua ban");
                } else if (guessNum < luckyNumber) {
                    System.out.println("So may man nho hon so du doan cua ban");
                } else {
                    System.out.println("Chuc mung ban da doan dung con so sau " + count + " lan du doan!");
                }
            }while(guessNum != luckyNumber);

            totalOfGuess = count;
            guessOfAvg += count;
            bestGame = bestGame > count ? count : bestGame;
            report += totalOfGames + "-" + numOfMin + "~" + numOfMax + "-" + totalOfGuess + "-" + guessNum +"*";

            System.out.print("Ban co muon tiep tuc choi? ");
            String answer = input.next().toUpperCase();

            if(answer.equals("YES") || answer.equals("Y") ){
                isContinues = true;
            }else{
                report(name ,report, totalOfGames, guessOfAvg, bestGame);
                isContinues = false;
            }

        }while(isContinues == true);

        
    }
    public static void report(String player, String rp, int tog, int goa, int bg) {
        // System.out.println("player : " + player);
        // System.out.println("report : " + rp);
        // System.out.println("totalOfGame  : " + tog);
        // System.out.println("guessOfAvg : " + goa);
        // System.out.println("bestGame : " + bg);

        String rp_s[] = new String[tog];
        for(int i = 0; i < tog; i++){
            rp_s[i] = "";
        }

        int index = 0;
        for(int i = 0; i <= rp.length() - 1; i++){
            if(rp.charAt(i) != '*'){
                rp_s[index] += rp.charAt(i);
            }else{
                index++;
            }
        }
        
        System.out.println("******************************Ket Qua******************************");
        System.out.println("Nguoi choi :             " + player);
        System.out.println("Tong so lan choi :       " + tog);
        System.out.println("So lan doan trung binh : " + (int)(goa/tog));
        System.out.println("So lan doan it nhat :    " + bg);
        System.out.println("******************************Chi Tiet*****************************");
        
        for(int i = 0; i < tog; i++){
            int countMinnus = 0;
            String game = "";
            String range = "";
            String guess = "";
            String luckyNumber = "";

            for(int j = 0; j <  rp_s[i].length(); j++){
                if(rp_s[i].charAt(j) != '-'){
                    if(countMinnus == 0){
                        game += rp_s[i].charAt(j);
                    }else if(countMinnus == 1){
                        range += rp_s[i].charAt(j);
                    }else if(countMinnus == 2){
                        guess += rp_s[i].charAt(j);
                    }else if(countMinnus == 3){
                        luckyNumber += rp_s[i].charAt(j);
                    }
                }else{
                    countMinnus++;
                }
            }
            System.out.println("Lan choi thu: " + game + ", Do kho: " + range + ", So lan doan: " + guess + ", So may man: " + luckyNumber);
        }
        System.out.println("*******************************************************************");

    }
}

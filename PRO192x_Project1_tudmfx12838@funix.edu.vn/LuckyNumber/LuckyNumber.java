import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        play(input);

        //(Math.random())*((max-min)+1)) + min;
    }
    /*#############################################################################
    *# Method name: play
    *# Param: object Scanner to get input from System.in
    *# Description: LuckyNumer is a game which player must guess a random number
    *# How to implement:
    *# 1. Require player for inputing player's name
    *# 2. Require player for inputing level range (from min to max, ex: 1 ~ 100)
    *# 3. Create a random number as "lucky number" between level of range
    *# 4. Require player guess "lucky number" and count each guessing
    *# 5. if player guess "lucky number" out, ask player for continues or not
    *# 6. if player say y/yes/Y/YES, game to be continued. if not, stop game
    *##############################################################################*/
    public static void play(Scanner input){
        /* Variable's description list
        *# numOfMin is min value of level's range
        *# numOfMax is max value of level's range
        *# randomDouble is random number that to be got from random() method
        *# guessNum is gusse number that is inputed by player
        *# isContinues is set true from start game, it is false if player don't want to countinue
        *# totalOfGames count the number of game
        *# totalOfGuess count the number of player's guess
        *# guessOfAvg is average of player's guess
        *# bestGame is a least of number of gusse. it's set Integer.MAX_VALUE from start game
        *# report will get game's result each game play
        *# name get player name
        */
        int numOfMin = 0;
        int numOfMax = 0;
        double randomDouble = 0.0;
        int guessNum = 0, count = 0;
        boolean isContinues = true;
        int totalOfGames = 0, totalOfGuess = 0, guessOfAvg = 0, bestGame = Integer.MAX_VALUE;
        String report = "";
        String name = "";

        System.out.print("Nhap ten cua ban: ");
        name = input.nextLine();
        System.out.println("Chao mung " + name + " den tro choi doan so may man");
        
        /*Depend on isContinues to play or not */
        do{
            totalOfGames++;
            count = 0;

            System.out.print("Nhap do kho(muon doan tu 0 den 10 thi nhap '0 10'): ");
            numOfMin = input.nextInt();
            numOfMax = input.nextInt();

            //(Math.random())*((max-min)+1)) + min;
            randomDouble = (Math.random())*((numOfMax-numOfMin)+1) + numOfMin;
            int luckyNumber = (int)randomDouble;
            System.out.println("luckyNumber is " + luckyNumber);
    
            System.out.println("Toi dang nghi mot so trong khoang tu " + numOfMin + " den " + numOfMax + "...");

            /*
            *# If player's number of guess is greater than lucky number, imform that "So may man lon hon so du doan cua ban"
            *# If player's number of guess is less than lucky number, imform that "So may man nho hon so du doan cua ban"
            *# If player's number of guess is lucky number, imform time of guess
            */
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
            
            /*
            *# Calculate result and store to report
            *# Report format: totalOfGames-numOfMin~numOfMax-totalOfGuess-guessNum*
            */
            totalOfGuess = count;
            guessOfAvg += count;
            bestGame = bestGame > count ? count : bestGame;
            report += totalOfGames + "-" + numOfMin + "~" + numOfMax + "-" + totalOfGuess + "-" + guessNum +"*";
   
            /*
            *# Ask player for continues or not
            *# if player dont't want to continue, show the result and stop game
             */
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
    /*#############################################################################
    *# Method name: report
    *# Param: player(name), rp(report), tog(total of game), goa(gess of average), bg(best of game)
    *# Description: show the report after player stop the game
    *# How to implement:
    *# Report format: totalOfGames + "-" + numOfMin + "~" + numOfMax + "-" + totalOfGuess + "-" + guessNum +"*"...
    *# 1. Separate report to each game play
    *# 2. Print result to console
    *##############################################################################*/
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

        /*
        *# Report format: totalOfGames-numOfMin~numOfMax-totalOfGuess-guessNum*
        *# Separate report to each element of string following report format
        */
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
        
        /*
        *# Report format: totalOfGames-numOfMin~numOfMax-totalOfGuess-guessNum*
        */
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

import java.util.Scanner;
// import java.text.DecimalFormat;

public class GradeStudent {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int totalWeight[] = new int[1];
        totalWeight[0] = 100;

        begin();
        double midScore = midTerm(input, totalWeight);
        double finalScore = finalTerm(input, totalWeight);
        double homeworkScore = homework(input, totalWeight);
        report(midScore, finalScore, homeworkScore);
        
    }
    /**
     * The method begin() show  
     * @param 
     * @param 
     * @return  
     */
    public static void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }

    /**
     * The method begin() show  
     * @param input 
     * @param totalWeight
     * @return weighted score
     */
    public static double midTerm(Scanner input, int totalWeight[]){
        // DecimalFormat df = new DecimalFormat("#.#");
        int weight = 0;
        int ScoreEarned = 0;
        int shiftedScore = 0;
        int shiftAmount = 0;
        int totalPoint = 0;
        double weightedScore = 0;

        System.out.println("Midterm:"); 
        
        do{
            System.out.print("Weight (0-100)? ");
            weight = input.nextInt();
        }while(weight < 0 || weight > 100);
        
        totalWeight[0] -= weight;

        System.out.print("Score earned? ");
        ScoreEarned = input.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2=no)? ");
        shiftedScore = input.nextInt();
        if(shiftedScore == 1){
            System.out.print("Shift ammount? ");
            shiftAmount = input.nextInt();
        }

        totalPoint = ScoreEarned + shiftAmount;
        if(totalPoint > 100) totalPoint = 100;
        System.out.println("Total points = " + totalPoint + " / 100");

        weightedScore = (double)(totalPoint*weight)/100;
        weightedScore = (double)Math.round(weightedScore*10)/10;
        System.out.println("Weighted score = " + weightedScore + " / " + weight);
        System.out.println();

        return weightedScore;
    }

    public static double finalTerm(Scanner input, int totalWeight[]){
        // DecimalFormat df = new DecimalFormat("#.#");
        int weight = 0;
        int ScoreEarned = 0;
        int shiftedScore = 0;
        int shiftAmount = 0;
        int totalPoint = 0;
        double weightedScore = 0;

        System.out.println("Final:");
        
        do{
            System.out.print("Weight (0-"+ totalWeight[0] +")? ");
            weight = input.nextInt();
        }while(weight < 0 || weight > totalWeight[0]);
        
        totalWeight[0] -= weight;

        System.out.print("Score earned? ");
        ScoreEarned = input.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2=no)? ");
        shiftedScore = input.nextInt();
        if(shiftedScore == 1){
            System.out.print("Shift ammount? ");
            shiftAmount = input.nextInt();
        }

        totalPoint = ScoreEarned + shiftAmount;
        if(totalPoint > 100) totalPoint = 100;
        System.out.println("Total points = " + totalPoint + " / 100");

        weightedScore = (double)(totalPoint*weight)/100;
        weightedScore = (double)Math.round(weightedScore*10)/10;
        System.out.println("Weighted score = " + weightedScore + " / " + weight);
        System.out.println();

        return weightedScore;
    }

    public static double homework(Scanner input, int totalWeight[]){
        // DecimalFormat df = new DecimalFormat("#.#");
        int weight = 0;
        int numOfAsm = 0;
        int numOfattend = 0;
        int sectionPoint = 0;
        int totalasmPoint = 0;
        int totalasmPointMax = 0;

        int totalPoint = 0;
        int totalPointMax = 0;
        double weightedScore = 0;

        System.out.println("Homework:"); 

        // System.out.print("Weight (0-100): ");
        // weight = input.nextInt();
        do{
            System.out.print("Weight ("+ totalWeight[0] +")? ");
            weight = input.nextInt();
        }while(weight != totalWeight[0]);
        
        System.out.print("Number of assignments? ");
        numOfAsm = input.nextInt();


        for(int i = 1; i <= numOfAsm; i++){
            System.out.print("Assignment "+ i +" score and max? ");
            totalasmPoint += input.nextInt();
            totalasmPointMax +=  input.nextInt();
        }
        totalasmPoint = totalasmPoint > 150 ? 150 : totalasmPoint;
        totalasmPointMax = totalasmPointMax > 150 ? 150 : totalasmPointMax;

        System.out.print(" How many sections did you attend? ");
        numOfattend = input.nextInt();
        sectionPoint = numOfattend * 5 > 30? 30 : numOfattend * 5;
        System.out.println("Section points = " + sectionPoint + " / 30");

        totalPointMax = totalasmPointMax + 30; //30 is section's point of Max

        totalPoint = totalasmPoint + sectionPoint;
        if(totalPoint > totalPointMax) totalPoint = totalPointMax;
        System.out.println("Total points = " + totalPoint + " / " + totalPointMax);

        weightedScore = (double)(totalPoint*weight)/totalPointMax;
        weightedScore = (double)Math.round(weightedScore*10)/10;
        System.out.println("Weighted score = " + weightedScore + " / " + weight);
        System.out.println();

        return weightedScore;
    }

    public static void report(double midScore, double finalScore, double homeworkScore){
        double overRallPercent = midScore + finalScore + homeworkScore;
        double grade = 0.0;

        if(overRallPercent >= 85){
            grade = 3.0;
        }else if(overRallPercent >= 75){
            grade = 2.0;
        }else if(overRallPercent >= 60){
            grade = 1.0;
        }else{
            grade = 0.0;
        }
        
        System.out.println("Overall percentage = " + overRallPercent);
        System.out.println("Your grade will be at least: " + grade);
    }
}

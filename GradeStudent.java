import java.util.Scanner;

public class GradeStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalWeight[] = new int[1];
        totalWeight[0] = 100; // totalWeight is total of 100% consist of midterm, finalterm and homework score

        begin(); // Call begin
        double midScore = midTerm(input, totalWeight); // Call midTerm() and store returned value to midScore
        double finalScore = finalTerm(input, totalWeight); // Call finalTerm() and store returned value to finalScore
        double homeworkScore = homework(input, totalWeight); // Call homework() and store returned value to
                                                             // homeworkScore
        report(midScore, finalScore, homeworkScore); // Call report() with params of midScore, finalScore and
                                                     // homeworkScore

    }

    /**
     * The method begin() show software introduction
     */
    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }

    /**
     * The method midTerm() require user's input, calculate and return weighted
     * score of midterm
     * 
     * @param input       use object Scanner to get user's input
     * @param totalWeight is total of 100% consist of midterm, finalterm and
     *                    homework score.
     * @return return weighted score of midterm
     */
    public static double midTerm(Scanner input, int totalWeight[]) {
        int weight = 0;
        int ScoreEarned = 0;
        int shiftedScore = 0;
        int shiftAmount = 0;
        int totalPoint = 0;
        double weightedScore = 0;

        System.out.println("Midterm:");

        /**
         * Require input midterm's weight form 0 to 100. If it's outside range, require
         * input again
         */
        do {
            System.out.print("Weight (0-100)? "); // Require input weigth
            weight = input.nextInt();
        } while (weight < 0 || weight > 100);

        totalWeight[0] -= weight; // totalWeight[0] minus midterm's weight (100% - midterm's weight)

        System.out.print("Score earned? "); // Require input earned score
        ScoreEarned = input.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2=no)? "); // Require input score shifted or not
        shiftedScore = input.nextInt();
        if (shiftedScore == 1) {
            System.out.print("Shift ammount? "); // Require input shift ammount if scores shifted
            shiftAmount = input.nextInt();
        }

        totalPoint = ScoreEarned + shiftAmount; // Calculate total point
        if (totalPoint > 100)
            totalPoint = 100; // if total point greater than 100, it's 100
        System.out.println("Total points = " + totalPoint + " / 100");

        weightedScore = (double) (totalPoint * weight) / 100; // Calculate weighted score
        weightedScore = (double) Math.round(weightedScore * 10) / 10;
        System.out.println("Weighted score = " + weightedScore + " / " + weight);
        System.out.println();

        return weightedScore;
    }

    /**
     * The method finalTerm() require user's input, calculate and return weighted
     * score of finalterm
     * 
     * @param input       use object Scanner to get user's input
     * @param totalWeight is total of 100% consist of midterm, finalterm and
     *                    homework score.
     * @return return weighted score of finalterm
     */
    public static double finalTerm(Scanner input, int totalWeight[]) {
        int weight = 0;
        int ScoreEarned = 0;
        int shiftedScore = 0;
        int shiftAmount = 0;
        int totalPoint = 0;
        double weightedScore = 0;

        System.out.println("Final:");

        /**
         * Require input finalterm's weight form 0 to (100% - midterm's weight). If it's
         * outside range, require input again
         */
        do {
            System.out.print("Weight (0-" + totalWeight[0] + ")? ");
            weight = input.nextInt();
        } while (weight < 0 || weight > totalWeight[0]);

        totalWeight[0] -= weight; // totalWeight[0] minus midterm's weight (100% - midterm's weight - finalterm's
                                  // weight)

        System.out.print("Score earned? "); // Require input earned score
        ScoreEarned = input.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2=no)? "); // Require input score shifted or not
        shiftedScore = input.nextInt();
        if (shiftedScore == 1) {
            System.out.print("Shift ammount? "); // Require input shift ammount if scores shifted
            shiftAmount = input.nextInt();
        }

        totalPoint = ScoreEarned + shiftAmount; // Calculate total point
        if (totalPoint > 100)
            totalPoint = 100;
        System.out.println("Total points = " + totalPoint + " / 100");

        weightedScore = (double) (totalPoint * weight) / 100; // Calculate weighted score
        weightedScore = (double) Math.round(weightedScore * 10) / 10;
        System.out.println("Weighted score = " + weightedScore + " / " + weight);
        System.out.println();

        return weightedScore;
    }

    /**
     * The method homework() require user's input, calculate and return weighted
     * score of homework
     * 
     * @param input       use object Scanner to get user's input
     * @param totalWeight is total of 100% consist of midterm, finalterm and
     *                    homework score.
     * @return return weighted score of homework
     */
    public static double homework(Scanner input, int totalWeight[]) {
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

        /**
         * Require input homework's weight is vaule of (100% - midterm's weight -
         * finalterm's). If it's
         * different from, require input again
         */
        do {
            System.out.print("Weight (" + totalWeight[0] + ")? ");
            weight = input.nextInt();
        } while (weight != totalWeight[0]);

        System.out.print("Number of assignments? "); // Require input number of assignment
        numOfAsm = input.nextInt();

        for (int i = 1; i <= numOfAsm; i++) {
            System.out.print("Assignment " + i + " score and max? "); // Require input score and max score of assignment
            totalasmPoint += input.nextInt();
            totalasmPointMax += input.nextInt();
        }
        totalasmPoint = totalasmPoint > 150 ? 150 : totalasmPoint; // Assignment's max point is 150, if it's greater
                                                                   // than 150, it's 150
        totalasmPointMax = totalasmPointMax > 150 ? 150 : totalasmPointMax; // Assignment's max point is 150, if it's
                                                                            // greater than 150, it's 150

        System.out.print("How many sections did you attend? "); // Require input attended section
        numOfattend = input.nextInt();
        sectionPoint = numOfattend * 5 > 30 ? 30 : numOfattend * 5; // Section's max point is 30,if it's greater than
                                                                    // 30, it's 30
        System.out.println("Section points = " + sectionPoint + " / 30");

        totalPointMax = totalasmPointMax + 30; // 30 is section's max point

        totalPoint = totalasmPoint + sectionPoint; // Calculate total point
        if (totalPoint > totalPointMax)
            totalPoint = totalPointMax;
        System.out.println("Total points = " + totalPoint + " / " + totalPointMax);

        weightedScore = (double) (totalPoint * weight) / totalPointMax; // Calculate weighted score
        weightedScore = (double) Math.round(weightedScore * 10) / 10;
        System.out.println("Weighted score = " + weightedScore + " / " + weight);
        System.out.println();

        return weightedScore;
    }

    /**
     * The method report() show the least grade that user can approach
     * 
     * @param midScore      weighted score of midterm
     * @param finalScore    weighted score of finalterm
     * @param homeworkScore weighted score of homework
     */
    public static void report(double midScore, double finalScore, double homeworkScore) {
        double overRallPercent = midScore + finalScore + homeworkScore;
        double grade = 0.0;

        /**
         * Value of grade is depend on Percent of Overrall if:
         * greater than or equal to 85%, grade is 3.0
         * greater than or equal to 75% and less than 85%, grade is 2.0
         * greater than or equal to 60% and less than 75%, grade is 1.0
         * less than 60%, grade is 0.0
         */
        if (overRallPercent >= 85) {
            grade = 3.0;
        } else if (overRallPercent >= 75) {
            grade = 2.0;
        } else if (overRallPercent >= 60) {
            grade = 1.0;
        } else {
            grade = 0.0;
        }

        System.out.println("Overall percentage = " + overRallPercent);
        System.out.println("Your grade will be at least: " + grade);
    }
}

package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is the amount of money you are starting with?");
		int startAmount = in.nextInt();
		
		System.out.println("What is the probability that you win a single play?");
		double winChance = in.nextDouble();
		
		System.out.println("What is your win limit?");
		int winLimit = in.nextInt();
		
		System.out.println("What is the total number of days you want to simulate?");
		int totalSimulations = in.nextInt();
		
		String outcome = "Not Playing";
		boolean play = true;
		int currentAmount = startAmount;
		double ruinRate = 0.0;
		int numberOfRuins = 0;
		double expectedRuinRate = 0.0;
		double alpha = 0.0;
		int numberOfPlays = 0;
		
		for (int i = 1; i <= totalSimulations; i++) {
			while (currentAmount < winLimit) {
				play = Math.random() < winChance;
				numberOfPlays ++;
				
				if (play == true) {
					// System.out.println("Win");
					currentAmount += 1;
					
				}
				
				else if (play == false) {
					// System.out.println("Loss");
					currentAmount -= 1;
					
				}
				
				if (currentAmount <= 0) {
					outcome = "Ruin";
					numberOfRuins ++;
					break;
				}
				
				outcome = "Success";
			}
			System.out.println("Simulation Day " + i + ": " + numberOfPlays + " " + outcome);
			currentAmount = startAmount;
			numberOfPlays = 0;
		}
		
		ruinRate = numberOfRuins / totalSimulations;
		System.out.println("Ruin Rate: " + ruinRate);
		if (winChance == 0.5) {
			expectedRuinRate = 1 - startAmount/winLimit;
		}
		else {
			alpha = (1 - winChance) / winChance;
			expectedRuinRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / 1 - Math.pow(alpha, winLimit); 
		}
		System.out.println("Expected Ruin Rate: " + expectedRuinRate);
		
	}

}

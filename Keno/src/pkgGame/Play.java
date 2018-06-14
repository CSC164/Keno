package pkgGame;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {

		int[] iArray = new int[0];
		
		Player p = new Player("Bert");
		Keno k = new Keno(5, 3);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of balls to choose");

		while (!sc.hasNextInt())
			sc.next();
		int nbrOfBalls = sc.nextInt();
		
		PlayerKeno pk = new PlayerKeno(p, k, nbrOfBalls);		
		System.out.println("You entered: " + nbrOfBalls);

		int iCnt = 0;
		
		while (iCnt < nbrOfBalls)
		{
			System.out.println("Ball: " + (iCnt + 1));
			while (!sc.hasNextInt())
				sc.next();
			
			int iPlayerBall = sc.nextInt();
			
			if (pk.AddPlayerBall(iPlayerBall))
			{
				iCnt++;
			}
			else
			{
				System.out.println("Ball: " + iPlayerBall + " already selected");
			}				
		}
		
		int [] iMatchNumbers = Keno.KenoResults(k, pk);
		
		System.out.println("The following balls matched");
		
		for (int i : iMatchNumbers)
		{
			System.out.print(i + " ");
		}
		
		
		System.out.println("\nThanks for playing");
		
	}

}

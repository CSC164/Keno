package pkgGame;

import java.security.SecureRandom;

public class Keno {

	private int[] KenoNumbers;

	public int[] getKenoNumbers() {
		return KenoNumbers;
	}

	public Keno(int iTotalNumber, int iDrawNumber) {
		// Build an array of iDrawNumber length
		// pulling iDrawNumber random unique numbers
		SecureRandom random = new SecureRandom();
		KenoNumbers = new int[iDrawNumber];
		int iCnt = 0;

		while (iCnt < iDrawNumber) {
			int iRandInt = random.nextInt(iTotalNumber) + 1;
			if (!isExists(KenoNumbers, iRandInt)) {
				KenoNumbers[iCnt++] = iRandInt;
			}
		}
		;

		/*
		 * for (iCnt = 0; iCnt < iDrawNumber;) { int iRandInt =
		 * random.nextInt(iTotalNumber) + 1; if (!isExists(KenoNumbers, iRandInt)) {
		 * KenoNumbers[iCnt] = iRandInt; iCnt++; } }
		 * 
		 * while (KenoNumbers[iDrawNumber - 1] == 0) { int iRandInt =
		 * random.nextInt(iTotalNumber) + 1; if (!isExists(KenoNumbers, iRandInt)) {
		 * KenoNumbers[iCnt++] = iRandInt; } };
		 * 
		 * for (int i : KenoNumbers) { KenoNumbers[iCnt++] = PullNumber(KenoNumbers,
		 * iTotalNumber); }
		 */

		/*
		 * do { int iRandInt = random.nextInt(iTotalNumber) + 1; if
		 * (!isExists(KenoNumbers, iRandInt)) { KenoNumbers[iCnt] = iRandInt; iCnt++; }
		 * } while (iCnt < iDrawNumber);
		 */
	}

	/*
	 * private static int PullNumber(int[] arr, int iTotalNumber) { SecureRandom
	 * random = new SecureRandom();
	 * 
	 * while (true) { int iRandInt = random.nextInt(iTotalNumber) + 1; if
	 * (!isExists(arr, iRandInt)) { return iRandInt; } }
	 * 
	 * }
	 */

	static boolean isExists(int[] arr, int iNumber) {
		for (int i : arr) {
			if (i == iNumber)
				return true;
			if (i == 0)
				break;
		}
		return false;
	}
	
	
	public static int[] KenoResults(Keno k, PlayerKeno pk)
	{
		int [] iTmpArray = new int [pk.getPlayerKenoNumbers().length];
		
		int iCnt = 0;		
		
		for (int iPK: pk.getPlayerKenoNumbers())
		{
			for (int iK: k.getKenoNumbers())
			{
				if (iPK == iK)
				{
					iTmpArray[iCnt] = iPK;
					iCnt++;
					
				}
			}
		}
		
		int [] iReturnArray = new int[iCnt];
		
		for (int i = 0; i< iCnt ; i++)
		{
			iReturnArray[i] = iTmpArray[i];
		}
		
		return iReturnArray;
		
	}

}

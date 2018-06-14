package pkgGame;

public class PlayerKeno {

	private Player p;
	private Keno k;	
	private int[] PlayerKenoNumbers;
	
	public PlayerKeno(Player p, Keno k, int iNbrOfBalls)
	{
		this.p = p;
		this.k = k;
		this.PlayerKenoNumbers = new int[iNbrOfBalls];		
	}
	
	public boolean AddPlayerBall(int Ball)
	{
		if (!Keno.isExists(PlayerKenoNumbers, Ball))
		{
			for (int iCnt = 0; iCnt<PlayerKenoNumbers.length; iCnt++)
			{
				if (PlayerKenoNumbers[iCnt] != 0)
				{
					continue;
				}
				PlayerKenoNumbers[iCnt] = Ball;
				break;
			}
			//	Add this number
		}
		else
		{
			//	Reject
			return false;
		}
		
		return true;
	}

	public int[] getPlayerKenoNumbers() {
		return PlayerKenoNumbers;
	}
	
	
	
}

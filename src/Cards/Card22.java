package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card22 extends Card {

	
	
	public Card22()
	{
		//super();
		super.setName("22");
		super.setCName("Fall in the Pond");
		super.setCLocation("Play in the Japanese Garden");
		super.setEffect("Prerequiste: 3 Learning Chips , gain 1 Integrity and 1 Craft Chip; Fail : Go to the Lactation Lounge");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if( player.getLocation().equals("Japanese Garden")   && player.getLearning() >= 3 )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setIntegrity(player.getIntegrity()+ 1);
		player.setCraft(player.getCraft() + 1);
		setEffect("gained 1 Integrity and Craft Chip");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		setEffect("and was moved to the Lactation Lounge");
		player.setLocation("Lactation Lounge");
		
		
	}

}
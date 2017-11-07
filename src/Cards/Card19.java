package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card19 extends Card {

	
	
	public Card19()
	{
		//super();
		super.setName("19");
		super.setCName("Score a Goal!");
		super.setCLocation("Play in George Allen Field");
		super.setEffect("Prerequiste: 3 Craft Chips , gain 5 Quality Points and 1 Integrity Chip; Fail : Go to Student Parking");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("George Allen Field") && player.getCraft() >= 3 )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints()+ 5);
		player.setIntegrity(player.getIntegrity() + 1);
		setEffect("gained 5 Quality Points and 1 Integrity Chips");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		setEffect("and was moved to the Student Parking");
		player.setLocation("Student Parking");
		
		
	}

}
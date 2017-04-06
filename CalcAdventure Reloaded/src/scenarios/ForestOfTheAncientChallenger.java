package scenarios;

import game.Combat;
import game.Utilities;
import game.WorldVariables;
import Entities.Entity;
import Entities.Entity.Alignment;
import Entities.Ohmarr;

public class ForestOfTheAncientChallenger extends Scenario {

	public String scenarioName = "Forest of the Ancient Challenger";
	public Scenario[] connected;
	public String[] destinationNames;
	public String[] keyWords;

	public ForestOfTheAncientChallenger() {
		// TODO Auto-generated constructor stub
	}

	public void loadScenario() {

		boolean playerSaysYes = false;

		Utilities.display(	
			"After your encounter with the strange man,",
			"You get to the forest entrance.",
			"Outside, you find another sign.",
			"It heeds a warning",
			"\"Ahead is the Forest of the Ancient Challenger\"",
			"\"Enter at your own risk\"",
			"Against your better judgement, you decide to go in.");
		
		Utilities.waitForEnter();
		
		Utilities.display(
			"\"GROAR!\"",
			"You hear the battlecry of a nearby monster, who's name and origin is unkown to you.",
			"Do you approach it?");
		playerSaysYes = Utilities.playerYN();
		if (playerSaysYes) {
			encounterOhmarr();
		} else {
			Utilities.display("You head back to the crossroads.");
			moveTo(new Crossroads());
		}
	}
	
	private void encounterOhmarr(){

		boolean playerSaysYes = false;
		String playerInput = "";
		
		Utilities.display(
			"You find that the unknown noise was made by a man.",
			"As you approach, the man exclaims,",
			"\"BACK! Back I say!\"",
			"Do you comply?");
		playerSaysYes = Utilities.playerYN();
		if(playerSaysYes){
			Utilities.display(
				"You decide to back off.",
				"The stranger approves.",
				"\"Ahh... Very good. As I see you have at least half a brain, I shall allow you to take a little quiz.\"",
				"Do you accept?");
			playerSaysYes = Utilities.playerYN();
			if(playerSaysYes){
				Utilities.display(
					"You decide to accept the offer",
					"\"I shall humbly comply to your wishes,\" you say",
					"The man begins the quiz",
					"\"Okay then, first question. What type of enemy did you fight at the beginning of the game?\"",
					"You say...",
					"\"What an odd question... I shall have to make a guess\"");
				playerInput = Utilities.getInput();
				if(playerInput.equalsIgnoreCase("Young Wolf")){
					Utilities.display(
						"\"Very nice... You have answered the question correctly.",
						"Time for the next one.\"",
						"How many hitpoints did they have?");
					if(Utilities.getInput().equalsIgnoreCase("7")){
						Utilities.display(
							"\"Wow. That is correct!\"",
							"\"Final question\"",
							"\"What is the name of the town on the sign?\"");
						if(Utilities.getInput().equalsIgnoreCase("Argandual")){
							WorldVariables.player.modITL(3);
							WorldVariables.player.modSTR(3);
							Utilities.display(
								"\"Hmm... Quite the smart cookie we have here. I shall increase your strength-\"",
								"You reply,");
							if(WorldVariables.player.getCHA() > 11){
								Utilities.display(
									"\"I do pride myself in being intelligent\"",
									"He says,",
									"\"That's good! From what I can tell,\"");
								if(WorldVariables.player.getITL() > (new Ohmarr()).getITL()){
									Utilities.display(
										"\"I can learn a thing or two from yoFasdfu.\"",
										"\"Let me join you on your adventure.\"",
										"The man has joined your party.");
									Ohmarr ohmarr = new Ohmarr();
									ohmarr.setAlignment(Alignment.Friendly);
									WorldVariables.player.addPartyMember(ohmarr);
								} else {
									Utilities.display(
										"\"You have insulted my intelligence.\"",
										"\"Therefore I, the wisdom-endowed and legendary Ohmarr, will destroy you!\"",
										"Prepare for battle!");
									fightOhmarr();
								}
							} else {
								Utilities.display("\"Yeah. Smarter than you.\"");
								fightOhmarr();
							}
						} else {
							Utilities.display("\"Ohh... Not even close. Wrong!\"");
							fightOhmarr();
						}
					} else{
						Utilities.display("Pay more attention!");
						fightOhmarr();
					}
				} else {
					Utilities.display(2000, 
						"\"Wow. I can't believe...\"",
						"\"You got that one wrong!\"");
					fightOhmarr();
				}
			} else {
				Utilities.display("\"What?! That was a once in a lifetime offer!\"");
				fightOhmarr();
			}
		} else {
			Utilities.display(
				"You slowly walk forward",
				"Insulted, The man exclaims,",
				"\"Disgusting wench! Your presence has soured the atmosphere!\"");
			fightOhmarr();
		}
	}
	
	private void fightOhmarr(){
		boolean playerSaysYes = false;
		Ohmarr ohmarr = new Ohmarr();
		ohmarr.setAlignment(Alignment.Enemy);
		Combat.battle(Utilities.concatAll(WorldVariables.player.getParty(), new Entity[]{WorldVariables.player, ohmarr}));
		Utilities.display(
			"Ohmarr, submitting to his fate, signals for you to come closer",
			"Shall you hear his final request?");
		playerSaysYes = Utilities.playerYN();
		if(playerSaysYes){
			Utilities.display(
				"You move closer to the dying man and ask",
				"\"What is it that you wish to tell me, Ohmarr?\"",
				"Ohmarr, in a weak voice, whispers,",
				"\"I cannot die. At least, not yet.\"",
				"\"I do not wish to leave this world with all of this power wasted.\"",
				"\"Therefore, I ask that you allow me to transfer all of my strength and knowledge to you.\"",
				"Will you allow this dying man his final will?");
			playerSaysYes = Utilities.playerYN();
			if(playerSaysYes){
				Utilities.display(
					"In reply, you say,",
					"\"Grant your will I shall, Ohmarr. It would be wrong of me not to.\"",
					"Ohmarr, with his dying breath, recites an ancient incantation.",
					"He is barely audible, and must gasp for breath in between each sentence",
					"\"Rahten, rahten, Ahbeck.\"",
					"\"Aritehn a tum sono.\"",
					"\"Tetareh, a tum axiol\"",
					"\"Ahbeck, rahten, translae sotar ma peh!\"",
					"With his final breath, you feel an overwhelming amount of energy and information flood through you.");
				WorldVariables.player.modMAX_HP(Ohmarr.MAX_HP);
				WorldVariables.player.modCUR_HP(WorldVariables.player.getMAX_HP());
				WorldVariables.player.modSTR(Ohmarr.STR);
				WorldVariables.player.modITL(Ohmarr.ITL);
				
				Utilities.waitForEnter();
				
				Utilities.display(
					"You have been fully healed",
					"You have obtained all of Ohmarr's strength and wisdom",
					"Out of respect for the man, you dig a grave and bury him",
					"After the somber occasion, you decide to return to the path");
			}
		}
		
		if(!playerSaysYes){
			Utilities.display(
				"In reply, you say,",
				"\"For an old hag like you? Never.\"",
				"He says to you,",
				"\"Ahh... then you are undeserving of this power. Be gone with you!\"",
				"Ohmarr diappears in a cloud of smoke, leaving you to wonder what it was he wanted.");
		}
	}

}

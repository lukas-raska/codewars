package solutions.kyu8.terminalGmaeCombatFunction;


//INSTUCTIONS
//Create a combat function that takes the player's current health and the amount of damage recieved, and returns the
// player's new health. Health can't be less than 0.


public class Game {


    public static int combat(int health,
                             int damage) {
        return (health > damage) ? health - damage : 0;
    }
}

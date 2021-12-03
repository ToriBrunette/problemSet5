import java.util.Random;
import java.util.Scanner;

/**  Description: This is a text based adventure game in which users
 *          are able to input their actions while fighting against
 *          a randomized enemy. These actions include attacking, drinking
 *          a health potion, and running. Your health and the enemies'
 *          health is posted after users choose their action. Depending
 *          on user responses, you can either escape the enemy or be
 *          too weak to fight any longer.
 *
 * @ author Tori Brunette
 */

public class textBasedAdventureGame {
        public static void main(String[] args) {
             // System objects
            Scanner in = new Scanner(System.in);
            Random rand = new Random();

            // Game variables
            String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
            int maxEnemyHealth = 75;
            int enemyAttachDamage = 25;

            // Player variables
            int health = 100;
            int attackDamage = 50;
            int numHealthPotions = 3;
            int healthPotionHealAmount = 30;
            int healthPotionDropChance = 50; // Percentage

            boolean running = true;
            System.out.println("Welcome to the Dungeon!");

            // While the game is running...
            GAME:
            while (running){
                System.out.println("-----------------------------------------------");

                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies[rand.nextInt(enemies.length)];
                System.out.println("\t# " + enemy + " has appeared! #\n");

                while (enemyHealth > 0){
                    System.out.println("\tYour HP: " + health);
                    System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1. Attack");
                    System.out.println("\t2. Drink health potion");
                    System.out.println("\t3. Run!");

                    // If 1 or 2 is inputted...
                    String input = in.nextLine();
                    if(input.equals("1")){
                        int damageDealt = rand.nextInt(attackDamage);
                        int damageTaken = rand.nextInt(enemyAttachDamage);

                        enemyHealth -= damageDealt;
                        health -= damageTaken;

                        System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                        System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                        if(health<1){
                            System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                            break;
                        }
                    }
                    else if(input.equals("2")){
                        if (numHealthPotions > 0){
                            health +=healthPotionHealAmount;
                            numHealthPotions--;
                            System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + " . "
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                        }
                        else {
                            System.out.println("\t> You have no health potions left! Defeat enemies for a change to get one!\n");
                        }
                    }
                    else if (input.equals("3")){
                        System.out.println("\tYou run away from the " + enemy + "!");
                        continue GAME;
                    }
                    else {
                        System.out.println("\tInvalid command!");
                    }
                }

                // If health is less than 1
                if (health < 1){
                    System.out.println("You limp out of the dungeon, weak from battle.");
                    break;
                }
                System.out.println("-----------------------------------------------");
                System.out.println(" # " + enemy + " was defeated! # ");
                System.out.println(" # You have " + health + " HP left. #");
                if(rand.nextInt(100) < healthPotionDropChance){
                    numHealthPotions++;
                    System.out.println(" # The " + enemy + " dropped a health potion! # ");
                    System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
                }
                System.out.println("-----------------------------------------------");
                System.out.println("What would you like to do now?");
                System.out.println("1. Continue fighting");
                System.out.println("2. Exit dungeon");

                String input = in.nextLine();

                // When both are not inputted
                while(!input.equals("1") && !input.equals("2")){
                    System.out.println("Invalid command!");
                    input = in.nextLine();
                }

                // If 1 vs 2...
                if(input.equals("1")){
                    System.out.println("You continue on your adventure!");
                }
                else if(input.equals("2")){
                    System.out.println("You exit the dungeon, successful from your adventures!");
                    break;
                }
            }

            System.out.println("###############################");
            System.out.println("# THANKS FOR PLAYING! #");
            System.out.println("###############################");

        }
}

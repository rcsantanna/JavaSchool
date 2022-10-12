/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighting_4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pichau
 */
public class Fighting_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //monster stats
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();
        
        //player stats
        System.out.println("Player Stats:");
        System.out.print("Attack Points:");
        int playerAP = generator.nextInt(6)+5;
        System.out.println(playerAP);
        System.out.print("Defense Points:");
        int playerDP = generator.nextInt(10)+6;
        System.out.println(playerDP);
        System.out.print("Damage:");
        int playerDMG = generator.nextInt(3)+2;
        System.out.println(playerDMG);
        System.out.print("Health Points:");
        int playerHP = generator.nextInt(20)+25;
        System.out.println(playerHP);
        System.out.println();
       
        for (int i = 0; i < 3; i++) {
            //monster's name
            String monsterName;
            int num = generator.nextInt(5);
            switch (num) {
                case 0: monsterName = "Black Demon"; break;
                case 1: monsterName = "Rabbit"; break;
                case 2: monsterName = "Silver Dragon"; break;
                case 3: monsterName = "Mountain Troll"; break;
                case 4: monsterName = "Alien"; break;
                default: monsterName = "MissingNº"; break;
            }

            System.out.println(monsterName + " Appears!");
            System.out.println();
            System.out.println(monsterName + " Stats:");
            System.out.print("Attack Points:");
            int monsterAP = generator.nextInt(8)+1;
            System.out.println(monsterAP);
            System.out.print("Defense Points:");
            int monsterDP = generator.nextInt(15)+3;
            System.out.println(monsterDP);
            System.out.print("Damage:");
            int monsterDMG = generator.nextInt(3)+1;
            System.out.println(monsterDMG);
            System.out.print("Health Points:");
            int monsterHP = generator.nextInt(20)+15;
            System.out.println(monsterHP);
            System.out.println();

            //sc.nextLine();
            boolean runaway = false;

            //Turn
            do {
            boolean attacker = generator.nextBoolean();
            //player 1st
            if (attacker) {
                System.out.println("You attack!");
                int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
                int valueAP = playerAP + dice;
                System.out.println("Rolled Values: "+dice);
                System.out.println("Your attack value: "+valueAP);
                if (valueAP > monsterDP) {
                    System.out.println("Attack succsessful!");
                    monsterHP = monsterHP - playerDMG;
                    System.out.println(monsterName + "'s HP: "+ monsterHP);
                } else {
                    System.out.println("Your attack was not successful!");
                }
            //monster 1st
                } else {  
                    System.out.println(monsterName + " attacks!");
                    int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
                    int valueAP = monsterAP + dice;
                    System.out.println("Rolled values:"+ dice);
                    System.out.println(monsterName + "'s attack value:"+valueAP);
                    if (valueAP > playerDP) {
                        System.out.println(monsterName + "'s attack was succsesful!");
                        playerHP = playerHP - monsterDMG;
                        System.out.println("Player's HP: " +playerHP);
                    } else {
                    System.out.println(monsterName + "'s attack was not succsesful!");
                    }
                }
                System.out.println("Press ENTER to continue. (Or type in 'run' to run away)");
                String command = sc.nextLine();
                switch (command) {
                    case "run":
                        System.out.println("You ran away. Coward! -4 HP");
                        playerHP -= 4;
                        runaway = true;
                        break;
                    default:
                }
            } while (playerHP > 0 && monsterHP> 0 && !runaway);
            if (playerHP <= 0) {
                System.out.println("You are dead.");
                break;
            }
            if (monsterHP <= 0) {
                System.out.println("Congratulaions! You were able to defeat the " + monsterName + "!");
                System.out.println();
            }
        }
    }
}
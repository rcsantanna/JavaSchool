/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighting;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pichau
 */
public class Fighting3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //monster stats
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();
        
        System.out.print("Attack Points of Monster:");
        int monsterAP = generator.nextInt(8)+1;
        System.out.println(monsterAP);
        System.out.print("Defense Points of Monster:");
        int monsterDP = generator.nextInt(15)+3;
        System.out.println(monsterDP);
        System.out.print("Damage of Monster:");
        int monsterDMG = generator.nextInt(3)+1;
        System.out.print(monsterDMG);
        System.out.print("Health Points of Monster:");
        int monsterHP = generator.nextInt(20)+15;
        System.out.print(monsterHP);
        
        //player stats
        System.out.print("Your Attack Points:");
        int playerAP = generator.nextInt(6)+5;
        System.out.println(playerAP);
        System.out.print("Your Defense Points:");
        int playerDP = generator.nextInt(10)+6;
        System.out.println(playerDP);
        System.out.print("Your Damage:");
        int playerDMG = generator.nextInt(3)+2;
        System.out.print(playerDMG);
        System.out.print("Health Points of Player:");
        int playerHP = generator.nextInt(20)+25;
        System.out.print(playerHP);
        
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
                System.out.println("Monster's HP: "+ monsterHP);
            } else {
                System.out.println("Your attack was not successful!");
            }
        //monster 1st
            } else {  
                System.out.println("Monster attacks!");
                int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
                int valueAP = monsterAP + dice;
                System.out.println("Rolled values:"+ dice);
                System.out.println("Monster's attack value:"+valueAP);
                if (valueAP > playerDP) {
                    System.out.println("Monster's attack was succsesful!");
                    playerHP = playerHP - monsterDMG;
                    System.out.println("Player's HP: " +playerHP);
                } else {
                System.out.println("Monster's attack was not succsesful!");
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
        }
        if (monsterHP <= 0) {
            System.out.println("Congratulaions! You were able to defeat the monster!");
        }
    }
}
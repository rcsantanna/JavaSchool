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
public class Fighting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //monster stats
        Scanner sc = new Scanner(System.in);
        System.out.println("Attack Points of Monster:");
        int monsterAP = sc.nextInt();
        System.out.println("Defense Points of Monster:");
        int monsterDP = sc.nextInt();
        System.out.println("Damage of Monster:");
        int monsterDMG = sc.nextInt();
        System.out.println("Health Points of Monster:");
        int monsterHP = sc.nextInt();
        
        //player stats
        System.out.println("Your Attack Points:");
        int playerAP = sc.nextInt();
        System.out.println("Your Defense Points:");
        int playerDP = sc.nextInt();
        System.out.println("Your Damage:");
        int playerDMG = sc.nextInt();
        System.out.println("Health Points of Player:");
        int playerHP = sc.nextInt();
        
        //Turn
        Random generator = new Random();
        boolean attacker = generator.nextBoolean();
        //player 1st
        if (attacker) {
            System.out.println("You go first!");
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
            System.out.println("Monster first!");
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
    }
    
}

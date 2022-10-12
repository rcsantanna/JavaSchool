/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdie;

import java.util.Scanner;

/**
 *
 * @author Pichau
 */
public class CheckDie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int die;
        do {
            System.out.println("Please give in the value of the die:");
            die = sc.nextInt();
            if (die < 1 || die > 6) {
                System.out.println("The value of the die is bad.");
            }
        } while (die < 1 || die > 6);
        
    }
    
}

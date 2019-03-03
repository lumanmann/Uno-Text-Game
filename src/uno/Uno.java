/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.Scanner;

/**
 *
 * @author wingyiu
 */
public class Uno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("輸入玩家的人數：");
        int playerNum = scanner.nextInt();
        UnoGame game = new UnoGame(playerNum);
        game.start();
        
    }
    
}

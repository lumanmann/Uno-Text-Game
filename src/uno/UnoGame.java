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
public class UnoGame {
    private static Scanner scanner = new Scanner(System.in);
    private int playersNum;
    private Player[] cardPlayers;
    private Cards deck;
    private int round;
    
    // constructor
    public UnoGame(int num) {
        playersNum = num;
        cardPlayers = new Player[playersNum];
        deck = new Cards();
        round = 1;
    }
    
     // 開始一場新的遊戲
    public void start() {
        System.out.println("輸入" + playersNum + "位玩家的名字：");
        for (int i=0; i< playersNum; i++) {
            String name = scanner.next();
            cardPlayers[i] = new Player(name);
        }
        deck.shuffle();
        game();
    }
    
    // 
    private void game() {
        // 每位發7張 剩下做為"牌庫"
        for (int i=0; i< playersNum; i++) {
           for (int j=0; j< 7; j++) {
               cardPlayers[i].addCard(deck.deal());
           }
        }
        
        // 抽出第一張牌
        Card cardOnTop = deck.deal();
        
        do {
            System.out.println("---------Round " + round++ + "----------");
            for (int i=0; i< playersNum; i++) { 
                System.out.println("桌面上的牌：" + cardOnTop.getDetails());
                System.out.println("玩家 " + cardPlayers[i].getName() + " 手上的牌：");
                cardPlayers[i].printUno(cardPlayers[i].getMyCards());
                System.out.println();
                System.out.println("玩家 " + cardPlayers[i].getName() + " 可以出的牌：");
                cardPlayers[i].checkUno(cardOnTop);
                if (cardPlayers[i].getCurrentTmpNum() > 0) {
                    cardPlayers[i].printUno(cardPlayers[i].checkUno(cardOnTop));
                    System.out.println();
                    Card[] cardsOpt = cardPlayers[i].checkUno(cardOnTop);
                       System.out.print("玩家 " + cardPlayers[i].getName() + " 請出選擇出第幾張牌：");
                       int optNum = scanner.nextInt();
                    Card playedCard = cardsOpt[optNum-1];
                    cardPlayers[i].playOneCard(playedCard);
                    cardOnTop = playedCard;
                    // 倒數第2張牌沒有喊Uno的話會被罰抽2張牌
                    System.out.println("要喊Uno嗎?(Y/N)");
                    String uno = scanner.next();
                    if (cardPlayers[i].getCurrentCardNumber() == 1) {
                        if (uno.equals("N")){
                            cardPlayers[i].addCard(deck.deal());
                            cardPlayers[i].addCard(deck.deal());
                        }
                    }
                    // 沒有手牌為贏家
                    if (cardPlayers[i].getCurrentCardNumber() == 0) {
                        System.out.println("玩家" + cardPlayers[i].getName() + "贏了");
                        break;
                    };
                } else {
                    // 沒有可以出的牌-> 抽一張牌
                    System.out.println("沒有可以出的牌，抽一張牌");
                    cardPlayers[i].addCard(deck.deal());
                } 
            }
            
            
            
        } while (deck.getCurrentCardIndex() < deck.getCARD_NUM());
        
        
    }
    
    
    
       
}

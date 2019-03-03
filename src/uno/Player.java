/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author wingyiu
 */
public class Player {
    private String name;
    private Card[] myCards;
    private int currentCardNumber, currentTmpNum;
    
    
    // constructor
    public Player(String name) {
        this.name = name;
        myCards = new Card[4];
        currentTmpNum = 0;
        currentCardNumber = 0;
    }
    
    
    // getter
    public Card[] getMyCards() {
        return this.myCards;
    }
    
    public int getCurrentCardNumber() {
        return this.currentCardNumber;
    }
    
    public int getCurrentTmpNum() {
        return this.currentTmpNum;
    }
    
    public String getName() {
        return this.name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    
 
    /****OTHER****/
    
    // 出牌
    public Card playOneCard(Card selectedCard) {
        int num;
        for (int i=0; i<this.myCards.length; i++) {
            if (myCards[i] == selectedCard){
                num = i;
                Card tmp = myCards[num];
                myCards[num] = null;
                sortMyCard();
                currentCardNumber--;
                return tmp;
            }
        }
        return null;
    }
    
    // 加一張牌到myCards
    public void addCard(Card newCard) {
        if (currentCardNumber >= this.myCards.length){
            this.myCards = doubleArray(this.myCards);
        }
        this.myCards[currentCardNumber++] = newCard;
    }
    
    
    // 印出可以出的牌, 沒有可以出的牌則印出 沒有牌可出
    public void printUno(Card[] cards) {
        if (cards.length == 0) {
           System.out.print("沒有牌可出");
           return;
        }
        
        for (int i=0; i<cards.length; i++) {
            if (cards[i] != null) {
                System.out.print(cards[i].getDetails() + " ");
            }
        }
    }
    
    // 傳入目前場上的最後一張牌進行判斷 回傳可以出的牌
    public Card[] checkUno(Card card) {
        Card[] tmp = new Card[currentCardNumber];
        currentTmpNum = 0;
        for (int i = 0; i< currentCardNumber; i++){
           // 如果顏色or數字相同就加到tmp
           if (myCards[i].compare(card)) {
               tmp[currentTmpNum++] = myCards[i];
           }
        }
        return tmp;
    }
    
    
    private Card[] doubleArray(Card[] cards){
        Card[] tmpCards = new Card[cards.length*2];
        
        for (int i = 0; i< cards.length; i++){
            tmpCards[i] = cards[i];
        }
        
        return tmpCards;  
    }
    
    
    
    
    // 理牌
    private void sortMyCard() {
       for(int i=0; i< myCards.length-1;i++){
           if (myCards[i] == null) {
               Card tmp = myCards[i];
               myCards[i] = myCards[i+1];
               myCards[i+1] = tmp;
           }
       }
    }
           
 
}

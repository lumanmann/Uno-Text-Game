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
public class Cards {
    // 分四種顏色：紅色、綠色、藍色及黃色
    // 0牌有一張，1-9有兩張
    // 76張
    private static final int CARD_NUM = 76;
    private Card[] cards;
    private int currentCardIndex;
  
    public Cards(){
        cards = new Card[CARD_NUM];
        resetCard();
        
    }

    // getter
    public Card getCards(int i) {
        return cards[i];
    }
    public int getCurrentCardIndex() {
        return this.currentCardIndex;
    }
    public int getCARD_NUM() {
        return Cards.CARD_NUM;
    }
    
    // 將cards中的順序洗亂
    public void shuffle() {
        for(int i=0; i<CARD_NUM; i++){
            int targetIndex = (int)(Math.random()*CARD_NUM);
            // 把位置i 跟 位置targetIndex 的牌交換
            Card tmpCard = this.cards[i];
            this.cards[i] = this.cards[targetIndex];
            this.cards[targetIndex] = tmpCard;
        }
       
    }
    
    // 發出一張牌(第二次呼叫deal將發第二張 第三次呼叫發第三張 以此類推)
    public Card deal(){
        return cards[currentCardIndex++];
    }
    
    // 將cards還原到初始模樣(deal刷新回到第一張 順序還原)
    private void resetCard(){
        for(int i = 0; i <CARD_NUM; i++){
            String color = Card.setColor(i/(CARD_NUM/Card.CARD_COLORS.length));
            int point = i%(CARD_NUM/Card.CARD_COLORS.length) + 1;
            this.cards[i] = new Card(color, point%10);
        }
        this.currentCardIndex = 0;
    }
    
    private Card[] doubleArray(Card[] cards){
        Card[] tmpCards = new Card[cards.length*2];
        
        for (int i = 0; i< cards.length; i++){
            tmpCards[i] = cards[i];
        }
        
        return tmpCards;  
    }
    
    @Override
    public String toString() {
        String tmp = "";
        for (Card card : cards) {
            tmp += card.toString() + " ";
        }
        return tmp;
    }
    
}

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
public class Card {
    public static final String CARD_COLORS[] = new String[]{"紅色", "綠色", "藍色", "黃色"};
    private String color;
    private int point;
    
    // constructor
    public Card(String color, int point) {
        this.color = color;
        this.point = point;
    }
    
    // getter
    public String getColor() {
        return color;
    }

    
    public int getPoint() {
        return point;
    }
    
    public String getDetails(){
        return this.color + this.point;
    }
    
    public boolean compare(Card card){
        // 顏色
        String selfColor = this.getColor();
        String otherColor = card.getColor();
        // 數字
        int selfPoint = this.getPoint();
        int otherPoint = card.getPoint();
        
        return (selfColor.equals(otherColor) || selfPoint == otherPoint);
        
    }
    
     public boolean equals(Card card){
        // 顏色
        String selfColor = this.getColor();
        String otherColor = card.getColor();
        // 數字
        int selfPoint = this.getPoint();
        int otherPoint = card.getPoint();
        
        return selfColor.equals(otherColor) && selfPoint == otherPoint;
    }
     
     public static String setColor(int serial) {
         return Card.CARD_COLORS[serial];
     }
     
    
      @Override 
      public String toString() {
         return this.getColor() + this.getPoint();
           
     }
    
    
}

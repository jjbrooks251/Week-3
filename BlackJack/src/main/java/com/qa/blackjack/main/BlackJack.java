package com.qa.blackjack.main;

public class BlackJack {

		public static void main(String[] args) {
					
			
			
		}
		
		public String play(int player, int dealer) {
			
//			if (player <16 && player >3) {
//			System.out.print(player);
//			do {
//				player = twist(player);
//				System.out.print(player);
//			} while(player <16 && player>3);
//			System.out.println(" New player is " + player);
//		}
						
			if (player <4 || dealer < 4) {
				return "Invalid";
			} else if (player >30 || dealer >30) {
				return "Invalid";
			} else if (dealer <16 && dealer >3){
			System.out.print(dealer + " ");
				do {
					dealer = twist(dealer);
					System.out.print(dealer + " ");
				} while(dealer <16);
				
			System.out.println(" New dealer is " + dealer);
				return newPlay(player, dealer);
			} else 
				return newPlay(player, dealer);
					
		}
		
		public String newPlay(int player, int dealer) {
			
			if (player >21 && dealer >21 && player <31 && dealer <31) {
				return "both bust";	
			}else if (player > dealer || dealer > 21 && dealer<=30) {
				return "player";										
			} else 
				return "dealer";			
		}
		
		public int twist(int value) {
			int card = ((int)(Math.random()*10) + 2);
		
			value = value + card;
			
			if (card == 11 && value >21) {
				value = value - 10;
			}						
			return value;
		}
		
		
	

	
}

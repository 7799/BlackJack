package BlackJack;
//GPL

public class BJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0 or Enter.\tカードを一枚めってみよう！");
		System.out.println("1.\t\t勝負！");

		System.out.println();
		Deal d = new Deal();		//カードを配る
		Play p = new Play();		//ゲーム開始
		
		d.shaffle();
//		d.initHands();
		d.hands();
		p.play();
	}
}

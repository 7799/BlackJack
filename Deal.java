package BlackJack;

public class Deal extends Cards {
static 	 int h=7;				//手札の数の最大
static 	 int[] player = new int[h];		//playerの手札の配列
static 	 int[] com = new int[h];		//Computerの手札の配列
static 	 int P = 0;				// player's array number
static 	 int C = 0;
 	 char x;				//playerかcomputerかを区別するための引数

	void flip(char x) {			//カードを一枚めくる
						//引数cならComputer、pならPlayer
		if (MAX < h*2)
			shaffle();
		for (int i = 0; i < 1; i++) {
			int n = (int) (Math.random() * 52) + 1;
			if (cards[n] != 99) {		//しるしとして99を代入してある
				if (x == 'p') {
					player[P] = n;
					P++;
				}
				if (x == 'c') {
					com[C] = n;
					C++;
				}
				cards[n] = 99;	//しるしとして99を代入
				MAX--;
			} else
				i--;
		}
	}

	void hands() {				// 最初にカードを配る
		flip('c');
		flip('p');
		flip('c');
		info();
	}

	void shaffle() {			// カードセットの シャッフル
		System.out.println("カードをシャッフルします");
		MAX = 52;
		cards_m();
	}

	void yourHand() {
		for (int b = 0; b < player.length; b++) {
			if (player[b] != 0)
				System.out.print(cards_m[player[b]] + " ");
		}
		System.out.println();
	}
	void comHand() {
		for (int b = 0; b < com.length; b++) {
			if (com[b] != 0)
				System.out.print(cards_m[com[b]] + " ");
		}
		System.out.println();
	}

	void comHand(int i) {
		for (int b = 0; b < i; b++) {
			if (com[b] != 0)
				System.out.print(cards_m[com[b]] + " ");
		}
		System.out.println();
	}

	void initHands() {			// 手札の初期化
		for (int i = 0; i < player.length; i++) {
			player[i] = 0;
			com[i] = 0;
			P = 0;
			C = 0;
		}
	}

	int cal(char i) {			//手札の計算
		int[] n = player;
		if (i == 'c')			//'c' for computer
			n = com;
		if (i == 'p')			//'p' for player
			n = player;

		int p = 0;
		for (int d : n) {
			if (d == 0)
				p += 0;
			if (d >= 1 && d <= 9)
				p += d;
			if (d >= 10 && d <= 13)
				p += 10;
			if (d >= 14 && d <= 22)
				p += d - RANK;
			if (d >= 23 && d <= 26)
				p += 10;
			if (d >= 27 && d <= 35)
				p += d - RANK * 2;
			if (d >= 36 && d <= 39)
				p += 10;
			if (d >= 40 && d <= 48)
				p += d - RANK * 3;
			if (d >= 49 && d <= 52)
				p += 10;
		}
		return p;
	}

	void info() { // 各種情報の表示。 デバックを兼ねる
	// comment the lines out which you like to know about.
//	 show();
//	 show_s();
//	 System.out.println();
//	 System.out.println("残りカード= " + MAX);
//	 System.out.println();

		System.out.print("PCの手 ");
		comHand(1); // 親は一枚目のカードだけ見せる
		System.out.print("あなたの手 ");
		yourHand(); //子の手札に因数はない

		System.out.println("あなたのカードの合計= " + cal('p')); // you
	}

}

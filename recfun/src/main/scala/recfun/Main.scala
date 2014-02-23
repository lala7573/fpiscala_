package recfun
import common._

object Main {
	def main(args: Array[String]) {
		println("countChange")
		println(countChange(300,List(500,5,50,100,20,200,10)))

		//		println("Pascal's Triangle")
		//		for (row <- 0 to 10) {
		//			for (col <- 0 to row)
		//				print(pascal(col, row) + " ")
		//				println()
		//		}
	}

	/**
	 * Exercise 1
	 * r = 0 : 1
	 * r = 1 : 1 1
	 * f = 2 : 1 2 1
	 * r = 3 : 1 3 3 1
	 * r = 4 : 1 4 6 4 1
	 */
	def pascal(c: Int, r: Int): Int = {
			if ( r == 0 || c == 0 || r == c) 1
			else pascal(c-1, r-1) + pascal(c, r-1);
	}

	/**
	 * Exercise 2
	 */
	def balance(chars: List[Char]): Boolean = {
			def findEnd(char: List[Char], check: Int) : Int = {
					if( char.isEmpty || check < 0) check
					else {
						if(char.head.equals('(')) findEnd(char.tail, check + 1)
						else if(char.head.equals(')')) findEnd(char.tail, check - 1)
						else findEnd(char.tail, check)
					}
			}

			if( findEnd(chars, 0) == 0 ) true
			else false
	}


	/**
	 * Exercise 3
	 * 4 [1,2]
	 * 1+1+1+1 1+1+2 2+2
	 */
	def countChange(money: Int, coins: List[Int]): Int = {
			def count(rest: Int, coin: List[Int]): Int = {
					if(rest == 0) 1
					else if(rest < 0) 0
					else if(coin.isEmpty && rest>=1 ) 0
					else count(rest, coin.tail) + count(rest - coin.head, coin)
			}

			count(money, coins.sorted)
	}

}

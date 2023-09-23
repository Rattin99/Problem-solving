mod buy_sell_stock2;

use buy_sell_stock2::max_profit;

fn main() {
   let prices = vec![1,9,6,9,1,7,1,1,5,9,9,9];
   let answer = max_profit(prices);

   println!("{}",answer);
}

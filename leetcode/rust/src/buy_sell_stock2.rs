


pub fn max_profit(prices: Vec<i32>) -> i32 {

    let mut max_profit = 0;
    let mut current = 0;

    for i in 1..prices.len()  {
        if prices[i] < prices[i-1] {
            max_profit += prices[i-1] - prices[current];
            current = i; 
        }

        if prices[i] >= prices[i-1] && i == prices.len() -1 {
            max_profit += prices[i] - prices[current];
        }

    }

    return max_profit;
}

pub fn max_profit_simpler(prices: Vec<i32>) -> i32 {
    let mut max_profit = 0;

    for i in 1..prices.len()  {
        let profit = prices[i] - prices[i-1];

        if profit > 0 {
            max_profit += profit;
        }
    }

    return max_profit;
}
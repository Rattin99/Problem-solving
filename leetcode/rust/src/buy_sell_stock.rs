use std::cmp::{max,min};

pub fn max_profit(prices: Vec<i32>) -> i32 {

    let mut most = 0;

    let s = prices.len() as i32;

    for i in 0..s {
        
        let ip = i.clone() + 1;

        for j in ip..s {

            let profit = prices[j as usize] - prices[i as usize];

            if profit > most {
                most = profit
            }
        }
    }

    return most;
    
}


pub fn max_profit_better(prices: Vec<i32>) -> i32 {
    let mut left = 0;
    let mut right = 1;
    let mut max_profit = 0;

    while right < prices.len() {

        let pr = prices[right];
        let pl = prices[left];

        if pl < pr {

            let profit = pr - pl;

            if profit > max_profit {
                max_profit = profit;
            }
        }

        if pl > pr {
            left = right;
        }

        println!("{} {}",pl,pr);

        right += 1;

    }

    return  max_profit;
}


pub fn max_profit_even_better(prices: Vec<i32>) -> i32 {

    let length = prices.len();

    let mut dp = vec![]; 
    dp.push(0);

    let mut min_price = prices[0];

    if length as i32 <= 1 {
        return 0
    }

    for i in 1..length {
        dp.push(max(dp[i -1], prices[i] - min_price));
        min_price = min(min_price, prices[i]);

    }


    return dp[length -1];

}


pub fn max_profit_even_faster(prices: Vec<i32>) -> i32 {
    
    let mut min_price = prices[0];
    let mut maxprofit = 0;

    let length = prices.len();

    for i in 1..length {
        if prices[i] < min_price {
            min_price = prices[i];
        }else if prices[i] - min_price > maxprofit {
            maxprofit = prices[i] - min_price
        }
    }

    if length <=1 {
        return 0;
    }

    return maxprofit;
}
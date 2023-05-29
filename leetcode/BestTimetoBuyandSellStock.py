

def maxProfit(prices):
    max = 0
    min_price = float('inf')
    
    left = 0
    right = len(prices) -1
    
    for i in prices:
        
        if(i < min_price):
            min_price = i
        
        if(i - min_price > max):
            max = i - min_price
       
    
    return max   
        
        
print(maxProfit([2,1,4]))
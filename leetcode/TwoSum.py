

def twosum(nums,target):
    
    numdict = {}
    
    for i in range(0,len(nums)):
        diff = target - nums[i]
        
        if diff in numdict:
            return [numdict[diff],i]
        
        numdict[nums[i]] = i
    
    

print(twosum([3,2,4],6))



def threesumClosest(nums,target):
    diff = target
    ans = 0
    nums.sort()
    
    for i in range(len(nums)):
        
        if(i > 0):
            if(nums[i] == nums[i-1]):
                continue
    
        start = i+1
        end = len(nums) - 1
        
        while(start < end):
            
            add = nums[i] + nums[start] + nums[end]
            d = target - abs(add)
            
            print([nums[i], nums[start],nums[end]])
            
            if(diff <= d):
                ans = add
                start += 1
                
            
            elif(diff > d):
                diff = d
                end -= 1
    
    return ans


print(threesumClosest([0,1,2],3))
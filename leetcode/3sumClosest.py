def threesumClosest(nums,target):
    ans = nums[0] + nums[1] + nums[len(nums) - 1]
    nums.sort()
    
    for i in range(len(nums)):
    
        start = i+1
        end = len(nums) - 1
        
        while(start < end):
            
            add = nums[i] + nums[start] + nums[end]
            
            if(add > target):
                end -= 1
            
            else:
                start += 1
                
            if(abs(add - target) < abs(ans - target)):
                ans = add
    
    return ans


print(threesumClosest([0,1,2],3))
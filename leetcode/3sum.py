def threesum(nums):
    ans = []
    nums.sort()
    
    for i in range(len(nums)):
        
        if(i > 0):
            if(nums[i] == nums[i-1]):
                continue
    
        start = i+1
        end = len(nums) - 1
        
        while(start < end):
            
            add = nums[i] + nums[start] + nums[end]
            
            if(add == 0):
                ans.append([nums[i],nums[start],nums[end]])
                start += 1
                while nums[start] == nums[start - 1] and start < end:
                    start += 1
            
            elif(add < 0):
                start = start + 1
            
            elif(add > 0):
                end = end - 1
    
    return ans
    

print(threesum([-1,0,1,2,-1,-4]))
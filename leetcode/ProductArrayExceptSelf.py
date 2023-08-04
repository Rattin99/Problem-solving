
def productExceptSelf(nums):
    
    newArray = []
    newArray.append(1)
    for i in range(1,len(nums)):
        n = nums[i-1] * newArray[i-1]
        newArray.append(n)
    
    
    i = len(nums) - 2
    suffix = nums[i+1]

    
    while(i > 0):
        print(suffix)
        newArray[i] = suffix*newArray[i-1]
        suffix = suffix*nums[i]
        
        
        i -= 1
    
    newArray[0] = suffix
    print(newArray)
        

productExceptSelf([1,2,3,4])
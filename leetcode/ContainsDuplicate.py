
def containsDuplicate(nums):
    
    lengthBefore = len(nums)
    
    newset = set(nums)
    
    lengthAfter = len(newset)
    
    if(lengthBefore > lengthAfter):
        return True
    
    else:
        return False
    


containsDuplicate([1,1,3,3,4,5])
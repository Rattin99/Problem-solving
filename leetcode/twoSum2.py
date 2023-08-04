def twoSum(numbers,target):
   start = 0
   end = len(numbers) - 1
   
   while(end > start):
       add = numbers[start] + numbers[end]
       if(add == target):
           return [start,end]
       
       if(add > target):
           end = end - 1
       
       if(add < target):
           start = start + 1
           
           
    


print(twoSum([2,7,11,15],9))    
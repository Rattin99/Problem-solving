

def lengthofLIS(nums):
    LIS = [1]*len(nums)

    for i in range(len(nums) - 1, -1, -1):
        for j in range(i+1, len(nums)):
            if nums[i] < nums[j]:
                LIS[i] = max(LIS[i], 1+LIS[j])

    return max(LIS)


print(lengthofLIS([4, 10, 4, 3, 8, 9]))

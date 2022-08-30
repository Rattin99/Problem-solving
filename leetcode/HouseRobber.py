# 198. House Robber
# medium #dp


def rob(nums):
    arr = [0 for x in nums]

    if(len(nums) < 2):
        return nums[0]
    if(len(nums) == 2):
        return max(nums[0], nums[1])
    arr[0] = nums[0]
    arr[1] = nums[1]
    for i in range(2, len(nums)):
        if(nums[i]+arr[i-2] > arr[i-1]):
            arr[i] = nums[i] + arr[i-2]
        else:
            arr[i] = arr[i-1]

    return arr[-1]


def rob2(nums):
    take, nottake = 0, 0

    for index in range(len(nums)):
        take, nottake = nottake + nums[index], max(take, nottake)

    return max(take, nottake)


print(rob2([7, 8, 9, 10, 11, 12]))

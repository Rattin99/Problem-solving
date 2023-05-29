


def maxArea(heights):
    left = 0
    right = len(heights) - 1
    maxArea = 0
    
    while(left < right):
        height = min(heights[left],heights[right])
        width = right - left
        
        if(height*width > maxArea):
            print()
            maxArea = height*width
        
        if(heights[left] > heights[right]):
            right -= 1
        if(heights[right] >= heights[left]):
            left += 1

    return maxArea


print(maxArea([1,8,100,2,100,4,8,3,7]))
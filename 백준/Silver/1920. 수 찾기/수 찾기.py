N = int(input())

nums = list(map(int, input().split()))

M = int(input())

targets = list(map(int, input().split()))

nums.sort()

for target in targets:
    st = 0
    end = N - 1
    answer = 0
    while st <= end:
        mid = (end + st)//2
        if target > nums[mid]:
            st = mid + 1
        elif target < nums[mid]:
            end = mid - 1
        else:
            answer = 1
            break
    print(answer)
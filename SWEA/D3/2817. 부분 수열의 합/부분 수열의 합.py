TC = int(input())

def backTracking(total, idx, nums):
    global answer
    global target
    if total == target:
        answer += 1
        return
    if total > target:
        return
    for i in range(idx + 1, len(nums)):
        backTracking(total + nums[i], i, nums)

for tc in range(TC):
    n, target = map(int, input().split())
    nums = list(map(int, input().split()))
    answer = 0
    for i in range(n):
        backTracking(nums[i], i, nums)
    print(f'#{tc + 1} {answer}')
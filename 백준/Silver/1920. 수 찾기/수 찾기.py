N = int(input())

nums = list(map(int, input().split()))

nums.sort()

M = int(input())

searchNums = list(map(int, input().split()))


def binSearch(target):
    st = 0
    en = N - 1

    while st <= en:
        mid = (st + en) // 2
        if nums[mid] == target:
            return 1
        elif nums[mid] < target:
            st = mid + 1
        elif nums[mid] > target:
            en = mid - 1
    return 0

for target in searchNums:
    print(binSearch(target))
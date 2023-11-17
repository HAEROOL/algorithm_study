def solution(nums):
    answer = 0
    pokes = set(nums)
    if len(nums) / 2 > len(pokes):
        return len(pokes)
    else: return len(nums) / 2
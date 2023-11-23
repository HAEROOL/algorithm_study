def solution(stones, k):
    answer = 0
    length = len(stones)
    stone_set = sorted(set(stones))
    i, j = stone_set[0], stone_set[-1]

    while i <= j:
        mid = (i+j) // 2
        candits, cnt = [], 0
        for idx in range(length):
            if stones[idx] <= mid:
                cnt += 1
            else:
                candits.append(cnt)
                cnt = 0
        else:
            candits.append(cnt)
            max_con = max(candits)

        if max_con < k:
            i = mid+1
        else:
            answer = mid
            j = mid-1          

    return answer
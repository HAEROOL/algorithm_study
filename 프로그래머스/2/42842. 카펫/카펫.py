def solution(a,b):
    brown = a
    yellow = b
    S = brown + yellow
    ans = [0, 0]
    for width in range(1, S + 1):
        if S % width != 0:
            continue
        height = S / width
        y = (width - 2) * (height - 2)
        b = S - y
        if y == yellow and b == brown:
            ans[0] = width
            ans[1] = height
    return ans
        
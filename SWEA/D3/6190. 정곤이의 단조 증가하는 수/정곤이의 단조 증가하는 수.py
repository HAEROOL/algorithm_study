T = int(input())

for tc in range(T):
    n = int(input())
    nums = list(map(int, input().split()))
    answer = -1
    for i in range(n - 1):
        for j in range(i + 1, n):
            ai = nums[i]
            aj = nums[j]
            num = str(ai * aj)
            arr = list(map(int, list(num)))
            isRight = True
            for x in range(0, len(arr) - 1):
                if arr[x] > arr[x + 1]:
                    isRight = False
                    break
            if isRight:
                answer = max(answer, int(''.join(num)))
    print(f'#{tc + 1} {answer}')
            
for _ in range(10):
    tc = int(input())
    n, m = map(int, input().split())
    def recursive(depth, num):
        if depth == m:
            print(f'#{tc} {num}')
            return
        recursive(depth + 1, num * n)
    
    recursive(0, 1)
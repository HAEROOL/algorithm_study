A, B, C = map(int, input().split())

def solve(a, n):
    if n == 1:
        return A % C
    else:
        tmp = solve(a, n//2)
        if n % 2 == 0:
            return (tmp * tmp) % C
        else:
            return (tmp * tmp * A) % C

print(solve(A, B))
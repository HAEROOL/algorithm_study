N = int(input())

def hanoi(num, from_, to, other):
    if num == 0:
        return
    hanoi(num-1, from_, other, to)
    print(from_, to)
    hanoi(num-1, other, to, from_)

print(2 ** N - 1)
hanoi(N, 1, 3, 2)
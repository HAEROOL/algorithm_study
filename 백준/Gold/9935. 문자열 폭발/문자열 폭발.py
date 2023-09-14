import sys
S = sys.stdin.readline().rstrip()
explosionString = sys.stdin.readline().rstrip()

stack = []
m = len(explosionString)

for i in range(len(S)):
    stack.append(S[i])
    if ''.join(stack[-m:]) == explosionString:
        for _ in range(m):
            stack.pop()

if stack:
    print(''.join(stack))
else:
    print('FRULA')
def solution(s):
    answer = True
    stack = []

    for x in list(s):
        if x == '(':
            stack.append('(')
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    return True if len(stack) == 0 else False
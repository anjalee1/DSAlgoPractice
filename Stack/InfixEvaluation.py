from collections import deque
def precedence(character):
    if character=='-' or character== '+':
        return 1
    elif character== '*' or character=='/':
       return 2


def operation(val1,val2,operator):
    if(operator=='+'):
        return val1+val2

    elif(operator=='-'):
        return val1-val2

    elif(operator=='*'):
        return val1*val2

    elif(operator=='/'):
        return val1/val2



def infix(exp):
    operators=deque()
    operands=deque()
    for char in exp:
        if char=='(':
            operators.append(char)
        elif char.isdigit():
            operands.append(int(char))
        elif char=='+' or char=='-' or char=='*' or char =='/':
            while len(operators)>0 and operators[-1]!='(' and precedence(char)<=precedence(operators[-1]):
                val2 = operands.pop()
                val1 = operands.pop()
                op =  operators.pop()
                opval = operation(val1, val2, op)
                operands.append(opval)
            operators.append(char);
        elif char==')':
            while len(operators)>0 and operators[-1]!='(':
                val2 = operands.pop()
                val1 = operands.pop()
                op =  operators.pop()
                opval = operation(val1, val2, op)
                operands.append(opval)
            if len(operators)>0:
                operators.pop()
        


    while len(operators)>0:
        val2 = operands.pop()
        val1 = operands.pop()
        op =  operators.pop()
        opval = operation(val1, val2, op)
        operands.append(opval)
    
    val=operands.pop()
    print(round(val))
    



    
exp = input()
exp = exp.replace(" ", "")


infix(exp)

# i/p test case
# 2 + 6 * 4 / 8 - 3

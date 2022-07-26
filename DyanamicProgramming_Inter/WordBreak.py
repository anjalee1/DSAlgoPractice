
def WordBreak(sentence,dictionary):
    dp=[0]*len(sentence)
    for i in range(0,len(dp)):
        for j in range(0,i+1):
            if sentence[j:i+1] in dictionary:
                if j>0:
                    dp[i] += dp[j-1]
                else:
                    dp[i] += 1


    return dp[len(sentence)-1]>0

def main():
    n=int(input())
    dictionary= input()
    sentence=input()
    if WordBreak(sentence,dictionary):
        print("true")
    else:
        print("false")

if __name__ == "__main__":
    main()

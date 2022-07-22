
import sys

def minPalindromicCut(string):
    n = len(string)
    dp = [[False for col in range(n)] for row in range(n)]
    for gap in range(0, n):
        si = 0
        ei = gap
        while ei < n:
            if gap == 0:
                dp[si][ei] = True
            elif gap == 1:
                if string[si] == string[ei]:
                    dp[si][ei] = True
                else:
                    dp[si][ei] = False
            else:
                if string[si] == string[ei]:
                    dp[si][ei] = dp[si + 1][ei - 1]
                else:
                    dp[si][ei] = False
            si = si + 1
            ei = ei + 1

    cuts = [0] * n
    for i in range(0, n):
        if dp[0][i] == True:
            cuts[i] = 0
        else:
            cuts[i] = sys.maxsize
            for j in range(0, i):
                if (dp[j + 1][i] == True) and (1 + cuts[j] < cuts[i]):
                    cuts[i] = 1 + cuts[j]
    return cuts[n - 1]

def main():
    string = input()
    print(minPalindromicCut(string))

if __name__ == "__main__":
    main()

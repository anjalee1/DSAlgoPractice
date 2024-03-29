def findNthRoot(x, n):

	# Initialize boundary values
	x = float(x)
	n = int(n)
	#If x lies in the range [0, 1) then we set the lower limit low = x and upper limit high = 1, because for this range of numbers the
       #nth root is always greater than the given number and can never exceed 1.

	if (x >= 0 and x <= 1):
		low = x
		high = 1
	else:
		low = 1
		high = x

	# used for taking approximations
	# of the answer
	epsilon = 0.01

	# Do binary search
	guess = (low + high) / 2
	while abs(guess ** n - x) >= epsilon:
		if guess ** n > x:
			high = guess
		else:
			low = guess
		guess = low+(high-low) / 2
	print(guess)


# Driver code
x = 5
n = 2
findNthRoot(x, n)

# Tc=>n*log(x*(10^d))
# Here d = number of decimals upto which we want accuracy
#so for ablove code d is 2 (see epsilon value)
#https://www.geeksforgeeks.org/calculating-n-th-real-root-using-binary-search/
#https://www.youtube.com/watch?v=WjpswYrS2nY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=64

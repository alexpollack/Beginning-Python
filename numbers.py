pos = 0
neg = 0
sumNum = 0
iterit = 0

number = int(input("Enter any integer value, or 0 to quit: "))
if number != 0:
    if number > 0:
        pos = pos + 1
    elif number < 0:
        neg = neg + 1
    sumNum = sumNum + number
    while number != 0:
        number = int(input("Enter any integer value, or 0 to quit: "))
        if number > 0:
            pos = pos + 1
        elif number < 0:
            neg = neg + 1
        sumNum = sumNum + number
        iterit = iterit + 1
    av = sumNum / iterit
    print("\n# of positives = ",pos)
    print("# of negatives = ",neg)
    print("The sum is = ", sumNum)
    print("The average is = ",round(av,2))
else:
    print("\n# of positives = ",pos)
    print("# of negatives = ",neg)
    print("The sum is = ", sumNum)
    print("The average is = 0.00")
    

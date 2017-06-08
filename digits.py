numstring = 1
summ = 0
i = 0
j = 1
while numstring != 0:
    numstring = input("Please enter an integer (0 to quit): ")
    if int(numstring) > 0:
        for i in range(0,len(numstring)):
                summ = summ + int(numstring[i])
        print("\nThe sum of the digits of ",numstring," is ",summ,"\n")
    elif int(numstring) < 0:
        for j in range(1,len(numstring)):
                summ = summ + abs(int(numstring[j]))
        print("\nThe sum of the digits of ",numstring," is ",summ,"\n")
    else:
        break
    summ = 0
print("\nGoodbye")

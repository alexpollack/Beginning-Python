print("----Coin Game----")
start = input("Would you like to play? (y or n) --> ")
if start == 'n':
    print("Guess you're scared! Come back when you're ready to play!")
elif start == 'y':
    amount = float(input("What amount of $ would you like to match? --> "))
    print("Okay! You need to match the value of $", amount)
    print("Enter number of:")
    halfDollar = int(input("\tHalf Dollars: "))
    quarter = int(input("\tQuarters: "))
    dime = int(input("\tDimes: "))
    nickle = int(input("\tNickles: "))
    penny = int(input("\tPennies: "))
    total = penny*0.01+nickle*0.05+dime*0.10+quarter*0.25+halfDollar*0.50
    if total == amount:
        print("You WIN!\nSee you next time!")
    elif penny < 0 or nickle < 0 or dime < 0 or quarter < 0 or halfDollar < 0:
        print("You can't enter a negative amount of coins. Aborting game.")
    else:
        diff = abs(total - amount)
        print("You LOST by: $", diff)
        print("See you next time!")
    

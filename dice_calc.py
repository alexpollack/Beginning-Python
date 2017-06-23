import random
two = 0
seven = 0
twelve = 0

print("Welcome to the dice stats calculators!")
print("Lets us know how many times to roll the dice!")
print("Enter 0 whenever you're ready to quit.\n")

num_roll = int(input("How many times should we roll the dice?\n> "))
if num_roll != 0:
    while(num_roll != 0):
        if num_roll > 0:
            print("Rolling dice ",num_roll," times...")
            for i in range(0,num_roll):
                die1 = random.randrange(1,7)
                die2 = random.randrange(1,7)
                total = die1 + die2
                if total == 2:
                    two = two + 1
                elif total == 7:
                    seven = seven + 1
                elif total == 12:
                    twelve = twelve + 1
            percen2 = (two/num_roll)*100
            percen7 = (seven/num_roll)*100
            percen12 = (twelve/num_roll)*100
            print("A roll of 2 appeared ",two,
                  " total times, %0.2f"% percen2,"% of the time")
            print("A roll of 7 appeared ",seven,
                  " total times, %0.2f"% percen7, "% of the time")
            print("A roll of 12 appeared ",twelve,
                  " total times, %0.2f"% percen12,"% of the time\n\n")
        elif num_roll < 0:
            print("Cannot roll dice a negative number of times.\n")
        two = 0
        seven = 0
        twelve = 0
        num_roll = int(input("How many times should we roll the dice?\n> "))
        if num_roll == 0:
            print("See ya!")
else:
    print("See ya!")






    

month = int(input("Enter a month (1-12): "))
year = int(input("Enter a year: "))
days = 0
if month > 12 or month < 1 :
    print("\nInvalid Month entered. Aborting Program.")
else:
    if month == 1:
        days = 31
    elif month == 2:
        if year % 4 == 0:
            days = 29
        else:
            days = 28
    elif month == 3:
        days = 31
    elif month == 4:
        days = 30
    elif month == 5:
        day = 31
    elif month == 6:
        days = 30
    elif month == 7:
        days = 31
    elif month == 8:
        days = 31
    elif month == 9:
        days = 30
    elif month == 10:
        days = 31
    elif month == 11:
        days = 30
    elif month == 12:
        days = 31
    print("\nNumber of days: ",days)

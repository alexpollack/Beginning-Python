#return the first repeated element in a list
def firstrep(L):
    for x in range(len(L)):
        for y in range(x+1,len(L)):
            if y != x:
                if L[x] == L[y]:
                    print(L[x])

#return the first element that does not repeat in a list
def norep(list1):
    unlist = []
    for x in list1:
        if x not in unlist:
            unlist.append(x)
    print(unlist[0])

#return list with no repeating values
def unique(list1):
	unlist = []
	for x in list1:
		if x not in unlist:
			unlist.append(x)
	for x in unlist:
		print(x)

#return all factors of a number
def factors(number):
    i = 2
    factors = [1]
    while i <= number:
        if float(number/i).is_integer():
            factors.append(i)
        i += 1
    print("Factors:", factors)


#swap vowels in a phrase
def vowelswap(phrase):
    vowels = ['a','e','i','o','u']
    spots = []
    fin = ""
    rspot = ''
    for x in phrase:
        for y in vowels:
            if x == y:
                spots.append(x)
    print(spots)
    rs = spots
    rs.reverse()
    rspot = rspot.join(rs)
    spots.reverse()
    print(rspot)
    for x in range(len(phrase)):
        for y in range(len(spots)):
            if phrase[x] not in vowels and phrase[x] not in fin:
                fin = fin + phrase[x]
            elif phrase[x] == spots[y]:
                fin = fin + rspot[y]
            elif phrase[x] == ' ':
                fin = fin + ' '
    print(fin)
        







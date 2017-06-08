print("Welcome to Paint Calculator 2017!!\n")
width = float(input("How wide is each wall in the room (in feet)? "))
height = float(input("and how high is each wall in the room? "))
windowWidth = float(input("How wide is the window (in feet)? "))
windowHeight = float(input("and what is the window's height? "))

area = 4.0*(width * height) - (windowWidth * windowHeight)
cans = area/300.0
print("\nA room where each wall is")
print("\t",width,"' wide and\n\t",height,"' tall and")
print("\tcontaining a window that is")
print("\t",windowWidth,"' wide and\n\t",windowHeight,"' tall,")
print("has ",area," square feet of paintable wall\n")
print("and would reqire ", cans," cans of paint")
print(" (assuming that each can will cover 300 square feet of wall")
print("\nThanks for using Paint Calculator 2017. Goodbye!")


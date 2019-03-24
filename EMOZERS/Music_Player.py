import random
import playsound
index=int(random.randint(0,8))
pathnamehappy =['C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Adagio For Strings Samuel Barber Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Beatles - All You Need Is Love Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Bob Marley & The Wailers - Three Little Birds Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Clair De Lune.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Explosions In The Sky - First Breath After Coma Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\James Brown - I Got You(i Feel Good) Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Katrina & The Waves - Walking On Sunshine Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Pharrell Williams - Happy Listen & Download.MP3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\What A Wonderful World Listen & Download.mp3']
songnamehappy =['Adagio For Strings Samuel Barber','Beatles - All You Need Is Love','Bob Marley & The Wailers - Three Little Birds','Clair De Lune','Explosions In The Sky - First Breath After Coma','James Brown - I Got You(i Feel Good)','Katrina & The Waves - Walking On Sunshine','Pharrell Williams - Happy Listen','What A Wonderful World Listen']
print("Now Playing - %s" %songnamehappy[index])
playsound.playsound(pathnamehappy[index], True)


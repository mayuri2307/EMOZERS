import random
import playsound
songname= ''
index=int(random.randint(0,7))
mood='neutral'
pathnameuplifting =['C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\Adele - Someone Like You Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\All Saints - Pure Shores Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\Barcelona - Please Dont Go Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\Coldplay - Strawberry Swing Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\dj-shah-mellomaniac-chillout-mix-best-chillout-music-series[mp3-gratis.eu - Download Free Mp3 Music].mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\Hans Zimmer - Pandora. Study Music..mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\Marconi Union - Weightless Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Uplifting\\Mozart - Canzonetta Sull Aria Listen & Download.mp3']
pathnamehappy =['C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Adagio For Strings Samuel Barber Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Beatles - All You Need Is Love Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Bob Marley & The Wailers - Three Little Birds Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Clair De Lune.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Explosions In The Sky - First Breath After Coma Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\James Brown - I Got You(i Feel Good) Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Katrina & The Waves - Walking On Sunshine Listen & Download.mp3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\Pharrell Williams - Happy Listen & Download.MP3','C:\\Users\\Siddharth\\Music\\Emozers-Music\\Happy\\What A Wonderful World Listen & Download.mp3']
songnamehappy =['Adagio For Strings Samuel Barber','Beatles - All You Need Is Love','Bob Marley & The Wailers - Three Little Birds','Clair De Lune','Explosions In The Sky - First Breath After Coma','James Brown - I Got You(i Feel Good)','Katrina & The Waves - Walking On Sunshine','Pharrell Williams - Happy Listen','What A Wonderful World Listen']
songnameuplifting =['Adele - Someone Like You','All Saints - Pure Shores','Barcelona - Please Dont Go Listen','Coldplay - Strawberry Swing','mellomaniac-chillout-mix','Hans Zimmer - Pandora','Marconi Union - Weightless','Mozart - Canzonetta Sull Aria','Rupert Holmes - (Escape) The Pina Colada Song']

if(mood=='happy'):
  songname = songnamehappy[index]
  print("Now Playing - %s" % songname)
  playsound.playsound(pathnamehappy[index], True)
elif(mood=='sad'):
  songname = songnameuplifting[index]
  print("Now Playing - %s" % songname)
  playsound.playsound(pathnameuplifting[index], True)
elif(mood=='fear'):
  songname = songnameuplifting[index]
  print("Now Playing - %s" % songname)
  playsound.playsound(pathnameuplifting[index], True)
elif (mood == 'anger'):
  songname = songnamehappy[index]
  print("Now Playing - %s" % songname)
  playsound.playsound(pathnamehappy[index], True)
elif (mood == 'surprise'):
  songname = songnamehappy[index]
  print("Now Playing - %s" % songname)
  playsound.playsound(pathnamehappy[index], True)
elif(mood=='disgust'):
  songname = songnameuplifting[index]
  print("Now Playing - %s" % songname)
  playsound.playsound(pathnameuplifting[index], True)
elif (mood == 'neutral'):
  songname = songnamehappy[index]
  print("Now Playing - %s" % songname)
  playsound.playsound(pathnamehappy[index], True)


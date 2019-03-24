import random
import playsound
index=int(random.randint(0,3))
flag=0
pathnameuplifting=[]
pathnamehappy =['C:\\Users\\Siddharth\\Music\\The Beatles - 1 (Greatest Hits) [2000] [320 kbps]\\Love me do.mp3','C:\\Users\\Siddharth\\Music\\The Beatles - 1 (Greatest Hits) [2000] [320 kbps]\\03. She Loves You - Beatles.mp3','C:\\Users\\Siddharth\\Music\\The Beatles - 1 (Greatest Hits) [2000] [320 kbps]\\06. A Hard Days Night - Beatles.mp3','C:\\Users\\Siddharth\\Music\\The Beatles - 1 (Greatest Hits) [2000] [320 kbps]\\08. Eight Days a Week - Beatles.mp3']
playsound.playsound(pathnamehappy[index], True)
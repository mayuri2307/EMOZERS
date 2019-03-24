#import http.client, urllib.request, urllib.parse, urllib.error, base64, sys, json,render_template
#import httplib
import http.client, urllib.request, urllib.parse, urllib.error, base64, sys, json
import cv2
import playsound
import random
import time
import sys
import os
headers = {
    # Request headers. Replace the placeholder key below with your subscription key.
    'Content-Type': 'application/octet-stream',
    'Ocp-Apim-Subscription-Key': '3ca09e70d6b64cd4a050b343bcd43dc5',
}

params = urllib.parse.urlencode({
})
flag=0
mood='neutral'
def dataa(mood1):
    global flag
    f = open('trendingmoods.txt', 'a')
    f.write(mood1 + ' ')
    # python will convert \n to os.linesep
    with open('trendingmoods.txt', 'r') as f:
        data = f.readlines()
    for line in data:
        words = line.split(' ')

        print(words)
    l = len(words)
    f.close()
    a1 = 0
    a2 = 0
    a3 = 0
    a4 = 0
    a5 = 0
    a6 = 0
    a7 = 0
    a8 = 0
    for j in range(0, l):
        if (words[j] == 'anger'):
            a1 = a1 + 1
        elif (words[j] == 'happy'):
            a2 = a2 + 1
        elif (words[j] == 'neutral'):
            a3 = a3 + 1
        elif (words[j] == 'sad'):
            a4 = a4 + 1
        elif (words[j] == 'disgust'):
            a5 = a5 + 1
        elif (words[j] == 'fear'):
            a6 = a6 + 1
        elif (words[j] == 'surprise'):
            a7 = a7 + 1
        elif (words[j] == 'contempt'):
            a8 = a8 + 1
    trendmood = 'anger'
    maximum = a1
    if (a2 > maximum):
        maximum = a2
        trendmood = 'happy'
    if (a3 > maximum):
        maximum = a3
        trendmood = 'neutral'
    if (a4 > maximum):
        maximum = a4
        trendmood = 'sad'
    if (a5 > maximum):
        maximum = a5
        trendmood = 'disgust'
    if (a6 > maximum):
        maximum = a6
        trendmood = 'fear'
    if (a7 > maximum):
        maximum = a7
        trendmood = 'surprise'
    if (a8 > maximum):
        maximum = a8
        trendmood = 'contempt'
    if(maximum>=15 and(mood=='anger'or mood=='sad'or mood=='fear' )):
        flag=1;
    return trendmood
def camera():
    #import cv2

    # Camera 0 is the integrated web cam on my netbook
    camera_port = 0

    # Number of frames to throw away while the camera adjusts to light levels
    ramp_frames = 30

    # Now we can initialize the camera capture object with the cv2.VideoCapture class.
    # All it needs is the index to a camera port.
    camera = cv2.VideoCapture(camera_port)

    # Captures a single image from the camera and returns it in PIL format
    def get_image():
        # read is the easiest way to get a full image out of a VideoCapture object.
        retval, im = camera.read()
        return im

    # Ramp the camera - these frames will be discarded and are only used to allow v4l2
    # to adjust light levels, if necessary
    for i in range(ramp_frames):
        temp = get_image()
    print("Taking image...")
    # Take the actual image we want to keep
    camera_capture = get_image()
    file = "C:\\Users\\Siddharth\\PycharmProjects\\EMOZERS\\Test.jpg"
    # A nice feature of the imwrite method is that it will automatically choose the
    # correct format based on the file extension you provide. Convenient!
    cv2.imwrite('Test.jpg', camera_capture)

    # You'll want to release the camera, otherwise you won't be able to create a new
    # capture object until your script exits
    del (camera)
import random
import playsound
def music(mood):

    songname = ''
    index = int(random.randint(0, 7))

    pathnameuplifting = [
        'Adele - Someone Like You Listen & Download.mp3',
        'All Saints - Pure Shores Listen & Download.mp3',
        'Barcelona - Please Dont Go Listen & Download.mp3',
        'Coldplay - Strawberry Swing Listen & Download.mp3',
        'dj-shah-mellomaniac-chillout-mix-best-chillout-music-series[mp3-gratis.eu - Download Free Mp3 Music].mp3',
        'Hans Zimmer - Pandora. Study Music..mp3',
        'Marconi Union - Weightless Listen & Download.mp3',
        'Mozart - Canzonetta Sull Aria Listen & Download.mp3']
    pathnamehappy = [
        'Adagio For Strings Samuel Barber Listen & Download.mp3',
        'Beatles - All You Need Is Love Listen & Download.mp3',
        'Bob Marley & The Wailers - Three Little Birds Listen & Download.mp3',
        'Clair De Lune.mp3',
        'Explosions In The Sky - First Breath After Coma Listen & Download.mp3',
        'James Brown - I Got You(i Feel Good) Listen & Download.mp3',
        'Katrina & The Waves - Walking On Sunshine Listen & Download.mp3',
        'Pharrell Williams - Happy Listen & Download.MP3',
        'What A Wonderful World Listen & Download.mp3']
    songnamehappy = ['Adagio For Strings Samuel Barber', 'Beatles - All You Need Is Love',
                     'Bob Marley & The Wailers - Three Little Birds', 'Clair De Lune',
                     'Explosions In The Sky - First Breath After Coma', 'James Brown - I Got You(i Feel Good)',
                     'Katrina & The Waves - Walking On Sunshine', 'Pharrell Williams - Happy Listen',
                     'What A Wonderful World Listen']
    songnameuplifting = ['Adele - Someone Like You', 'All Saints - Pure Shores', 'Barcelona - Please Dont Go Listen',
                         'Coldplay - Strawberry Swing', 'mellomaniac-chillout-mix', 'Hans Zimmer - Pandora',
                         'Marconi Union - Weightless', 'Mozart - Canzonetta Sull Aria',
                         'Rupert Holmes - (Escape) The Pina Colada Song']
    #full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathname[index])
    if (mood == 'happy'):
        songname = songnamehappy[index]
        print("Now Playing - %s" % songname)
        full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathnamehappy[index])
    elif (mood == 'sad'):
        songname = songnameuplifting[index]
        print("Now Playing - %s" % songname)
        full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathnameuplifting[index])
    elif (mood == 'fear'):
        songname = songnameuplifting[index]
        print("Now Playing - %s" % songname)
        full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathnameuplifting[index])
    elif (mood == 'anger'):
        songname = songnamehappy[index]
        print("Now Playing - %s" % songname)
        full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathnamehappy[index])
    elif (mood == 'surprise'):
        songname = songnamehappy[index]
        print("Now Playing - %s" % songname)
        full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathnamehappy[index])
    elif (mood == 'disgust'):
        songname = songnameuplifting[index]
        print("Now Playing - %s" % songname)
        full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathnameuplifting[index])
    elif (mood == 'neutral'):
        songname = songnamehappy[index]
        print("Now Playing - %s" % songname)
        full_filename = os.path.join(app.config['UPLOAD_FOLDER'], pathnamehappy[index])
    return (full_filename)





from flask import Flask,render_template

PEOPLE_FOLDER = os.path.join('static', 'people_photo')

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = PEOPLE_FOLDER

@app.route('/')
def index():
    return 'This is homepage'


@app.route('/analysis')
def tuna():
    camera()
    global flag
    global mood
    body = open('C:\\Users\\Siddharth\\PycharmProjects\\EMOZERS\\Test.jpg', 'rb').read()
    try:
        # NOTE: You must use the same region in your REST call as you used to obtain your subscription keys.
        #   For example, if you obtained your subscription keys from westcentralus, replace "westus" in the
        #   URL below with "westcentralus".
        conn = http.client.HTTPSConnection('westus.api.cognitive.microsoft.com')
        conn.request("POST", "/emotion/v1.0/recognize?%s" % params, body, headers)
        response = conn.getresponse()
        data = response.read()
        # 'data' contains the JSON data. The following formats the JSON data for display.
        parsed = json.loads(data)
        print("Response:")
        jsonData = (json.dumps(parsed, sort_keys=True))
        jsonData = jsonData[1:len(jsonData) - 1]
        conn.close()
    except Exception as e:
        print(e.args)
        ####################################
        exit(0)
    ###############################
    mood='anger'
    t = json.loads(jsonData)
    # print jsonToPython
    max = t['scores']['anger']
    if (t['scores']['contempt'] > max):

        max = t['scores']['contempt']
        mood = 'contempt'
    if (t['scores']['disgust'] > max):
        # print "The person is disgust"
        #global mood
        max = t['scores']['disgust']
        mood = 'disgust'
    if (t['scores']['fear'] > max):
        #global mood
        max = t['scores']['fear']
        mood = 'fear'
        # print "The person is fear"
    if (t['scores']['happiness'] > max):
        max = t['scores']['happiness']
        mood = 'happy'
        # print "The person is happy"
    if (t['scores']['neutral'] > max):
        #global mood
        max = t['scores']['neutral']
        mood = 'neutral'
        # print "The person is neutral"
    if (t['scores']['sadness'] > max):
        #global mood
        max = t['scores']['sadness']
        mood = 'sad'
        # print "The person is sad"
    if (t['scores']['surprise'] > max):
        #global mood
        max = t['scores']['surprise']
        mood = 'surprise'
        # print "The person is surprised"
    # return 'Tuna is running'
    print(mood)
    # print 'Person is',mood,'with',max,'probability'
    # return '<h1>Person is %s.</h1>'%mood
    fullname=music(mood)
    trend=dataa(mood)
    p1=' '
    p2=' '
    p3=' '
    if(mood=='anger'):
      p1= os.path.join(app.config['UPLOAD_FOLDER'], 'a1.jpg')
      p2= os.path.join(app.config['UPLOAD_FOLDER'], 'a2.jpg')
      p3= os.path.join(app.config['UPLOAD_FOLDER'],'a3.jpg')
    if(mood=='happy'or mood=='neutral'):
        p1 = os.path.join(app.config['UPLOAD_FOLDER'], 'h1.png')
        p2 = os.path.join(app.config['UPLOAD_FOLDER'], 'h2.jpg')
        p3 = os.path.join(app.config['UPLOAD_FOLDER'], 'h3.jpg')
    pathr=os.path.join(app.config['UPLOAD_FOLDER'],'bg2.jpeg')
    if(flag==1):

        message='We have noticed that something has not been right in the recent times.Here is something that might help you.We STRONGLY recommend you to read this!!'
    else:
        message='Here is something for you to read in your free time.'
    return render_template("SecondPage.html",bg2=pathr, mood=mood,trending=trend,song=fullname,im1=p1,im2=p2,im3=p3,message=message)

@app.route('/masti/')
def masti():
    global mood
    music(mood)


@app.route('/test')
def test():
    return 'this is it'

@app.route('/profile')
def profile():
    return '<h1>Welcome </h1>'


if __name__ == "__main__":
    app.run(debug=True)
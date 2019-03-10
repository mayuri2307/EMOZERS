import http.client, urllib.request, urllib.parse, urllib.error, base64, sys, json

headers = {
    # Request headers. Replace the placeholder key below with your subscription key.
    'Content-Type': 'application/octet-stream',
    'Ocp-Apim-Subscription-Key': '3ca09e70d6b64cd4a050b343bcd43dc5',
}

params = urllib.parse.urlencode({
})

# Replace the example URL below with the URL of the image you want to analyze.
body = open('C:\\Users\\Siddharth\\Desktop\\obama.jpeg','rb').read()

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
    print ("Response:")
    jsonData=(json.dumps(parsed, sort_keys=True))
    jsonData=jsonData[1:len(jsonData)-1]
    conn.close()
except Exception as e:
    print(e.args)
####################################
    exit(0)
    ###############################
    mood = 'anger'
    t = json.loads(jsonData)
    # print jsonToPython
    max = t['scores']['anger']
    if (t['scores']['contempt'] > max):
        max = t['scores']['contempt']
        mood = 'contempt'
    if (t['scores']['disgust'] > max):
        # print "The person is disgust"
        max = t['scores']['disgust']
        mood = 'disgust'
    if (t['scores']['fear'] > max):
        max = t['scores']['fear']
        mood = 'fear'
        # print "The person is fear"
    if (t['scores']['happiness'] > max):
        max = t['scores']['happiness']
        mood = 'happy'
        # print "The person is happy"
    if (t['scores']['neutral'] > max):
        max = t['scores']['neutral']
        mood = 'neutral'
        # print "The person is neutral"
    if (t['scores']['sadness'] > max):
        max = t['scores']['sadness']
        mood = 'sad'
        # print "The person is sad"
    if (t['scores']['surprise'] > max):
        max = t['scores']['surprise']
        mood = 'surprise'
        # print "The person is surprised"
    # return 'Tuna is running'
    # print 'Person is',mood,'with',max,'probability'
    # return '<h1>Person is %s.</h1>'%mood
    return ("The person is %s",%mood)


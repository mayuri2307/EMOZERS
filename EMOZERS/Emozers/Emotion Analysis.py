########### Python 2.7 #############
import httplib, urllib, base64, json

headers = {
    # Request headers. Replace the placeholder key below with your subscription key.
    'Content-Type': 'application/json',
    'Ocp-Apim-Subscription-Key': '3ca09e70d6b64cd4a050b343bcd43dc5',
}

params = urllib.urlencode({
})

# Replace the example URL below with the URL of the image you want to analyze.
body = "{ 'url': 'https://i2-prod.mirror.co.uk/incoming/article10562943.ece/ALTERNATES/s615b/Real-Madrids-Cristiano-Ronaldo-celebrat.jpg' }"

try:
    # NOTE: You must use the same region in your REST call as you used to obtain your subscription keys.
    #   For example, if you obtained your subscription keys from westcentralus, replace "westus" in the
    #   URL below with "westcentralus".
    conn = httplib.HTTPSConnection('westus.api.cognitive.microsoft.com')
    conn.request("POST", "/emotion/v1.0/recognize?%s" % params, body, headers)
    response = conn.getresponse()
    data = response.read()
    # 'data' contains the JSON data. The following formats the JSON data for display.
    parsed = json.loads(data)
    print ("Response:")
    jsonData= (json.dumps(parsed, sort_keys=True))
    jsonData=jsonData[1:len(jsonData)-1]
    conn.close()
except Exception as e:
    print("[Errno {0}] {1}".format(e.errno, e.strerror))
    exit(0)
###############################
mood='anger'
t= json.loads(jsonData)
#print jsonToPython
max=t['scores']['anger']
if (t['scores']['contempt']>max):
    max=t['scores']['contempt']
    mood='contempt'
if(t['scores']['disgust']>max):
    #print "The person is disgust"
    max=t['scores']['disgust']
    mood='disgust'
if(t['scores']['fear']>max):
    max=t['scores']['fear']
    mood='fear'
    #print "The person is fear"
if(t['scores']['happiness']>max):
    max=t['scores']['happiness']
    mood='happy'
    #print "The person is happy"
if(t['scores']['neutral']>max):
    max=t['scores']['neutral']
    mood='neutral'
    #print "The person is neutral"
if(t['scores']['sadness']>max):
    max=t['scores']['sadness']
    mood='sad'
    #print "The person is sad"
if(t['scores']['surprise']>max):
    max=t['scores']['surprise']
    mood='surprise'
    #print "The person is surprised"
print ('Person is in '+mood+' mood with ',max,' probability')


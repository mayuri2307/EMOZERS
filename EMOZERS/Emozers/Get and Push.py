
import http.client
import sys
import re
from flask import Flask, request , render_template
app= Flask(__name__)
@app.route("/")
def index():
    return 'Method used: %s' % request.method
@app.route("/bacon", methods=['GET','POST'])
def bacon():
    if request.method == 'POST':
        return "You are probably using POST"
    else:
        return "You are probably using GET"
if __name__=="__main__":
    app.run()

import http.client
import sys
import re
from flask import Flask
app= Flask(__name__)
@app.route('/')
def index():
    return'This is the Homepage'
@app.route('/tuna')
def tuna():
    return '<h2>Tuna is Good </h2> '
@app.route('/profile/<username>')
def profile(username):
    return "Hey there %s" %username

if __name__=="__main__":
        app.run(debug=True)

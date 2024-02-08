from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
def hello():
	return render_tamplate("app/templates/index.html")



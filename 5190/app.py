from flask import Flask, render_template, request

app = Flask(__name__)

@app.route("/")
def home():
        return render_template("form.html")
    
@app.route("/submit", methods=["GET", "POST"])
def submit():
    if request.method == ("GET"):
        return render_template("form.html")
    else:
        name = request.form['name']
        firstname = request.form['firstname']
        email = request.form['email']
        emailconfirmation = request.form['emailconfirmation']
        password = request.form['password']
        
        return render_template("form.html", name=name, firstname=firstname, email=email, emailconfirmation=emailconfirmation, password=password)
























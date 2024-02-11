from flask import Flask, render_template, request
import string
import sqlite3

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

        if name == '' or firstname == '' or email == '' or emailconfirmation == '' or password == '':
            return render_template("form.html", name=name, firstname=firstname, email=email, emailconfirmation=emailconfirmation, password=password)

        if len(password) < 8:
             return render_template("form.html", name=name, firstname=firstname, email=email, emailconfirmation=emailconfirmation, password=password, erreur="Password must contain at least 8 caracters.")

        if password.islower():
                          return render_template("form.html", name=name, firstname=firstname, email=email, emailconfirmation=emailconfirmation, password=password, erreur="Password must contain an upper case letter.")

        if password.isupper():
                           return render_template("form.html", name=name, firstname=firstname, email=email, emailconfirmation=emailconfirmation, password=password, erreur="Password must contain a lower case letter.")

        if not any(char in string.punctuation for char in password):
                             return render_template("form.html", name=name, firstname=firstname, email=email, emailconfirmation=emailconfirmation, password=password, erreur="Password must contain a punctuation sign.")

        if email != emailconfirmation:
                             return render_template("form.html", name=name, firstname=firstname, email=email, emailconfirmation=emailconfirmation, password=password, erreur="Emails must be identical.")



        else:
            con = sqlite3.connect("db.db")
            cur = con.cursor()
            cur.execute("INSERT INTO USERS (name, firstname, courriel, dateinscription, salt, hash)" "VALUES (?, ?, ?, ?, ?, ?)", (name, firstname, email, "01-01-2024", "abcd", "1234"))
            con.commit()                    
            
            return render_template("merci.html", firstname = firstname, name = name)






















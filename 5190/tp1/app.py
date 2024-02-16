from flask import Flask, render_template, g
from database import Database
from datetime import date
import re
import secrets

app = Flask(__name__)

app.config['SECRET_KEY'] = secrets.token_hex(16)
regex = r"[A-Za-z0-9#$%&'*+/=?@]{8,}"
mdp_existant = re.compile(regex).match

def get_db():
    database = getattr(g, "_database", None)
    if database is None:
        g._database = Database()
    return g._database

def deconnection():
    database = getattr(g, "_database", None)
    if database is not None:
        database.deconnection()

@app.route("/")
def home():
    database = Database()
    articles = database.rechercher_articles("5 Lorem")
    return render_template("index.html", articles=articles)

@app.route("/article/<identifiant>")
def article():
    return

@app.route("/admin")
def admin():
    return

@app.route("/admin-nouveau")
def admin_nouveau():
    return

@app.route("/utilisateurs")
def utilisateurs():
    return

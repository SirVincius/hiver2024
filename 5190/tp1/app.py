from flask import Flask
from database import Database
from datetime import date
import re
import secrets

app = Flask(__name__)

app.config['SECRET_KEY'] = secrets.token_hex(16)
regex = r"[A-Za-z0-9#$%&'*+/=?@]{8,}"
mdp_existant = re.compile(regex).match

@app.route("/")
def home():
    return 

@app.route("/article/<identifiant>")
def article():
    return

@app.route("/admin")
def admin():
    return

@app.route("/admin-nouveau")
def admin_nouveau():
    return

@app.route("utilisateurs")
def utilisateurs():
    return

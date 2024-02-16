from flask import Flask, render_template, g, request
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


@app.route("/", methods=["GET"])
def home():
    database = Database()
    articles = database.obtenir_articles()
    return render_template("index.html", articles=articles)


@app.route("/", methods=["POST"])
def rechercher():
    mots_cles = request.form["mots-cles"]
    database = Database()
    articles = database.rechercher_articles(mots_cles)
    return render_template("index.html", articles=articles)

@app.route("/article/<identifiant>")
def article(identifiant):
    database = Database()
    article = database.rechercher_article_specifique(identifiant)
    return render_template("/article.html", article=article)

@app.route("/admin")
def admin():
    return

@app.route("/admin-nouveau")
def admin_nouveau():
    return

@app.route("/utilisateurs")
def utilisateurs():
    return

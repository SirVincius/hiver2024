from flask import Flask, render_template, g, request, redirect, url_for
from database import Database
from datetime import date
import re
import secrets
import hashlib
import uuid

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

@app.route("/modification/<identifiant>")
def modification(identifiant):
    database = Database()
    article = database.rechercher_article_specifique(identifiant)
    return render_template("/modification.html", article=article)

@app.route("/envoyer_modifications", methods=['POST'])
def envoyer_modifications():
    return redirect(url_for('liste_articles'))

@app.route("/liste_articles")
def liste_articles():
    return render_template("liste_articles.html")

@app.route("/admin")
def admin():
    return

@app.route("/admin-nouveau")
def admin_nouveau():
    return

@app.route("/utilisateurs")
def utilisateurs():
    return

#TODO : SUPPPRIMER CETTE FONCTION
@app.route("/test")
def test():
    salt = uuid.uuid4().hex
    hashed_password = hashlib.sha512(str(salt).encode("utf-8")).hexdigest()
    return render_template("test.html", test=hashed_password)

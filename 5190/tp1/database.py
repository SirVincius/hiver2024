from flask import Flask, jsonify
import sqlite3

class Database():

    database = 'db/database.db'

    def __init__(self):
        self.connection = None

    def get_connection(self):
        if self.connection is None:
            self.connection = sqlite3.connect(Database.database)
        return self.connection
    
    def deconnection(self):
        if self.connection is not None:
            self.connection.close()


    def inserer_utilisateur(self, prenom, nom, courriel, salt, hash, photo):
        connection = self.get_connection()
        connection.execute(
            "INSERT INTO utilisateur(prenom, nom, courriel, salt, hash, photo) "
            "VALUES (?,?,?,?,?,?)",
            (prenom, nom, courriel, salt, hash, photo)
        )
        connection.commit()

    def inserer_article(self, identifiant, titre, auteur, date_de_publication, contenu):
        connection = self.get_connection()
        connection.execute(
            "INSERT INTO utilisateur(identifiant, titre, auteur, date_de_publication, contenu) "
            "VALUES (?,?,?,?,?)",
            (identifiant, titre, auteur, date_de_publication, contenu)
        )
        connection.commit()

    def obtenir_articles(self):
        connection = self.get_connection()
        cursor = connection.cursor()
        cursor.execute(
            "SELECT * FROM article ORDER by date_de_publication"
        )

        article = cursor.fetchall()

        cursor.close()
        connection.close()

        return article
    
    def rechercher_articles(self, mots_cles):
        connection = self.get_connection()
        cursor = connection.cursor()
        cursor.execute(
            """SELECT * FROM article 
             WHERE titre LIKE ? OR contenu LIKE ?""", ('%' + mots_cles + '%', '%' + mots_cles + '%')
        )

        article = cursor.fetchall()

        cursor.close()
        connection.close()

        return article
    
    def rechercher_article_specifique(self, identifiant):
        connection = self.get_connection()
        cursor = connection.cursor()
        cursor.execute(
            """SELECT * FROM article 
                WHERE identifiant LIKE ?""", (identifiant,)
        )

        article = cursor.fetchone()

        cursor.close()
        connection.close()

        return article
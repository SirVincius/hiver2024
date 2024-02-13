CREATE TABLE article (
    identifiant INTEGER PRIMARY KEY,
    titre TEXT,
    auteur TEXT,
    date_de_publication date,
    contenu TEXT
)

CREATE TABLE utilisateur (
    prenom TEXT,
    nom TEXT,
    courriel TEXT,
    mot_de_passe_salt TEXT,
    mot_de_passe_hash TEXT,
    photo TEXT
)
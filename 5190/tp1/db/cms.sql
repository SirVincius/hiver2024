CREATE TABLE article (
    identifiant INTEGER PRIMARY KEY,
    titre TEXT,
    auteur TEXT,
    date_de_publication date,
    contenu TEXT
);

CREATE TABLE utilisateur (
    prenom TEXT,
    nom TEXT,
    courriel TEXT,
    salt TEXT,
    hash TEXT,
    photo TEXT
);
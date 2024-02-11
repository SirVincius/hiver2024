-- Fonctions

mystere::Num a => [[a]] -> [a]
mystere [[]] = []
mystere xs = map (negate.sum.tail) xs

listeDoubles::Num a => [a] -> [a]
listeDoubles a = map (*2) a

somme::Num a => [a] -> a
somme a = foldl1 (+) a

produit::Num a => [a] -> a
produit a = foldl1 (*) a

sommeCarre::Num a => [a] -> a
sommeCarre a = foldl1 (\x y -> x + y^2) a

-- FONCTIONS

listeDoubles::[Int] -> [Int]
listeDoubles xs = foldl (\acc x -> acc++[(x*2)]) [] xs

listeDoubles2::[Int] -> [Int]
listeDoubles2 xs = map (*2) xs

listeDoubles3::[Int] -> [Int]
listeDoubles3 xs = [x*2 | x <- xs]

listeDoubles4::[Int] -> [Int]
listeDoubles4 [] = []
listeDoubles4 (x:xs) =  (x*2):(listeDoubles(xs))

map1::(a -> b) -> [a] -> [b]
map1 f = foldr (\x acc -> (f x):acc) []

filter1:: (a -> Bool) -> [a] -> [a]
filter1 f = foldr (\x acc -> if (f x) then x:acc else acc) []

any1::Foldable t => (a -> Bool) -> t a -> Bool
any1 f = foldr (\x acc -> f x || acc ) False

estDouble:: Eq a => [a] -> Bool
estDouble [] = False
estDouble [x] = False
estDouble x | odd (length x) = False
            | take ((length x) / 2) x == drop ((length x) / 2) x = True

-- Fonctions

supprimerIntervalle:: (Int,Int) -> [Int] -> [Int]
supprimerIntervalle (_,_) [] = []
supprimerIntervalle (x,y) z = filter (>=x) $ filter (<=y) z


supprimerIntervalle2:: (Int,Int) -> [Int] -> [Int]
supprimerIntervalle2 (_,_) [] = []
supprimerIntervalle2 (x,y) z = filter (`elem` [x..y]) z

compteurInt::Int -> [Int] -> Int
compteurInt _ [] = 0
compteurInt x z = length $ filter (x==) z

compteurInt2::Int -> [Int] -> Int
compteurInt2 _ [] = 0
compteurInt2 x z = length $ [y | y <- z, x == y]

compteurInt3::Int -> [Int] -> Int
compteurInt3 _ [] = 0
compteurInt3 x z = length $ filter (\y -> y == x) z

sumMatrice::Num a => [[a]] -> [[a]] -> [[a]]
sumMatrice a b = (zipWith.zipWith) (+) a b

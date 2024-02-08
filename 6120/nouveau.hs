-- Module à charger pour l'exercice sur les fonctions

-- Des matrices
matriceA = [[ 3,  1, -2],
            [-1,  0,  2],
            [ 4, -1,  5]]
matriceB = [[-1,  4,  2],
            [ 0, -6, -1],
            [ 8,  6, -4]]
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
sumMatrice a b = zipWith (zipWith (+)) a b

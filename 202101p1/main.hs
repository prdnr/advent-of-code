module Main where

main :: IO ()
main = interact $ show . solve . parse

parse :: String -> [Integer]
parse xs = map read (lines xs)

solve :: (Ord a, Num a) => [a] -> Int
solve xs = length . filter (\(x : y : zs) -> (y - x) > 0) $ dataWindows 2 xs

dataWindows :: Int -> [a] -> [[a]]
dataWindows n xs
  | length xs >= n = take n xs : dataWindows n (drop 1 xs)
  | otherwise = []

module Main where

import Data.Char (isSpace)

main :: IO ()
main = interact $ show . solve . parse

data Movement
  = Forward Integer
  | Backward Integer
  | Up Integer
  | Down Integer
  | Stationary
  deriving (Show, Read)

parse :: String -> [Movement]
parse xs = map getDirection $ map (break isSpace) $ lines xs
  where
    getDirection xs@(x, y)
      | x == "forward" = Forward (read y)
      | x == "backward" = Backward (read y)
      | x == "up" = Up (read y)
      | x == "down" = Down (read y)
      | otherwise = Stationary

solve xs = (\(h, v) -> h * v) $ position (0, 0) xs

-- Down is a positive value because the reference is sea level
position :: (Integer, Integer) -> [Movement] -> (Integer, Integer)
position p@(h, v) ms@(Forward x : nms) = position (h + x, v) nms
position p@(h, v) ms@(Backward x : nms) = position (h - x, v) nms
position p@(h, v) ms@(Up x : nms) = position (h, v - x) nms
position p@(h, v) ms@(Down x : nms) = position (h, v + x) nms
position p@(h, v) ms@(Stationary : nms) = position p nms
position p [] = p

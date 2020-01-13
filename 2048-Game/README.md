2048 Game - Java Project

Created by Rui Yan, February 26, 2016.

(YouTube demo: https://www.youtube.com/watch?v=AW1TenpVMww)

Game rules:

2048 is played on a simple grid of size 4x4, with numbered tiles (all powers of 2) that will slide in one of 4 directions (UP, DOWN, LEFT, RIGHT) based on input from the user. Every turn, a new tile will randomly appear in an empty spot on the board with a value of 2 (except at the beginning, when 2 random tiles get values of 2).

Tiles will slide as far as possible in the chosen direction until they are stopped by either another tile or the edge of the grid. If two tiles of the same number collide while moving, they will merge into a tile with a total value of the two tiles that collide. For example, if two tiles of value 8 slide into one another the resulting tile will have a value of 16. The resulting tile cannot merge with another tile again in the same move.

Example

```
Controls:
w - Move Up
s - Move Down
a - Move Left
d - Move Right
q – Quit

2 - - 2
- - - -
- - - -
- - - -
> a #move left

4 - - -
- - 2 -
- - - -
- - - -
> f #bogus input, show control menu again
```

```
Controls:
w - Move Up
s - Move Down
a - Move Left
d - Move Right
q - Quit

4 - - -
- - 2 -
- - - -
- - - -
... #game continues until.

4 2 8 16
2 4 2 8
16 2 8 32
2 8 4 64

Game Over:
n – New Game
q - Quit
> n #game restarts
```
```
Controls:
w - Move Up
s - Move Down
a - Move Left
d - Move Right
q – Quit

2 - - -
- - - 2
- - - -
- - - -
> d #move right

... #game continues until:
4 2 8 16
2 4 2 8
2048 2 8 32
2 8 4 64

You Win!
n – New Game
q - Quit
> q #program exits
```

# Projet IPO 2022 (DLIN211 A)

## Current state

TP9 and TP10 completed  
  
- [State.txt](https://gitlab.dsi.universite-paris-saclay.fr/mathieu.waharte/projet-ipo/-/blob/master/State.txt) : a file I used to track what bugs and features I had to fix/implement.  
- [inheritance_scheme.txt](https://gitlab.dsi.universite-paris-saclay.fr/mathieu.waharte/projet-ipo/-/blob/master/inheritance_scheme.txt) : describes how the differents classes interacts between one another (arrow for inheritance and \[ ] for instanciations).


## Features

- Uses textures assets for the entities, walls and exit.
- Shepherd can kill wolves (1 damage each time) using Z,Q,S,D (damage to : up, left, down, right).  
If all wolves are dead, the game ends and the score is multiplied by two (or set to 1 if was 0).


## Makefile

[Makefile](https://gitlab.dsi.universite-paris-saclay.fr/mathieu.waharte/projet-ipo/-/blob/master/Makefile) :    
`make` : compile all .java files.  
`make run` : `java Jeu`.  
`make clean` : remove all .class.  

# JAV Mini Game Project

participants `@seoljiwon` `@kyoungmiin`

0. How to play the game / How to compile

1. Character class
  - The character runs and avoid the enemies.
  - The character can avoid enemies by jumping or sliding, pressing up(▲) key to jump and down(▼) key to slide.
  - Character class has 6 member variables: imageObj, hp, speed, jumpScale, x and y
  - imageObj is the graphical image of the character, which is gotten as a parameter when the class is being created in GameFrame class.
  - hp is the energy of the character, which is also gotten as a parameter. The game will be end if the character's hp becomes 0.
  - speed is literally the speed of the character's run, which is also gotten as a parameter and it is related to the Background class since the background moves in the same speed when character runs in our game.
  - If the character is hit by an enemy, it's hp will be decreased certain amount which depends on the enemy.
  - If the hp of the character becomes 0, the game automatically ends. 


2. Enemy
  - There are 3 kinds of enemies: basic enemy, bomb enemy and descending enemy
  - The enemies go toward the character to attack.
  - Each enemy has 4 common member variables: imageObj, damage, x and y
  - All 4 variables are gotten as a parameter when the class is being created in GameFrame class.
  - Every other variables are almost same as in Character class but the Enemy has one special variable: damage, which is each enemy's own value which harms the character in that amount.
  - Enemy class is for the basic enemy.
  - The basic enemy just horizontally moves toward the character and gives damage to the user if they crash.
  - The bomb enemy falls from the sky and bombs when it reaches the floor so that the flame of the bomb can attack the character.
  - The descending enemy comes down from the sky and hangs at the top so the character should slide to avoid this enemy.

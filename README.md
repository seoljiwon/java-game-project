# JAV Mini Game Project

participants `@seoljiwon` `@kyoungmiin`


1. Character
  - The character has 6 member variables: the image(imageObj), hp, speed, jumpScale and the positions(x,y)
  - The image, the hp and the speed is gotten as a parameter when the class is created.
  - The character runs in it's own speed through the road and avoid enemies while running.
  - The character can avoid enemies by jumping or sliding by pressing up(▲) key to jump and down(▼) key to slide.
  - If the character is hit by an enemy, it's hp will be decreased certain amount.
  - If the hp of the character becomes 0, the game automatically ends. 


2. Enemy
  - There are 3 kinds of enemies: basic enemy, bomb enemy and descending enemy
  - Each enemy has 4 member variables: the image(imageObj), Amaount of the damage(damage) and the positions(x,y)
  - The basic enemy just horizontally moves toward the character and gives certain amount of damage to the user if they conflicts.
  - 

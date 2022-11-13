# JAV Mini Game Project

**🙋‍♀️ participants** Jiwon Seol(@seoljiwon), Kyoungmin Lee(@kyoungmiin)

**👩🏻‍💻 tech stack** 100% java 😁

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 

### 0. How to play the game / How to compile
---


  After cloning... In directory 'java_game_project/src'. 
  Run command
  
  To Compile the source code,  
  ```
  $ javac Game.java
  ```
  
  To execute byte code file,  
  ```
  $ java Game
  ```
  
  **Jelly Run automatically starts!👾** 
  **Enjoy the game with ▲ and ▼ key**
  

### 1. Character
---

  - The character runs and avoid the enemies.
    - The character can avoid enemies by jumping or sliding, pressing up(▲) key to jump and down(▼) key to slide.
  
  - Character class has 6 member variables: imageObj, hp, speed, jumpScale, x and y
    - imageObj is the graphical image of the character, which is gotten as a parameter when the class is being created in GameFrame class.
    - hp is the energy of the character, which is also gotten as a parameter. The game will be end if the character's hp becomes 0.
    - speed is the speed of the character's run and it is related to the Background class since character seems run because of background moving.
    - If the character is collided by an enemy, it's hp will be decreased certain amount which depends on the enemy damage.
    - If the hp of the character becomes 0, the game automatically ends. 


### 2. Enemy
---

  - There are 3 kinds of enemies: basic enemy, bomb enemy and descending enemy
     - The basic enemy just horizontally moves toward the character and gives damage to the user if they crash.
     - The bomb enemy falls from the sky and bombs when it reaches the floor so that the flame of the bomb can attack the character.
     - The descending enemy comes down from the sky and hangs at the top so the character should slide to avoid this enemy.
  
  - Each enemy has 4 common member variables: imageObj, damage, x and y
     - Special variable damage is is each enemy's own value which harms the character in that amount.
  

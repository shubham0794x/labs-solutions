# Lab 2.02

Labs are mandatory and must be completed before the start of the next class.

You make work collaboratively with your classmates, but you may not copy and paste another student's code.

<br><br>

### Instructions

<br>

- Create a new GitHub repository named `Enterprise-Java-Development-2.02`
- Add your instructor and the class graders to your repository and ensure that your repository is private. Public repositories will receive a zero on the assignment.
- If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
- Upload the code for all of the following prompts to your repository.
- Submit a URL link to your repository below.

<br><br>

### Specifications

<br>

1. Employing TDD, create a method that takes in an integer _n_ and returns an array of all odd integers from 1 to _n_. _Write your tests first!_
2. Java has certain words that are considered "Java Keywords". Keywords are reserved and cannot be used as variable names. Employing TDD, create a method that takes in a String and returns `true` if the String contains any Java Keywords. **For example**, `break` is a Java keyword. The String `"Don't break my heart"` should return true. The String `"I love to breakdance"` should return false. _You will need to use Google to find a list of all Java Keywords_.
3. Create a `Player` class for a video game. Track the player's stats (health, strength, lives, etc). Create 3 subclasses `Warrior`, `Elf`, `Wizard`. Provide at least one specialized behavior for each.
4. Employing TDD, create a method that decrements the lives of a player. The method should reduce the number of lives by one and restore the player's health to its original state.
5. Employing TDD, create a method that allows one player to attack another. When a player attacks another, the attacked player's health should decrease by the attacking player's strength. For example, if a `playerA` has `strength = 5` and a `playerB` has `health = 20`, then when the `playerA` attacks the `playerB`, the `playerB`'s new health will be `15`. _Hint: the attack method will take a Player object as an argument._

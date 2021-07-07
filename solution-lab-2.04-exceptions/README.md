# Lab 2.04

Labs are mandatory and must be completed before the start of the next class.

You make work collaboratively with your classmates, but you may not copy and paste another student's code.

<br><br>

### Instructions

<br>

- Create a new GitHub repository named `Enterprise-Java-Development-2.04`
- Add your instructor and the class graders to your repository and ensure that your repository is private. Public repositories will receive a zero on the assignment.
- If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
- Upload the code for all of the following prompts to your repository.
- Submit a URL link to your repository below.

<br><br>

### Specifications

<br>

1. Create a `Person` class that has properties `id`, `name`, `age`, and `occupation`. Throw an error if someone tries to set age to less than 0. Include all tests.
2. Create an array or List of Person objects. Create a `findByName` method. The method should take in a String `name` and return the Person with a name that matches exactly. The Person `name` property and the method `name` parameter should be formatted as `"firstName lastName"`. Throw an exception if the `name` parameter is not properly formatted. Include all tests.
3. Create a `clone` method. The `clone` method should take in a Person object and return a nearly identical object with new `id`. Override the `equals` method in the Person class to test for equivalency excluding `id`. Include all tests.
4. Create a method that takes a Person object as a parameter and used the `toString` method to write the Person information to a file. Handle any errors as necessary.

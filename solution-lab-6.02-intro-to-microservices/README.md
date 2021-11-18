# Lab 6.02

<br><br>

### Instructions

<br>

- Create a new GitHub repository named `Enterprise-Java-Development-6.02`
- Add your instructor and the class graders to your repository and ensure that your repository is private. Public repositories will receive a zero on the assignment.
- If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
- Upload the code for all of the following prompts to your repository.
- Submit a URL link to your repository below.

<br><br>

### Requirements

<br>

Using Eureka and Rest Templates complete the following:

1. Book Look Up:

   - A simple BookService that stores Books by ISBN and includes title, author, and genre
   - A simple BookFormatService that stores Books by ISBN and includes all formats in which the Book is available (hardcover, paperback, electronic, and/or audio).

   Both services should have standard GET and POST routes. The Book service should return a DTO with ISBN, title, author, genre, and a list of available formats. The formats must be retrieved from the BookFormatService.


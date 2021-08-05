# Lab 3.06

<br><br>

### Instructions

<br>

- Create a new GitHub repository named `Enterprise-Java-Development-3.06`
- Add your instructor and the class graders to your repository and ensure that your repository is private. Public repositories will receive a zero on the assignment.
- If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
- Upload the code for all of the following prompts to your repository.
- Submit a URL link to your repository below.

<br><br>

### Specifications

<br>

1.  Using the Spring JPA model the relationships of the below application:

    Assume that you are working with Task Management software. Below are the requirements in regards to data storage:

    - Tasks have a `title`, `dueDate`, and a _boolean_ `status`
    - There are 2 kinds of tasks `BillableTask` and `InternalTask`. The `BillableTask` have an `hourlyRate`.

2.  Using the Spring JPA model the relationships of the below application:

    Assume that you are working with a PR company to model their data. Below are the requirements in regards to data storage:

    - The database consists of `Contacts`. Each Contact has a `name`, `title`, and `company`.
    - Names are their own object and have a `firstName`, `lastName`, `middleName`, and `salutation`.
    - Names should not be stored in a separate table in the database.

3.  List 3 tasks that can be accomplished with native SQL that you cannot do with JPQ.

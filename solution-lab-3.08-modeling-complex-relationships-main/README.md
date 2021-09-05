# Lab 3.08

Labs are mandatory and must be completed before the start of the next class.

You make work collaboratively with your classmates, but you may not copy and paste another student's code.

<br><br>

### Instructions

<br>

- Create a new GitHub repository named `Enterprise-Java-Development-3.08`
- Add your instructor and the class graders to your repository and ensure that your repository is private. Public repositories will receive a zero on the assignment.
- If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
- Upload the code for all of the following prompts to your repository.
- Submit a URL link to your repository below.

<br><br>

### Specifications

<br>

1.  Using the Spring JPA model the relationships of the below application:
    Assume that you are working with an Association of Nurses. They need to model the association and its members.
    - The Association has 7 Chapters. Each Chapter has a `name`, a `district`, a `president` (which is a Member), and a `list` of Members
    - Each Member has a `name`, a `status` (_ACTIVE_ or _LAPSED_), and `renewal date`.
2.  Using the Spring JPA model the relationships of the below application:
    Assume that you are working with an Event Management company. They need to model upcoming events.
    - Each event has a `date`, a `duration`, a `location`, a `title`, and a `list` of guests.
    - Each guest has a `name` and a `status` (_ATTENDING, NOT_ATTENDING, NO_RESPONSE_)
    - There are two types of events: `Conferences` and `Expositions`. In addition to the typical Event properties, Conferences also have a list of Speakers.
    - Speakers have a `name` and `presentationDuration`.

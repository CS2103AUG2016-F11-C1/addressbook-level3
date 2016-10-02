# User Guide

**To be changed**
This product is not meant for end-users and therefore there is no user-friendly installer. 
Please refer to the [Setting up](DeveloperGuide.md#setting-up) section to learn how to set up the project.

## Starting the program
**To be changed**
1. Find the project in the `Project Explorer` or `Package Explorer` (usually located at the left side)
2. Right click on the project
3. Click `Run As` > `Java Application` and choose the `Main` class.
4. The GUI should appear in a few seconds.

**Include our own app images TBU**
<img src="images/Ui.png">

## Viewing help : `help`
Shows a list of all commands in the **reminder**.  
Format: `help`

> Help is also shown if you enter an incorrect command e.g. `abcd`
 
## Adding a task: `add`
Adds a task to the **reminder**  
Format: `add NAME [p][s/START_DATE] [p][e/END_DATE] [p][d/DEADLINE] [t/TAG]...` 
 
> **Bold words are to be changed (This is to be removed)**
> **Need to include format of date?**
> 
> Words in `UPPER_CASE` are the parameters, items in `SQUARE_BRACKETS` are optional, 
> items with `...` after them can have multiple instances. Order of parameters are fixed. 
> 
> **Not sure if this is a good feature**
> Put a `p` before the start_date / end_date / deadline prefixes to mark it as `private`. `private` details can only
> be seen using the `viewall` command.
> 
> Tasks can have any number of tags (including 0)

Examples: 
**Include the dates according to format for e.g.**

* `add Assignment2 s/ e/ d/`
* `add CS3216 Project A ps/e/ d/ t/CS3216 t/Project`

## Listing all persons : `list`
Shows a list of all tasks in the **reminder**.  
Format: `list`

## Finding all tasks containing any keyword in their name & tag: `find`
Finds tasks whose name and tags contain any of the given keywords.  
Format: `find KEYWORD [MORE_KEYWORDS]`

> The search is not case sensitive, the order of the keywords does not matter, only the name is searched, 
and persons matching at least one keyword will be returned (i.e. `OR` search).

Examples: 

* `find assignment2`  
Returns `Assignment2` & `assignment2`
  
* `find assginment2 project`  
Returns any tasks having names or tag containing `assignment2`, `Assignment2`,  `project`, `Project`

## Editing a task : `edit`
**We have undo & redo, should be reversible**
**We need to be careful when indexing, if never implement correctly undo/redo will cause duplicate index**
**The app need to double confirmation of the edit command with the user**
**Editing of Tag (Change this part accordingly)**
Deletes the specified task from the **reminder**. reversible.  
Format: `edit INDEX [p][s/START_DATE] [p][e/END_DATE] [p][d/DEADLINE] [t/TAG]..`

> Deletes the task at the specified `INDEX`. 
  The index refers to the index number shown in the most recent listing.

Examples: 

* `list`  
`edit 2 Assignment3`  
edits the 2nd task's name in the **reminder** to Assignment3.

* `find assignment2`  
`edit 1 d/FORMAT`  
edits the 1st task's deadline in the results of the `find` command to new deadline.

## Deleting a task : `delete`
**We have undo & redo, should be reversible**
**We need to be careful when indexing, if never implement correctly undo/redo will cause duplicate index**
**The app need to double confirmation of the delete command with the user**
Deletes the specified task from the **reminder**. **Reversible**.<br>
Format: `delete INDEX`

> Deletes the task at the specified `INDEX`. 
  The index refers to the index number shown in the most recent listing.

Examples: 

* `list`  
`delete 2`  
Deletes the 2nd task in the **reminder**.

* `find assignment2`  
`delete 1`  
Deletes the 1st task in the results of the `find` command.

## Completing a task : `complete`
**We have undo & redo, should be reversible**
**We need to be careful when indexing, if never implement correctly undo/redo will cause duplicate index**
**The app need to double confirmation of the complete command with the user**
**Depend on how we implement this command. We could have a hidden tag from user that it is completed, so we could implement list command to display those without the tag. (TBC)**

Completes the specified task from the **reminder**. **Reversible**.  
Format: `complete INDEX`

> completes the task at the specified `INDEX`. 
  The index refers to the index number shown in the most recent listing.

Examples: 

* `list`  
  `complete 2`  
  Completes the 2nd task in the **reminder**.

* `find assignment2`  
  `complete 1`  
  Completes the 1st task in the results of the `find` command.

## Undo Complete : `???`
**Depend on how we implement this. We could remove tag (see complete command)**
**I don't think we should depend on undo command to undo complete**

## Change Storage File : `???`
**To be fill**

## Sorting : `Sort`
**Sort based on index of reminder, start date, end date, deadline**
**To be fill**

## ???
**As an advanced user I can use shorter versions of a command, so that type a command faster. **


## View **non-private** details of a task : `view`
Displays the **non-private** details of the specified task.<br>
Format: `view INDEX`

> Views the task at the specified `INDEX`. 
  The index refers to the index number shown in the most recent listing.

Examples: 

* `list`  
  `view 2`  
Views the 2nd task in the address book  
  
* `find Betsy`  
  `view 1`
  Views the 1st task in the results of the `find` command.


## View all details of a person : `viewall`
**TBC**
**If there is no private/special view for user, delete this command or edit if needed**
Displays all details (including private details) of the specified person.<br>
Format: `viewall INDEX`

> Views all details of the person at the specified `INDEX`. 
  The index refers to the index number shown in the most recent listing.

Examples: 
* `list`<br>
  `viewall 2`<br>
  Views all details of the 2nd person in the address book.
* `find Betsy`<br> 
  `viewall 1`<br>
  Views all details of the 1st person in the results of the `find` command.

## Undo tasks : `undo`
Undo commands in **reminder**.  
Format: `undo [COUNT]`

**edit this part for undo-ing once**
> Undo the task repeatedly based on the specified `COUNT`. 
  
Examples: 

* `undo`  
  Undo to the previous state of **reminder**.
  
* `undo 2`  
  Undo twice to the state of **reminder**.

> Words in `UPPER_CASE` are the parameters, items in `SQUARE_BRACKETS` are optional, 

## Redo tasks : `redo`
redo commands of undo in **reminder**.  
Format: `redo [COUNT]`

**Have to check the stack if the count of undo is more or equal than the given redo's count before redo-ing**
**edit this part of redo-ing once**
> redo the undo's task repeatedly based on the specified `COUNT`. 
  
Examples: 

* `undo`  
  Undo to the previous state of **reminder**.
  
* `undo 2`  
  Undo twice to the state of **reminder**.

## Clearing all entries : `clear`
Clears all entries from the **reminder**.  
Format: `clear`  

## View themes : `theme`
View all themes supported by the application. 
Format: `theme`  

## Exiting the program : `exit`
Exits the program.  
Format: `exit`  

## Saving the data 
Address book data are saved in the hard disk automatically after any command that changes the data.<br>
There is no need to save manually.

## Changing the save location
Address book data are saved in a file called `addressbook.txt` in the project root folder.
You can change the location by specifying the file path as a program argument.<br>

> The file name must end in `.txt` for it to be acceptable to the program.
>
> When running the program inside Eclipse, you can 
  [set command line parameters before running the program](http://stackoverflow.com/questions/7574543/how-to-pass-console-arguments-to-application-in-eclipse).

## Frequently Asked Questions (FAQ)

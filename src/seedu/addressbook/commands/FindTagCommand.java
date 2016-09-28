package seedu.addressbook.commands;

import seedu.addressbook.data.tag.Tag;
import java.util.*;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class FindTagCommand extends Command {
    
    public static final String COMMAND_WORD = "findtag";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Lists all persons in the address book with the searched tag.\n\t"
            + "Parameters: KEYWORD\n\t"
            + "Example: " + COMMAND_WORD + " owemoney";
    
    public static final String MESSAGE_INVALID_TAG = "Error: Invalid tag name.";

    private String keyword;
    
    public String getKeyword() {
        return keyword; 
    }

    public FindTagCommand(String argument) {
        this.keyword = argument.trim();
    }

    @Override
    public CommandResult execute() {
    	try {
    		final List<ReadOnlyPerson> personsFound = getPersonsWithTag(keyword);
    		return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    	} catch (IllegalValueException e) {
    		return new CommandResult(MESSAGE_INVALID_TAG);
    	}
    }
    
    private List<ReadOnlyPerson> getPersonsWithTag(String keyword) throws IllegalValueException {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        Tag searchedTag;
        searchedTag = new Tag(keyword);
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (person.getTags().contains(searchedTag)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}

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

	private String keyword;
	
	public String getKeyword() {
		return keyword; 
	}

	public FindTagCommand(String argument) {
		this.keyword = argument;
	}

	@Override
	public CommandResult execute() {
		final List<ReadOnlyPerson> personsFound = getPersonsWithTag(keyword);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
	}
	
	private List<ReadOnlyPerson> getPersonsWithTag(String keyword) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
		Tag searchedTag;
		try {
			searchedTag = new Tag(keyword);
	        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
	            if (person.getTags().contains(searchedTag)) {
	                matchedPersons.add(person);
	            }
	        }
		} catch (IllegalValueException e) {
			// TODO: Better error message.
			e.printStackTrace();
		}
        return matchedPersons;
    }

}

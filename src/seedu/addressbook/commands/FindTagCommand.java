package seedu.addressbook.commands;

public class FindTagCommand extends Command {
	
	public static final String COMMAND_WORD = "findtag";
	
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Lists all persons in the address book with the searched tag.\n\t"
            + "Example: " + COMMAND_WORD + " owemoney";

	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		return null;
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

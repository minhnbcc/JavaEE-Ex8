package edu.nbcc.user;

import java.util.regex.Pattern;

public class User implements IUser {

	private String firstName;

	private String lastName;

	private String emailAddress;

	public User() {
	}

	public User(String firstName, String lastName, String emailAddress) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmailAddress(emailAddress);
	}

    /**
     *
     * @param value
     */
    @Override
	public void setFirstName(String value) {
		this.firstName = value;
	}

        @Override
	public String getFirstName() {
		return this.firstName;
	}

    /**
     *
     * @param value
     */
    @Override
	public void setLastName(String value) {
		this.lastName = value;
	}

    /**
     *
     * @return
     */
    @Override
	public String getLastName() {
		return this.lastName;
	}

    /**
     *
     * @param value
     */
    @Override
	public void setEmailAddress(String value) {
		this.emailAddress = value;
	}

    /**
     *
     * @return
     */
    @Override
	public String getEmailAddress() {
		return this.emailAddress;
	}

    /**
     *
     * @return result
     */
    @Override
	public boolean hasRequiredFields() {
		boolean result = true;
		result = (!"".equals(this.firstName) && !"".equals(this.lastName) && !"".equals(this.emailAddress));
		return result;
	}

    /**
     *
     * @return
     */
    @Override
	public boolean isEmailValid() {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (this.emailAddress == null)
			return false;
		return pat.matcher(this.emailAddress).matches();
	}
}

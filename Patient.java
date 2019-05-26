
public class Patient {

	private String pSSN;
	private String pFirstName;
	private String pLastName;
	private String pSex;
	private String pPhoneNumber;
	private String pAddress;

	public Patient(String pSSN, String pFirstName, String pLastName, String pSex, String pPhoneNumber,
			String pAddress) {
		super();
		this.pSSN = pSSN;
		this.pFirstName = pFirstName;
		this.pLastName = pLastName;
		this.pSex = pSex;
		this.pPhoneNumber = pPhoneNumber;
		this.pAddress = pAddress;
	}

	public String getpSSN() {
		return pSSN;
	}

	public void setpSSN(String pSSN) {
		this.pSSN = pSSN;
	}

	public String getpFirstName() {
		return pFirstName;
	}

	public void setpFirstName(String pFirstName) {
		this.pFirstName = pFirstName;
	}

	public String getpLastName() {
		return pLastName;
	}

	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public String getpSex() {
		return pSex;
	}

	public void setpSex(String pSex) {
		this.pSex = pSex;
	}

	public String getpPhoneNumber() {
		return pPhoneNumber;
	}

	public void setpPhoneNumber(String pPhoneNumber) {
		this.pPhoneNumber = pPhoneNumber;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	@Override
	public String toString() {

		return String.format(
				"Doctor [SSN: %s, Last Name: %s, First Name: %s, Sex: %s, Phone Number: %s, Address: %s, Department: %s]\n",
				pSSN, pLastName, pFirstName, pSex, pPhoneNumber, pAddress);
	}

}

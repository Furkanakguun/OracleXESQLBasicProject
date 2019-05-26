
public class Nurse {

	private String nurID;
	private String nurFirstName;
	private String nurLastName;
	private String nurSex;
	private String nurPhoneNumber;
	private String nurAddress;
	private String nurDepartment;

	public Nurse(String nurID, String nurFirstName, String nurLastName, String nurSex, String nurPhoneNumber,
			String nurAddress, String nurDepartment) {
		super();
		this.nurID = nurID;
		this.nurFirstName = nurFirstName;
		this.nurLastName = nurLastName;
		this.nurSex = nurSex;
		this.nurPhoneNumber = nurPhoneNumber;
		this.nurAddress = nurAddress;
		this.nurDepartment = nurDepartment;
	}

	
	public String getNurID() {
		return nurID;
	}


	public void setNurID(String nurID) {
		this.nurID = nurID;
	}


	public String getNurFirstName() {
		return nurFirstName;
	}


	public void setNurFirstName(String nurFirstName) {
		this.nurFirstName = nurFirstName;
	}


	public String getNurLastName() {
		return nurLastName;
	}


	public void setNurLastName(String nurLastName) {
		this.nurLastName = nurLastName;
	}


	public String getNurSex() {
		return nurSex;
	}


	public void setNurSex(String nurSex) {
		this.nurSex = nurSex;
	}


	public String getNurPhoneNumber() {
		return nurPhoneNumber;
	}


	public void setNurPhoneNumber(String nurPhoneNumber) {
		this.nurPhoneNumber = nurPhoneNumber;
	}


	public String getNurAddress() {
		return nurAddress;
	}


	public void setNurAddress(String nurAddress) {
		this.nurAddress = nurAddress;
	}


	public String getNurDepartment() {
		return nurDepartment;
	}


	public void setNurDepartment(String nurDepartment) {
		this.nurDepartment = nurDepartment;
	}


	@Override
	public String toString() {

		return String.format(
				"Doctor [ID: %s, Last Name: %s, First Name: %s, Sex: %s, Phone Number: %s, Address: %s, Department: %s]\n",
				nurID, nurLastName, nurFirstName, nurSex, nurPhoneNumber, nurAddress, nurDepartment);
	}

}

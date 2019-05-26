
public class Doctor {

	private String docID;
	private String docFirstName;
	private String docLastName;
	private String docSex;
	private String docPhoneNumber;
	private String docAddress;
	private String docDepartment;
	private String PatientSSN;

	public Doctor(String docID, String docFirstName, String docLastName, String docSex, String docPhoneNumber,
			String docAddress, String docDepartment,String isPatientID) {
		super();
		this.docID = docID;
		this.docFirstName = docFirstName;
		this.docLastName = docLastName;
		this.docSex = docSex;
		this.docPhoneNumber = docPhoneNumber;
		this.docAddress = docAddress;
		this.docDepartment = docDepartment;
		this.PatientSSN=isPatientID;
	}
	

	public String getPatientSSN() {
		return PatientSSN;
	}


	public void setPatientSSN(String patientSSN) {
		PatientSSN = patientSSN;
	}


	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getDocFirstName() {
		return docFirstName;
	}

	public void setDocFirstName(String docFirstName) {
		this.docFirstName = docFirstName;
	}

	public String getDocLastName() {
		return docLastName;
	}

	public void setDocLastName(String docLastName) {
		this.docLastName = docLastName;
	}

	public String getDocSex() {
		return docSex;
	}

	public void setDocSex(String docSex) {
		this.docSex = docSex;
	}

	public String getDocPhoneNumber() {
		return docPhoneNumber;
	}

	public void setDocPhoneNumber(String docPhoneNumber) {
		this.docPhoneNumber = docPhoneNumber;
	}

	public String getDocAddress() {
		return docAddress;
	}

	public void setDocAddress(String docAddress) {
		this.docAddress = docAddress;
	}

	public String getDocDepartment() {
		return docDepartment;
	}

	public void setDocDepartment(String docDepartment) {
		this.docDepartment = docDepartment;
	}

	@Override
	public String toString() {

		return String.format(
				"Doctor [ID: %s, Last Name: %s, First Name: %s, Sex: %s, Phone Number: %s, Address: %s, Department: %s]\n",
				docID, docLastName, docFirstName, docSex, docPhoneNumber, docAddress, docDepartment);
	}

}

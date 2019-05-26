
public class Room {

	private String rNum;
	private String rType;
	private String rCPN;
	private String NurseID;
	private String PatientID;

	public Room(String rNum, String rType, String rCPN,String NurseID,String PatientID) {
		super();
		this.rNum = rNum;
		this.rType = rType;
		this.rCPN = rCPN;
		this.NurseID=NurseID;
		this.PatientID=PatientID;
	}
	

	public String getPatientID() {
		return PatientID;
	}


	public void setPatientID(String patientID) {
		PatientID = patientID;
	}


	public String getNurseID() {
		return NurseID;
	}


	public void setNurseID(String nurseID) {
		NurseID = nurseID;
	}


	public String getrNum() {
		return rNum;
	}

	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public String getrCPN() {
		return rCPN;
	}

	public void setrCPN(String rCPN) {
		this.rCPN = rCPN;
	}

	@Override
	public String toString() {

		return String.format("Room [Number: %s, Type: %s, Cost/Night: %s]\n", rNum, rType, rCPN);
	}

}

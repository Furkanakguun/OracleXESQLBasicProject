
public class Records {
	
	private String PatientID;
	private String DoctorID;
	private String NurseID;
	private String RoomNo;
	private String BillNum;
	
	public Records(String isPatientID , String isDoctorID , String isNurseID , String isBillNum, String isRoomNo) {
		this.PatientID = isPatientID;
		this.DoctorID = isDoctorID;
		this.NurseID = isNurseID;
		this.RoomNo = isRoomNo;
		this.BillNum =isBillNum;
		
	}

	public String getPatientID() {
		return PatientID;
	}

	public void setPatientName(String patientID) {
		PatientID = patientID;
	}

	public String getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}

	public String getNurseID() {
		return NurseID;
	}

	public void setNurseID(String nurseID) {
		NurseID = nurseID;
	}

	public String getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}

	public String getBillNum() {
		return BillNum;
	}

	public void setBillNum(String billNum) {
		BillNum = billNum;
	}
	
	
	
	
	

}

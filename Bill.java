
public class Bill {

	private String bNum;
	private String total;
	private String dCh;
	private String nCh;
	private String rCh;
	private String dueDate;
	private String PatientID;

	public Bill(String bNum, String total, String dCh, String nCh, String rCh, String dueDate,String PatientID) {
		super();
		this.bNum = bNum;
		this.total=total;
		this.dCh = dCh;
		this.nCh = nCh;
		this.rCh = rCh;
		this.dueDate = dueDate;
		this.PatientID=PatientID;
	
	}
	

	public String getPatientID() {
		return PatientID;
	}


	public void setPatientID(String patientID) {
		PatientID = patientID;
	}


	public String getbNum() {
		return bNum;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getdCh() {
		return dCh;
	}

	public void setdCh(String dCh) {
		this.dCh = dCh;
	}

	public String getnCh() {
		return nCh;
	}

	public void setnCh(String nCh) {
		this.nCh = nCh;
	}

	public String getrCh() {
		return rCh;
	}

	public void setrCh(String rCh) {
		this.rCh = rCh;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {

		return String.format("Bill [Number: %s, Total: %s, Doctor Charge: %s, Nurse Charge: %s, Room Charge: %s, Due Date: %s]\n",
				bNum, dCh, nCh, rCh, dueDate);
	}

}

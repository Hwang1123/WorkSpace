package jdbc.test;

import java.util.Objects;

public class employee {
	String EMP_ID
			,EMP_NAME
			,EMP_NO
			,EMAIL
			,PHONE
			,DEPT_CODE
			,JOB_CODE
			,MANAGER_ID
			,HIRE_DATE
			,ENT_DATE
			,ENT_YN;
	
	int SALARY
		,BONUS;

	public employee() {
		super();
	}

	public employee(String eMP_ID, String eMP_NAME, String eMP_NO, String eMAIL, String pHONE, String dEPT_CODE,
			String jOB_CODE, String mANAGER_ID, String hIRE_DATE, String eNT_DATE, String eNT_YN, int sALARY,
			int bONUS) {
		super();
		EMP_ID = eMP_ID;
		EMP_NAME = eMP_NAME;
		EMP_NO = eMP_NO;
		EMAIL = eMAIL;
		PHONE = pHONE;
		DEPT_CODE = dEPT_CODE;
		JOB_CODE = jOB_CODE;
		MANAGER_ID = mANAGER_ID;
		HIRE_DATE = hIRE_DATE;
		ENT_DATE = eNT_DATE;
		ENT_YN = eNT_YN;
		SALARY = sALARY;
		BONUS = bONUS;
	}

	public String getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}

	public String getEMP_NO() {
		return EMP_NO;
	}

	public void setEMP_NO(String eMP_NO) {
		EMP_NO = eMP_NO;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getDEPT_CODE() {
		return DEPT_CODE;
	}

	public void setDEPT_CODE(String dEPT_CODE) {
		DEPT_CODE = dEPT_CODE;
	}

	public String getJOB_CODE() {
		return JOB_CODE;
	}

	public void setJOB_CODE(String jOB_CODE) {
		JOB_CODE = jOB_CODE;
	}

	public String getMANAGER_ID() {
		return MANAGER_ID;
	}

	public void setMANAGER_ID(String mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}

	public String getHIRE_DATE() {
		return HIRE_DATE;
	}

	public void setHIRE_DATE(String hIRE_DATE) {
		HIRE_DATE = hIRE_DATE;
	}

	public String getENT_DATE() {
		return ENT_DATE;
	}

	public void setENT_DATE(String eNT_DATE) {
		ENT_DATE = eNT_DATE;
	}

	public String getENT_YN() {
		return ENT_YN;
	}

	public void setENT_YN(String eNT_YN) {
		ENT_YN = eNT_YN;
	}

	public int getSALARY() {
		return SALARY;
	}

	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}

	public int getBONUS() {
		return BONUS;
	}

	public void setBONUS(int bONUS) {
		BONUS = bONUS;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(EMP_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof employee) {
			employee E = (employee)obj;
			return E.getEMP_NO() == this.EMP_ID;
		}
		return false;
	}

	@Override
	public String toString() {
		return "employee [EMP_ID=" + EMP_ID + ", EMP_NAME=" + EMP_NAME + ", EMP_NO=" + EMP_NO + ", EMAIL=" + EMAIL
				+ ", PHONE=" + PHONE + ", DEPT_CODE=" + DEPT_CODE + ", JOB_CODE=" + JOB_CODE + ", MANAGER_ID="
				+ MANAGER_ID + ", HIRE_DATE=" + HIRE_DATE + ", ENT_DATE=" + ENT_DATE + ", ENT_YN=" + ENT_YN
				+ ", SALARY=" + SALARY + ", BONUS=" + BONUS + "]";
	}
	
	
}

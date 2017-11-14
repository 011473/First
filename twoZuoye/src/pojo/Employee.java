package pojo;

public class Employee {
	private int eid;
	
	private String ename;
	
	private int companyId;

	public company getComp() {
		return comp;
	}

	public void setComp(company comp) {
		this.comp = comp;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", companyId="
				+ companyId + ", comp=" + comp + "]";
	}

	private company comp;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}

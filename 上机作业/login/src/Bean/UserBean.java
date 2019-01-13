package Bean;
public class UserBean {
	private String username;
	private String gender;
	private String password;
	private String email;
	private String idcard;
	private String birthday;
	private String hobby;
	private String info;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public UserBean(String username, String gender, String password, String email, String idcard, String birthday,
			String hobby, String info) {
		super();
		this.username = username;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.idcard = idcard;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserBean [username=" + username + ", gender=" + gender + ", password=" + password + ", email=" + email
				+ ", idcard=" + idcard + ", birthday=" + birthday + ", hobby=" + hobby + ", info=" + info + "]";
	}
	
	
	
}

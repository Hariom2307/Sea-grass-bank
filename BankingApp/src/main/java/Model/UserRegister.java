package Model;
public class UserRegister {
private String username;
private String Password;
private String email;
private long PhoneNo;
private String City;
public UserRegister(String username, String password, String email, long phoneNo, String city) {
	super();
	this.username = username;
	Password = password;
	this.email = email;
	PhoneNo = phoneNo;
	City = city;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhoneNo() {
	return PhoneNo;
}
public void setPhoneNo(long phoneNo) {
	PhoneNo = phoneNo;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
}
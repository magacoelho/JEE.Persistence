package es.art83.persistence.models.entities;

public class UserDetail {
	private int id;
	private String detail;
	private User user;

	public UserDetail(String detail, User user) {
		this.setDetail(detail);
		this.setUser(user);
	}

	public UserDetail() {
		this("", null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		String u = ", user=(null)";
		if (this.user != null) u = ", userID=(" + this.user.getId() + ")";
		return "UserDetail [id=" + id + ", detail=" + detail + u + "]";
	}

}

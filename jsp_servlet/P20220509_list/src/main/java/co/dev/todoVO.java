package co.dev;

public class todoVO {

	private String id;
	private String title;
	private String checked;
	
	

	public todoVO(String id, String title, String checked) {
		super();
		this.id = id;
		this.title = title;
		this.checked = checked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}

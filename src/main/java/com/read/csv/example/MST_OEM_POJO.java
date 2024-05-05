package com.read.csv.example;

public class MST_OEM_POJO {

	private int id;
	private String name;
	private String code;

	public MST_OEM_POJO(int id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	@Override
	public String toString() {
		return "MST_OEM_POJO [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

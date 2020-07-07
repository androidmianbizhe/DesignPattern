package org.example.pattern.chain;


public class Result {

	/**
	 * 小组长是否同意
	 */
	private boolean customRatify;
	/**
	 * 项目组组长是否同意
	 */
	private boolean groupRatify;
	/**
	 * 项目经理是否同意
	 */
	private boolean managerRatify;
	/**
	 * 部门经理是否同意
	 */
	private boolean departRatify;
	/**
	 * 信息结果
	 */
	private String info;

	public Result(Builder builder) {
		super();
		this.info = builder.info;
		this.customRatify = builder.customRatify;
		this.groupRatify = builder.groupRatify;
		this.managerRatify = builder.managerRatify;
		this.departRatify = builder.departRatify;
	}

	public static class Builder {

		private boolean customRatify;
		private boolean groupRatify;
		private boolean managerRatify;
		private boolean departRatify;
		private String info;

		public Builder(){

		}


		public Builder setCustomRatify(boolean customRatify) {
			this.customRatify = customRatify;
			return this;
		}


		public Builder setGroupRatify(boolean groupRatify) {
			this.groupRatify = groupRatify;
			return this;
		}


		public Builder setManagerRatify(boolean managerRatify) {
			this.managerRatify = managerRatify;
			return this;
		}

		public Builder setDepartRatify(boolean departRatify) {
			this.departRatify = departRatify;
			return this;
		}

		public Builder setInfo(String info){
			this.info = info;
			return this;
		}

		public Builder newResult(Result res){

			this.info = res.info;
			this.customRatify = res.customRatify;
			this.groupRatify = res.groupRatify;
			this.managerRatify = res.managerRatify;
			this.departRatify = res.departRatify;

			return this;
		}

		public Result build(){
			return new Result(this);
		}

	}

	public boolean customRatify() {
		return customRatify;
	}

	public boolean groupRatify() {
		return groupRatify;
	}

	public boolean managerRatify() {
		return managerRatify;
	}

	public boolean departRatify() {
		return departRatify;
	}

	public String info() {
		return info;
	}

	@Override
	public String toString() {
		return "Result [customRatify=" + customRatify + ", groupRatify="
				+ groupRatify + ", managerRatify=" + managerRatify
				+ ", departRatify=" + departRatify + ", info=" + info + "]";
	}


}
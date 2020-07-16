package integer.business;

/**
 * <ul>
 * <li>GREEN(1, "#26ABB8"): 绿色</li>
 * <li>BLUE(2, "#07A6F0"): 蓝色</li>
 * <li>RED(3, "#EB3E58"): 红色</li>
 * </ul>
 */
public enum EnterpriseApprovalGroupColors {
	GREEN(0, "#26ABB8"),
	BLUE(1, "#07A6F0"),
	RED(2, "#EB3E58");

	private Integer id;
	private String color;

	EnterpriseApprovalGroupColors(Integer id, String color) {
		this.id = id;
		this.color = color;
	}

	public Integer getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public static EnterpriseApprovalGroupColors fromCode(Integer number) {
		if (number != null) {
			for (EnterpriseApprovalGroupColors approvalType : EnterpriseApprovalGroupColors.values()) {
				if (number.equals(approvalType.id)) {
					return approvalType;
				}
			}
		}
		return null;
	}
}

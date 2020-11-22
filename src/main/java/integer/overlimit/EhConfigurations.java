package integer.overlimit;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author moubin.mo
 * @date: 2020/11/6 09:28
 */

public class EhConfigurations {
	private static final long serialVersionUID = 97863370L;
	private Long id;
	private Integer namespaceId;
	private String name;
	private String displayName;
	private String value;
	private String description;
	private Integer isReadonly;

	public EhConfigurations() {
	}

	public EhConfigurations(EhConfigurations value) {
		this.id = value.id;
		this.namespaceId = value.namespaceId;
		this.name = value.name;
		this.displayName = value.displayName;
		this.value = value.value;
		this.description = value.description;
		this.isReadonly = value.isReadonly;
	}

	public EhConfigurations(Long id, Integer namespaceId, String name, String displayName, String value, String description, Integer isReadonly) {
		this.id = id;
		this.namespaceId = namespaceId;
		this.name = name;
		this.displayName = displayName;
		this.value = value;
		this.description = description;
		this.isReadonly = isReadonly;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNamespaceId() {
		return this.namespaceId;
	}

	public void setNamespaceId(Integer namespaceId) {
		this.namespaceId = namespaceId;
	}

	@NotNull
	@Size(
			max = 64
	)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(
			max = 128
	)
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@NotNull
	@Size(
			max = 4096
	)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Size(
			max = 256
	)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsReadonly() {
		return this.isReadonly;
	}

	public void setIsReadonly(Integer isReadonly) {
		this.isReadonly = isReadonly;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("EhConfigurations (");
		sb.append(this.id);
		sb.append(", ").append(this.namespaceId);
		sb.append(", ").append(this.name);
		sb.append(", ").append(this.displayName);
		sb.append(", ").append(this.value);
		sb.append(", ").append(this.description);
		sb.append(", ").append(this.isReadonly);
		sb.append(")");
		return sb.toString();
	}
}

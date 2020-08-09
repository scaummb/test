package json.dto;

import java.math.BigDecimal;

/**
 * @author moubin.mo
 * @date: 2020/8/6 20:56
 */

public class BuildingDTO {
	private Long id;
	private String apartmentName;
	private Byte livingStatus;
	private BigDecimal areaSize;
	private String orientation;
	private String buildingName;
	private Byte investmentType;
	private Long communityId;
	private String communityName;

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Byte getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(Byte investmentType) {
		this.investmentType = investmentType;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public Byte getLivingStatus() {
		return livingStatus;
	}

	public void setLivingStatus(Byte livingStatus) {
		this.livingStatus = livingStatus;
	}

	public BigDecimal getAreaSize() {
		return areaSize;
	}

	public void setAreaSize(BigDecimal areaSize) {
		this.areaSize = areaSize;
	}
}

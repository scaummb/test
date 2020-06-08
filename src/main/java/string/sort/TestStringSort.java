package string.sort;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * <p>
 *     HashSet排序：使用TreeSet进行排序
 * </p>
 * @author moubin.mo
 * @date: 2020/6/8 15:12
 */

public class TestStringSort {
	public static void main(String[] args) {
		Map<String,List<ApartmentDTO>> result = new HashMap();
		result.putIfAbsent("", new ArrayList(){{add(new ApartmentDTO("无名号房"));}});
		result.putIfAbsent("3", new ArrayList(){{add(new ApartmentDTO("3楼房"));}});
		result.putIfAbsent("1", new ArrayList(){{add(new ApartmentDTO("1楼房"));}});
		result.putIfAbsent("2", new ArrayList(){{add(new ApartmentDTO("2楼房"));}});
		result.putIfAbsent("22", new ArrayList(){{add(new ApartmentDTO("22楼房"));}});
		result.putIfAbsent("23", new ArrayList(){{add(new ApartmentDTO("23楼房"));}});
		result.putIfAbsent("24", new ArrayList(){{add(new ApartmentDTO("24楼房"));}});
		result.putIfAbsent("9899", new ArrayList(){{add(new ApartmentDTO("9899"));}});
		result.putIfAbsent("12222", new ArrayList(){{add(new ApartmentDTO("12222楼房"));}});
		result.putIfAbsent("1", new ArrayList(){{add(new ApartmentDTO("1楼房"));}});
		result.putIfAbsent("-1", new ArrayList(){{add(new ApartmentDTO("-1楼房"));}});
		result.putIfAbsent("0", new ArrayList(){{add(new ApartmentDTO("0楼房"));}});
		TreeSet<String> keys = sortResult(result);
		System.out.println(JSON.toJSONString(result));

		keys.stream().forEach(
				(key)->{
					System.out.println(JSON.toJSONString(result.get(key)));
		});

	}

	private static TreeSet<String> sortResult(Map<String,List<ApartmentDTO>> result) {
		Set<String> keySet = result.keySet();
		System.out.println(keySet);
		TreeSet<String> tree = new TreeSet(new FloorComparator());
		tree.addAll(keySet);
		System.out.println(tree);
		return tree;
	}
}

class FloorComparator implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		String string1 = (String)o1;
		String string2 = (String)o2;
		if (string1.length() == string2.length()){
			return (string1.compareTo(string2));
		}
		return (string1.length() - string2.length());
	}
}

class ApartmentDTO {
	public ApartmentDTO(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	private Long addressId;
	private Long familyId;
	private String apartmentName;
	private String businessApartmentName;
	private String address;
	private Byte livingStatus;
	private Double areaSize;
	private Double rentArea;
	private Double freeArea;
	private Double chargeArea;
	private String enterpriseName;
	private String apartmentFloor;
	private Byte isLived;
	private String orientation;
	private String namespaceAddressType;
	private String namespaceAddressToken;
	private Long roomFunctionId;
	private Long houseTypeId;
	private Long buildingFloorId;
	private Integer floorNumber;
	private String floorName;
	private Double useArea;
	private Byte investmentType;
	private String buildingName;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getBusinessApartmentName() {
		return businessApartmentName;
	}

	public void setBusinessApartmentName(String businessApartmentName) {
		this.businessApartmentName = businessApartmentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getLivingStatus() {
		return livingStatus;
	}

	public void setLivingStatus(Byte livingStatus) {
		this.livingStatus = livingStatus;
	}

	public Double getAreaSize() {
		return areaSize;
	}

	public void setAreaSize(Double areaSize) {
		this.areaSize = areaSize;
	}

	public Double getRentArea() {
		return rentArea;
	}

	public void setRentArea(Double rentArea) {
		this.rentArea = rentArea;
	}

	public Double getFreeArea() {
		return freeArea;
	}

	public void setFreeArea(Double freeArea) {
		this.freeArea = freeArea;
	}

	public Double getChargeArea() {
		return chargeArea;
	}

	public void setChargeArea(Double chargeArea) {
		this.chargeArea = chargeArea;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getApartmentFloor() {
		return apartmentFloor;
	}

	public void setApartmentFloor(String apartmentFloor) {
		this.apartmentFloor = apartmentFloor;
	}

	public Byte getIsLived() {
		return isLived;
	}

	public void setIsLived(Byte isLived) {
		this.isLived = isLived;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getNamespaceAddressType() {
		return namespaceAddressType;
	}

	public void setNamespaceAddressType(String namespaceAddressType) {
		this.namespaceAddressType = namespaceAddressType;
	}

	public String getNamespaceAddressToken() {
		return namespaceAddressToken;
	}

	public void setNamespaceAddressToken(String namespaceAddressToken) {
		this.namespaceAddressToken = namespaceAddressToken;
	}

	public Long getRoomFunctionId() {
		return roomFunctionId;
	}

	public void setRoomFunctionId(Long roomFunctionId) {
		this.roomFunctionId = roomFunctionId;
	}

	public Long getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(Long houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public Long getBuildingFloorId() {
		return buildingFloorId;
	}

	public void setBuildingFloorId(Long buildingFloorId) {
		this.buildingFloorId = buildingFloorId;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public Double getUseArea() {
		return useArea;
	}

	public void setUseArea(Double useArea) {
		this.useArea = useArea;
	}

	public Byte getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(Byte investmentType) {
		this.investmentType = investmentType;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
}
package nullcase.case1;

/**
 * <ul>
 *     <li>INACTIVE((byte)1): 失效</li>
 *     <li>ACTIVE((byte)2): 生效</li>
 *     <li>LOCKED((byte)3): LOCKED</li>
 *     <li>DELETED((byte)4): 删除</li>
 *     <li>TRAIL((byte) 5): 试用</li>
 *     <li>EXPIRED((byte) 6): 过期</li>
 * </ul>
 */
public enum OrganizationStatus {
    UNTREATED((byte) 0), INACTIVE((byte) 1), ACTIVE((byte) 2), LOCKED((byte) 3), DELETED((byte) 4),
    TRAIL((byte) 5), EXPIRED((byte) 6);

    private byte code;

    private OrganizationStatus(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return this.code;
    }

    public static OrganizationStatus fromCode(Byte code) {
        if (code == null) {
            return null;
        }

        switch (code.byteValue()) {
            case 0:
                return UNTREATED;

            case 1:
                return INACTIVE;

            case 2:
                return ACTIVE;

            case 3:
                return LOCKED;

            case 4:
                return DELETED;
            case 5:
                return TRAIL;
            case 6:
                return EXPIRED;
            default:
                assert (false);
                break;
        }

        return null;
    }
}
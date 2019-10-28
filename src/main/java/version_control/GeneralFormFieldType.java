package version_control;

import org.apache.commons.lang.StringUtils;

/**
 * @author huqi
 */
public enum GeneralFormFieldType {
    /**
     * <ul>
     * <li>SINGLE_LINE_TEXT: 单行文本</li>
     * <li>MULTI_LINE_TEXT: 多行文本</li>
     * <li>NUMBER：数字</li>
     * <li>DATE：日期</li>
     * <li>TIME：时刻</li>
     * <li>RADIO：单选</li>
     * <li>CHECKBOX：多选</li>
     * <li>IMAGE: 图片</li>
     * <li>FILE: 文件</li>
     * <li>SUBFORM：子表单</li>
     * <li>CUSTOM：自定义字段</li>
     * <li>DIVIDER：分行标题</li>
     * </ul>
     */
    SINGLE_LINE_TEXT("SINGLE_LINE_TEXT"), MULTI_LINE_TEXT("MULTI_LINE_TEXT"),
    NUMBER("NUMBER"), DATE("DATE"), TIME("TIME"), RADIO("RADIO"),
    CHECKBOX("CHECKBOX"), IMAGE("IMAGE"), FILE("FILE"),
    SUBFORM("SUBFORM"), CUSTOM("CUSTOM"), DIVIDER("DIVIDER");

    private String code;

    private GeneralFormFieldType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static GeneralFormFieldType fromCode(String code) {
        for (GeneralFormFieldType v : GeneralFormFieldType.values()) {
            if (StringUtils.equals(v.getCode(), code)) {
                return v;
            }
        }
        return null;
    }

}

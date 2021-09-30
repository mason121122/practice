package enums;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Mark Wang
 * @date 2021/9/30
 */
public enum ResultEnum {

    SUCCESS(200, "SUCCESS", "成功"),
    PATH_NOT_FOUND(404, "PATH_NOT_FOUND", "请求地址不存在"),
    UNKNOWN(-1, "UNKNOWN", "未定义错误");

    private int code;
    private String message;
    private String desc;
    ResultEnum(int code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }

    public static ResultEnum valueOf(int code) {
        ResultEnum[] enums = values();
        if (enums.length == 0) {
            return UNKNOWN;
        }
        for (ResultEnum e : enums) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return UNKNOWN;
    }

    public static ResultEnum getByMsg(String message) {
        ResultEnum[] enums = values();
        for (ResultEnum e : enums) {
            if (StringUtils.equals(e.getMessage(), message)) {
                return e;
            }
        }
        return UNKNOWN;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        try {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("code", code)
                    .append("message", message)
                    .append("desc", desc)
                    .toString();
        } catch (Exception e) {
            // NOTICE: 这样做的目的是避免由于toString()的异常导致系统异常终止
            // 大部分情况下，toString()用在日志输出等调试场景
            return super.toString();
        }
    }
}

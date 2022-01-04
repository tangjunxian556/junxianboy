package com.junxian.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Classname: MessageEnum
 * @Date: 2022-01-04 10:26
 * @Author: tang_junXian
 * @Description: 消息枚举类
 */
public enum MessageEnum {

    /** 服务器内部异常 */
    ERROR(500, "服务器内部异常", "inner", "服务器内部异常");

    /** CODE码 */
    private final int code;
    /** 中文注释 */
    private final String cn;
    /** 英文注释 */
    private final String en;
    /** 繁文注释 */
    private final String cns;

    public int getCode() {
        return code;
    }

    public String getCn() {
        return cn;
    }

    public String getEn() {
        return en;
    }

    public String getCns() {
        return cns;
    }

    MessageEnum(int code, String cn, String en, String cns) {
        this.code = code;
        this.cn = cn;
        this.en = en;
        this.cns = cns;
    }

    /**
     * 获取指定语言类型的异常说明
     * @param code CODE码
     * @param type 语言类型
     * @return 异常说明
     */
    public static String getMessage(int code, int type) {
        Optional<MessageEnum> optional = Arrays.stream(MessageEnum.values())
                .filter(p -> p.getCode() == code)
                .findFirst();
        if (optional.isPresent()){
            MessageEnum statusEnum = optional.get();
            switch (type) {
                case 1:
                    return statusEnum.getCn();
                case 2:
                    return statusEnum.getEn();
                case 3:
                    return statusEnum.getCns();
                default:
                    return "服务器内部异常！！！";
            }
        }
        else{
            System.out.println("找不到指定的枚举项");
            return "服务器内部异常！！！";
        }
    }

}

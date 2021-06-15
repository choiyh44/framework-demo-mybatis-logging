package kr.co.ensmart.frameworkdemo.common.dto.base;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseCommonEntity implements Serializable {
	private static final long serialVersionUID = 8553799789863519137L;

	private Timestamp sysRegDtime;
	private String sysRegDtimeStr;
	private String sysRegrId;
	private String sysRegrNm;

	private Timestamp sysModDtime;
	private String sysModDtimeStr;
	private String sysModrId;
	private String sysModrNm;

	private String state;

}

package com.shizg.smartme.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceData {

	@TableId(value = "id",type = IdType.AUTO)
	private Long id;

	/**
	 * 产品分类
	 */
	private String category;

	/**
	 * 网关mac
	 */
	private String gatewayMac;

	/**
	 * 设备编号
	 */
	private String deviceId;

	/**
	 * 属性code
	 */
	private String attrCode;

	/**
	 * 属行值
	 */
	private String attrVal;

	/**
	 * 状态持续开始时间
	 */
	private Date startTime;

	/**
	 * 状态持续结束时间
	 */
	private Date endTime;
}

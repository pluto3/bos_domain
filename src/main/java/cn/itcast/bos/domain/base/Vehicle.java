package cn.itcast.bos.domain.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:车辆
 */
@Entity
@Table(name = "T_VEHICLE")
@Getter
@Setter
public class Vehicle implements Serializable{

	private static final long serialVersionUID = -95078157318544655L;
	
	@Id
	@GeneratedValue
	@Column(name = "C_ID")
	private Integer id;
	@Column(name = "C_ROUTE_TYPE")
	private String routeType; // 线路类型
	@Column(name = "C_ROUTE_NAME")
	private String routeName; // 线路名称
	@Column(name = "C_SNIPPER")
	private String shipper; // 承运商
	@Column(name = "C_DRIVER")
	private String driver; // 司机
	@Column(name = "C_VEHICLE_NUM")
	private String vehicleNum; // 车牌号
	@Column(name = "C_TELEPHONE")
	private String telephone; // 电话
	@Column(name = "C_VEHICLE_TYPE")
	private String vehicleType;// 车型
	@Column(name = "C_TON")
	private Integer ton; // 吨控
	@Column(name = "C_REMARK")
	private String remark;// 备注

}

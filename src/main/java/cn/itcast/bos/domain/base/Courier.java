package cn.itcast.bos.domain.base;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:快递员
 */
@Entity
@Table(name = "T_COURIER")
@Getter
@Setter
public class Courier implements Serializable{

	private static final long serialVersionUID = -2048328068793192357L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "C_ID")
	private Integer id; // 主键
	@Column(name = "C_COURIER_NUM", unique = true)
	private String courierNum; // 快递员工号
	@Column(name = "C_NAME")
	private String name; // 快递员姓名
	@Column(name = "C_TELEPHONE")
	private String telephone; // 快递员联系电话
	@Column(name = "C_PDA")
	private String pda; // PDA号
	@Column(name = "C_DELTAG")
	private Character deltag; // 作废标志 1 为标记作废
	@Column(name = "C_CHECK_PWD")
	private String checkPwd; // 查台密码
	@Column(name = "C_TYPE")
	private String type; // 取件员类型
	@Column(name = "C_COMPANY")
	private String company; // 单位
	@Column(name = "C_VEHICLE_TYPE")
	private String vehicleType; // 车辆类型
	@Column(name = "C_VEHICLE_NUM")
	private String vehicleNum; // 车牌号

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "C_STANDARD_ID")
	private Standard standard;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "C_TAKETIME_ID")
	private TakeTime takeTime;

	@ManyToMany(mappedBy = "couriers")
	private Set<FixedArea> fixedAreas = new HashSet<FixedArea>();

	@PrePersist//设置保存初始值
	public void initDataPresist() {
		this.deltag = '0';
	}

}

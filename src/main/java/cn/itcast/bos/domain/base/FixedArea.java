package cn.itcast.bos.domain.base;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:定区
 */
@Entity
@Table(name = "T_FIXED_AREA")
@Getter
@Setter
public class FixedArea implements Serializable{

	private static final long serialVersionUID = 8660717223027836412L;
	
	@Id
	@Column(name = "C_ID")
	private String id; // 主键
	@Column(name = "C_FIXED_AREA_NAME", unique = true)
	private String fixedAreaName; // 定区名称
	@Column(name = "C_FIXED_AREA_LEADER", unique = true)
	private String fixedAreaLeader;// 定区负责人
	@Column(name = "C_TELEPHONE")
	private String telephone;// 联系电话
	@Column(name = "C_COMPANY")
	private String company; // 所属单位

	@Column(name = "C_OPERATING_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date operatingTime;// 操作时间
	@Column(name = "C_OPERATOR")
	private String operator; // 操作员
	@Column(name = "C_OPERATING_COMPANY")
	private String operatingCompany; // 操作单位
	@JsonIgnore
	@OneToMany(mappedBy = "fixedArea")
	private Set<SubArea> subareas = new HashSet<SubArea>(0);

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "T_FIXEDAREA_COURIER", joinColumns = {
			@JoinColumn(name = "C_FIXED_AREA_ID", referencedColumnName = "C_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "C_COURIER_ID", referencedColumnName = "C_ID") })
	private Set<Courier> couriers = new HashSet<Courier>(0);

	// @JSON(serialize = false)
	// public Set<SubArea> getSubareas() {
	// return subareas;
	// }

	// @JSON(serialize=false)
	// public Set<Courier> getCouriers() {
	// return couriers;
	// }

}

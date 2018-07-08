package cn.itcast.bos.domain.base;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:地域信息实体类，主要包含 省市区(县)
 */
@Entity
@Table(name = "T_AREA")
@Getter
@Setter
public class Area implements Serializable{

	private static final long serialVersionUID = -2524889495599889912L;
	
	@Id
	@Column(name = "C_ID")
	private String id;
	@Column(name = "C_PROVINCE")
	private String province; // 省
	@Column(name = "C_CITY")
	private String city; // 城市
	@Column(name = "C_DISTRICT")
	private String district; // 区域
	@Column(name = "C_POSTCODE")
	private String postcode; // 邮编
	@Column(name = "C_CITYCODE")
	private String citycode; // 城市编码
	@Column(name = "C_SHORTCODE")
	private String shortcode; // 简码

	@OneToMany(mappedBy = "area")
	private Set<SubArea> subareas = new HashSet<SubArea>();

	// 添加一个字段：json插件就调用getter转json
	@Transient // 阻止该属性被序列化数据库
	public String getName() {
		return province + city + district;
	}

}

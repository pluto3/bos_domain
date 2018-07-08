package cn.itcast.bos.domain.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:分区
 */
@Entity
@Table(name = "T_SUB_AREA")
@Getter
@Setter
public class SubArea implements Serializable{
	
	private static final long serialVersionUID = -4027960745460184079L;
	
	@Id
	@Column(name = "C_ID")
	private String id;
	@Column(name = "C_START_NUM")
	private String startNum; // 起始号
	@Column(name = "C_ENDNUM")
	private String endNum; // 终止号
	@Column(name = "C_SINGLE")
	private Character single; // 单双号
	@Column(name = "C_KEY_WORDS")
	private String keyWords; // 关键字
	@Column(name = "C_ASSIST_KEY_WORDS")
	private String assistKeyWords; // 辅助关键字

	@ManyToOne
	@JoinColumn(name = "C_AREA_ID")
	private Area area; // 区域
	@ManyToOne
	@JoinColumn(name = "C_FIXEDAREA_ID")
	private FixedArea fixedArea; // 定区

}

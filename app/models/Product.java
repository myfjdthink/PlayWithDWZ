package models;

import interfaces.NameAble;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import util.NumberUtil;

@Entity
@Table(name = "product")
public class Product extends BaseModel {

	@Required
	@MaxSize(60)
	@MinSize(1)
	@Match(value = "^\\w*$", message = "Not a valid username")
	// 货号/名称
	public String productName;
	@Required
	public String color;

	public Users client;
	// 全尺寸单价
	@Required
	public Double fullUnit;
	// 产品尺寸 %
	@Required
	public Double size;

	public Double actualUnit;

	public String toString() {
		return "产品(" + productName + ")";
	}

	public boolean isAdd() {
		return id == null;
	}

	public Double getActualUnit() {
		return NumberUtil.toDouble(fullUnit, 0d)
				* NumberUtil.toDouble(size, 0d);
	}

	public void setActualUnit(Double actualUnit) {
		this.actualUnit = actualUnit;
	}

}

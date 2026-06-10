package bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Store: Cửa hàng 
 * + id: mã cửa hàng 
 * + desc: mô tả 
 * + potential: số mặt hàng cần có để bán 
 * + whId: mã kho, kho hàng chuyển mặt hàng đến cửa hàng
 */
public class Store {

	private Long id;
	private String desc;
	private BigDecimal potential;
	private Long whId;

	public Store() {
	}

	public Store(Long id, String desc, BigDecimal potential, Long whId) {
		this.id = id;
		this.desc = desc;
		this.potential = potential;
		this.whId = whId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public BigDecimal getPotential() {
		return potential;
	}

	public void setPotential(BigDecimal potential) {
		this.potential = potential;
	}

	public Long getWhId() {
		return whId;
	}

	public void setWhId(Long whId) {
		this.whId = whId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Store)) {
			return false;
		}

		Store that = (Store) o;

		return getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", desc=" + desc + ", potential=" + potential + ", whId=" + whId + "]";
	}
}
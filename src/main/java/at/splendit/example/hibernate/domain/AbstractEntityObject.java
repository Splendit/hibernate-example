package at.splendit.example.hibernate.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@MappedSuperclass
public abstract class AbstractEntityObject<T extends Serializable> implements Serializable {

	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	@Override
	@Transient
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(17, 37, this, false, AbstractEntityObject.class);
	}

	@Override
	@Transient
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false, AbstractEntityObject.class);
	}

	@Override
	@Transient
	public String toString() {
		return ReflectionToStringBuilder.toString(this, null, false, false, AbstractEntityObject.class);
	}

}

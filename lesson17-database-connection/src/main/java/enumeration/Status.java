package enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Status {

	Active(1), Disabled(0);

	private final int value;
	
	private static final Map<Integer, Status> VALUE_ENUM_MAP = new HashMap<>();

	static {
		for (Status status : Status.values()) {
			VALUE_ENUM_MAP.put(status.value, status);
		}
	}

	Status(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static Status getName(int value) {
		return VALUE_ENUM_MAP.get(value);
	}

}

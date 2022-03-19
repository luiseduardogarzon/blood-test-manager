package co.api.bloodtestmanager.constant;

public enum EComponent {

	SUGAR("SUGAR"), FAT("FAT"), OXYGEN("OXYGEN");

	private String value;

	EComponent(String value) {
		this.value = value;
	}

	public static EComponent getEComponent(String value) {
		EComponent eComponent = null;
		for (EComponent component : values()) {
			if (component.value.equalsIgnoreCase(value)) {
				eComponent = component;
				break;
			}
		}
		return eComponent;
	}
}
